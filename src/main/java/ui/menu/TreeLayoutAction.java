package ui.menu;

import com.mxgraph.layout.mxCompactTreeLayout;
import ui.AbstractIconAction;
import ui.GraphFrame;
import ui.graph.Graph;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by joris on 10/18/17.
 */
public class TreeLayoutAction extends AbstractIconAction {

    private GraphFrame graphFrame;

    public TreeLayoutAction(GraphFrame graphFrame)
    {
        super("", "img/layout.png");
        putValue(Action.SHORT_DESCRIPTION, "layout graph");
        this.graphFrame = graphFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Graph g = graphFrame.getGraph();
        new mxCompactTreeLayout(g).execute(g.getDefaultParent());
    }
}
