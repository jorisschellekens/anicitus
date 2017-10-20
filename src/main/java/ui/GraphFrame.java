package ui;

import com.mxgraph.swing.handler.mxRubberband;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxMultiplicity;
import ui.graph.Graph;
import ui.graph.GraphKeyListener;
import ui.menu.*;
import ui.popup.GraphPopupMenu;
import ui.popup.MousePopupListener;

import javax.swing.*;
import java.awt.Color;

public class GraphFrame extends JFrame {

    private Graph graph;
    private mxGraphComponent graphComponent;

    public GraphFrame()
    {
        initComponents(new Graph());
    }

    private void initComponents(Graph graph)
    {
        // init to empty graph
        setGraph(graph);

        // limit edge connectivity
        graph.setMultigraph(false);
        graph.setAllowDanglingEdges(false);
        graph.setAllowLoops(false);

        // allow rubber band selection
        new mxRubberband(graphComponent);

        // menu
        JMenuBar menuBar = new JMenuBar();

        // 'file' menu
        JMenu fileMenu = new JMenu("File");
        fileMenu.add(new NewGraphAction(this));
        fileMenu.add(new OpenGraphAction(this));
        fileMenu.add(new SaveGraphAction(this));
        menuBar.add(fileMenu);


        // toolbar
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(new JToolBar().add(new ExecuteGraphAction(this)));
        menuBar.add(new JToolBar().add(new ToggleElbowConnectorAction(this)));
        menuBar.add(new JToolBar().add(new ToggleGridAction(this)));
        menuBar.add(new JToolBar().add(new ZoomInAction(this)));
        menuBar.add(new JToolBar().add(new ZoomOutAction(this)));
        menuBar.add(new JToolBar().add(new TreeLayoutAction(this)));

        // set bar
        setJMenuBar(menuBar);

        // addVertex
        add(graphComponent);

        // pack
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public GraphFrame setGraph(Graph graph)
    {
        // graph component
        this.graph = graph;
        graphComponent = new mxGraphComponent(graph);
        graphComponent.getViewport().setOpaque(true);
        graphComponent.getViewport().setBackground(Color.WHITE);
        graphComponent.setGridVisible(true);
        graphComponent.setGridStyle(mxGraphComponent.GRID_STYLE_DOT);
        graphComponent.addKeyListener(new GraphKeyListener(graphComponent));
        graphComponent.getGraphControl().addMouseListener(new MousePopupListener(new GraphPopupMenu(graph)));
        graphComponent.refresh();

        // return
        return this;
    }

    public Graph getGraph()
    {
        return graph;
    }

    public mxGraphComponent getGraphComponent()
    {
        return graphComponent;
    }
}
