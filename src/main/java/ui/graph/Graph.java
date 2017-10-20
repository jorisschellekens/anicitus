package ui.graph;

import block.IBlockFactoryEnum;
import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxGeometry;
import com.mxgraph.util.mxPoint;
import com.mxgraph.view.mxGraph;
import model.IBlock;
import model.IBlockFactory;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by joris on 10/14/17.
 */
public class Graph extends mxGraph implements Serializable {

    private static final int BLOCK_HEIGHT = 50;
    private static final int BLOCK_WIDTH = 100;
    private static final int PORT_DIAMETER = 10;
    private static final int PORT_RADIUS = PORT_DIAMETER / 2;

    public Graph() {
    }

    @Override
    public boolean isCellFoldable(Object cell, boolean collapse) {
        return false;
    }

    private String toHexColor(Color c) {
        int r = c.getRed();
        int g = c.getGreen();
        int b = c.getBlue();
        return String.format("#%02x%02x%02x", r, g, b);
    }

    public void addVertex(IBlock block, int x, int y) {

        IBlockFactory blockFactory = IBlockFactoryEnum.lookupFactory(block);

        Object parent = getDefaultParent();
        mxCell v1 = (mxCell) insertVertex(parent, null, block, x, y, BLOCK_WIDTH, BLOCK_HEIGHT, "fillColor=" + toHexColor(blockFactory.getColor()));
        v1.setConnectable(false);

        // addVertex input ports
        for (int i = 0; i < block.countInputs(); i++) {
            double portY = (1.0 / (block.countInputs() + 1)) * (i + 1);
            mxGeometry portGeo = new mxGeometry(0, portY, PORT_DIAMETER, PORT_DIAMETER);
            portGeo.setOffset(new mxPoint(-PORT_RADIUS, -PORT_RADIUS));
            portGeo.setRelative(true);

            mxCell port = new mxCell(null, portGeo, "shape=ellipse;perimter=ellipsePerimeter");
            port.setVertex(true);

            addCell(port, v1);
        }

        // addVertex output ports
        for (int i = 0; i < block.countOutputs(); i++) {
            double portY = (1.0 / (block.countOutputs() + 1)) * (i + 1);
            mxGeometry portGeo = new mxGeometry(1, portY, PORT_DIAMETER, PORT_DIAMETER);
            portGeo.setOffset(new mxPoint(-PORT_RADIUS, -PORT_RADIUS));
            portGeo.setRelative(true);

            mxCell port = new mxCell(null, portGeo, "shape=ellipse;perimter=ellipsePerimeter");
            port.setVertex(true);

            addCell(port, v1);
        }

    }

    public void addEdge(IBlock source, int sourceIndex, IBlock target, int targetIndex)
    {
        mxCell sourceCell = lookup(source);
        if(sourceCell == null)
            return;

        mxCell targetCell = lookup(target);
        if(targetCell == null)
            return;

        // outgoing ports
        List<Object[]> outPorts = new ArrayList<>();
        for(int i=0;i<sourceCell.getChildCount();i++)
        {
            mxCell portCell = (mxCell) sourceCell.getChildAt(i);
            if(!portCell.getGeometry().isRelative())
                continue;
            if(portCell.getGeometry().getX() != 1.0)
                continue;
            int y = (int) (portCell.getGeometry().getY() * sourceCell.getGeometry().getHeight());
            outPorts.add(new Object[]{y, portCell});
        }
        sortByArg(outPorts, 0);

        // incoming ports
        List<Object[]> inPorts = new ArrayList<>();
        for(int i=0;i<targetCell.getChildCount();i++)
        {
            mxCell portCell = (mxCell) targetCell.getChildAt(i);
            if(!portCell.getGeometry().isRelative())
                continue;
            if(portCell.getGeometry().getX() != 0.0)
                continue;
            int y = (int) (portCell.getGeometry().getY() * targetCell.getGeometry().getHeight());
            inPorts.add(new Object[]{y, portCell});
        }
        sortByArg(inPorts, 0);

        // incoming ports
        this.insertEdge(getDefaultParent(), null, "", outPorts.get(sourceIndex)[1], inPorts.get(targetIndex)[1]);
    }

    public IBlock[] getVertices() {
        // select all
        Object[] selection = getSelectionCells();
        selectAll();

        List<IBlock> vertexList = new ArrayList<>();
        for (Object obj : getSelectionCells()) {
            mxCell cell = (mxCell) obj;
            if (!cell.isVertex())
                continue;
            if (cell.getValue() instanceof IBlock) {
                vertexList.add((IBlock) cell.getValue());
            }
        }

        // restore selection
        setSelectionCells(selection);

        // return
        return vertexList.toArray(new IBlock[vertexList.size()]);
    }

    private mxCell lookup(IBlock block) {
        Object[] selection = getSelectionCells();
        selectAll();
        for (Object obj : getSelectionCells()) {
            mxCell cell = (mxCell) obj;
            if (!cell.isVertex())
                continue;
            if (cell.getValue().equals(block)) {
                setSelectionCells(selection);
                return cell;
            }
        }
        setSelectionCells(selection);
        return null;
    }

    private List<Object[]> sortByArg(List<Object[]> l, final int i)
    {
        java.util.Collections.sort(l, new Comparator<Object[]>() {
            @Override
            public int compare(Object[] o1, Object[] o2) {
                Comparable c0 = (Comparable) o1[i];
                Comparable c1 = (Comparable) o2[i];
                return c0.compareTo(c1);
            }
        });
        return l;
    }

    public IBlock[] getBlocksForOutgoingEdges(IBlock source)
    {
        mxCell sourceCell = lookup(source);
        if(sourceCell == null)
            return new IBlock[0];

        /*
         * This logic handles ports
         * although ports make the application esthetically pleasing, they are hard to implement
         */
        List<Object[]> destinations = new ArrayList<>();
        for(int i=0;i<sourceCell.getChildCount();i++)
        {
            mxCell portCell = (mxCell) sourceCell.getChildAt(i);
            if(!portCell.getGeometry().isRelative())
                continue;
            if(portCell.getGeometry().getX() != 1.0)
                continue;
            mxCell otherSide = portCell.getEdgeCount() == 1 ? (mxCell) portCell.getEdgeAt(0).getTerminal(false).getParent() : null;
            if(otherSide == null || otherSide.getValue() == null)
                continue;
            int y = (int) (portCell.getGeometry().getY() * sourceCell.getGeometry().getHeight());
            destinations.add(new Object[]{y, otherSide.getValue()});
        }

        /*
         * This logic handles direct connections
         * funnily enough, this also captures ports sometimes
         */
        for(Object obj : getOutgoingEdges(sourceCell))
        {
            mxCell edgeCell = (mxCell) obj;
            if(!edgeCell.isEdge())
                continue;
            int y = (int) edgeCell.getGeometry().getSourcePoint().getY();
            destinations.add(new Object[]{y, edgeCell.getTarget().getValue()});
        }

        // sort by y-coordinate
        destinations = sortByArg(destinations, 0);

        // reduce dimensionality
        IBlock[] out = new IBlock[destinations.size()];
        for(int i=0;i<destinations.size();i++)
            out[i] = (IBlock) destinations.get(i)[1];

        return out;
    }

    public IBlock[] getBlocksForIncomingEdges(IBlock target)
    {
        mxCell targetCell = lookup(target);
        if(targetCell == null)
            return new IBlock[0];

        /*
         * This logic handles ports
         * although ports make the application esthetically pleasing, they are hard to implement
         */
        List<Object[]> sources = new ArrayList<>();
        for(int i=0;i<targetCell.getChildCount();i++)
        {
            mxCell portCell = (mxCell) targetCell.getChildAt(i);
            if(!portCell.getGeometry().isRelative())
                continue;
            if(portCell.getGeometry().getX() != 0.0)
                continue;
            mxCell otherSide = portCell.getEdgeCount() == 1 ? (mxCell) portCell.getEdgeAt(0).getTerminal(true).getParent() : null;
            if(otherSide == null || otherSide.getValue() == null)
                continue;
            int y = (int) (portCell.getGeometry().getY() * targetCell.getGeometry().getHeight());
            sources.add(new Object[]{y, otherSide.getValue()});
        }

        /*
         * This logic handles direct connections
         * funnily enough, this also captures ports sometimes
         */
        for(Object obj : getIncomingEdges(targetCell))
        {
            mxCell edgeCell = (mxCell) obj;
            if(!edgeCell.isEdge())
                continue;
            int y = (int) edgeCell.getGeometry().getTargetPoint().getY();
            sources.add(new Object[]{y, edgeCell.getSource().getValue()});
        }

        // sort by y-coordinate
        sources = sortByArg(sources, 0);

        // reduce dimensionality
        IBlock[] out = new IBlock[sources.size()];
        for(int i=0;i<sources.size();i++)
            out[i] = (IBlock) sources.get(i)[1];

        return out;
    }

    public void printDebugGraph()
    {
        for(IBlock block : getVertices())
        {
            System.out.println(block + "\t[" + block.getName() + "]");
            IBlock[] targets = getBlocksForOutgoingEdges(block);
            for(int i=0;i<targets.length;i++)
            {
                System.out.println("\t-->\t" + i + "\t" + targets[i]);
            }
            IBlock[] sources = getBlocksForIncomingEdges(block);
            for(int i=0;i<sources.length;i++)
            {
                System.out.println("\t<--\t" + i + "\t" + sources[i]);
            }
        }
    }
}