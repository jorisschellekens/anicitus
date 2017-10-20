package model;

import block.IBlockFactoryEnum;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mxgraph.model.mxCell;
import ui.graph.Graph;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonGraphIO {

    static class IBlockConnection
    {
        public int sourceID;
        public int sourcePort;
        public int targetID;
        public int targetPort;
        public IBlockConnection(int sourceID, int sourcePort, int targetID, int targetPort)
        {
            this.sourceID = sourceID;
            this.sourcePort = sourcePort;
            this.targetID = targetID;
            this.targetPort = targetPort;
        }
    }

    static class IBlockData
    {
        public String[] args;
        public String blockType;
        public int x;
        public int y;
        public int ID;
        public IBlockConnection[] connections;
        public IBlockData(IBlock block, int x, int y, int ID)
        {
            this.args = block.getArgs();
            this.blockType = block.getClass().getSimpleName();
            this.x = x;
            this.y = y;
            this.ID = ID;
        }
    }

    public static void store(Graph graph, File outputFile) throws IOException
    {
        Map<IBlock, IBlockData> blockMap = new HashMap<>();
        Object[] selection = graph.getSelectionCells();
        graph.selectAll();
        for(Object mxObj : graph.getSelectionCells())
        {
            mxCell cell = (mxCell) mxObj;
            if(!cell.isVertex())
                continue;

            IBlock block = (IBlock) cell.getValue();
            if(block == null)
                continue;

            int x = (int) cell.getGeometry().getX();
            int y = (int) cell.getGeometry().getY();
            int ID = blockMap.size();

            blockMap.put(block, new IBlockData(block, x, y, ID));
        }
        graph.setSelectionCells(selection);

        for(IBlock block : blockMap.keySet())
        {
            List<IBlockConnection> connections = new ArrayList<>();

            int sourceID = blockMap.get(block).ID;
            IBlock[] targets = graph.getBlocksForOutgoingEdges(block);
            for(int i=0;i<targets.length;i++)
            {
                IBlock target = targets[i];
                int targetID = blockMap.get(target).ID;
                int j = Arrays.asList(graph.getBlocksForIncomingEdges(target)).indexOf(block);
                connections.add(new IBlockConnection(sourceID, i, targetID, j));
            }
            blockMap.get(block).connections = connections.toArray(new IBlockConnection[connections.size()]);
        }

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String txt = gson.toJson(blockMap.values());
        Writer writer = new BufferedWriter(new FileWriter(outputFile));
        writer.write(txt);
        writer.flush();
        writer.close();
    }

    public static void load(Graph graph, File inputFile) throws IOException
    {
        String txt = new String(Files.readAllBytes(inputFile.toPath()));
       IBlockData[] data = new Gson().fromJson(txt, IBlockData[].class);

        Map<Integer, IBlock> blockToID = new HashMap<>();
        for(IBlockData bd : data)
        {
            String[] args = bd.args;
            String blockType = bd.blockType;
            IBlock block = (args == null || args.length == 0) ? IBlockFactoryEnum.lookupFactory(blockType).build() : IBlockFactoryEnum.lookupFactory(blockType).build(args);
            graph.addVertex(block, bd.x, bd.y);
            blockToID.put(bd.ID, block);
        }


        for(IBlockData bd : data) {
            for (IBlockConnection c : bd.connections) {
                graph.addEdge(blockToID.get(c.sourceID), c.sourcePort, blockToID.get(c.targetID), c.targetPort);
            }
        }

    }
}