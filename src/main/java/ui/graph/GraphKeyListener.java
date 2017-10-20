package ui.graph;

import com.mxgraph.swing.mxGraphComponent;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by joris on 10/14/17.
 */
public class GraphKeyListener extends KeyAdapter {

    private final mxGraphComponent graphComponent;

    public GraphKeyListener(mxGraphComponent graphComponent)
    {
        this.graphComponent = graphComponent;
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() != KeyEvent.VK_DELETE)
            return;
        for(Object o : graphComponent.getGraph().getSelectionCells())
        {
            // ports can not be deleted
            if(graphComponent.getGraph().isPort(o))
                continue;
            graphComponent.getGraph().removeCells(new Object[]{o});
        }
    }

}
