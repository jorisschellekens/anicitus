package model;

import ui.graph.Graph;

import java.util.*;

/**
 * Created by joris on 10/14/17.
 */
public class Executor {

    public static void execute(Graph g)
    {
        // determine which blocks can be (initially) executed
        Set<IBlock> todo = new HashSet<>();
        for(IBlock block : g.getVertices())
        {
            if(block.countInputs() == 0)
                todo.add(block);
        }

        if(todo.isEmpty())
            return;

        // keep track of the parameters going into each block
        Map<IBlock, Object[]> parameters = new HashMap<>();

        // keep track of edges we have already visited
        Set<IBlock[]> visitedEdges = new HashSet<>();

        // visit each node
        for(IBlock block : todo)
            visit(block, g, parameters, visitedEdges);
    }

    private static void visit(IBlock source, Graph graph, Map<IBlock, Object[]> params,  Set<IBlock[]> visited)
    {

        boolean hasAllArguments = false;
        if(source.countInputs() == 0) {
            hasAllArguments = true;
        }
        else
        {
            int argsMissing = source.countInputs();
            if(params.containsKey(source))
            {
                Object[] par = params.get(source);
                for(int i=0;i<par.length;i++)
                    if(par[i] != null)
                        argsMissing--;
            }
            hasAllArguments = (argsMissing == 0);
        }

        if(!hasAllArguments)
            return;

        // execute this block
        Object[] result = source.process(params.get(source));

        // delegate to children
        IBlock[] targets = graph.getBlocksForOutgoingEdges(source);
        for(int i=0;i<targets.length;i++)
        {
            IBlock target = targets[i];
            if(visited.contains(new Object[]{source, target}))
                continue;

            // update arguments
            if(!params.containsKey(target))
                params.put(target, new Object[target.countInputs()]);
            int j = Arrays.asList(graph.getBlocksForIncomingEdges(target)).indexOf(source);
            params.get(target)[j] = result[i];

            // update visited
            visited.add(new IBlock[]{source, target});

            // recursion
            visit(target, graph, params, visited);
        }

    }

}
