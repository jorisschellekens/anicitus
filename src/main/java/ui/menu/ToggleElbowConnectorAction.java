package ui.menu;

import com.mxgraph.util.mxConstants;
import ui.AbstractIconAction;
import ui.GraphFrame;
import ui.graph.Graph;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ToggleElbowConnectorAction extends AbstractIconAction{

    private GraphFrame graphFrame;

    public ToggleElbowConnectorAction(GraphFrame graphFrame)
    {
        super("", "img/segment-path.png");
        putValue(Action.SHORT_DESCRIPTION, "toggle edge style");
        this.graphFrame = graphFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Graph g = graphFrame.getGraph();
        String edgeStyle = (String) g.getStylesheet().getDefaultEdgeStyle().get(mxConstants.STYLE_EDGE);
        if(edgeStyle == null) {
            g.getStylesheet().getDefaultEdgeStyle().put(mxConstants.STYLE_EDGE, mxConstants.EDGESTYLE_ELBOW);
            g.refresh();
        }else
        {
            g.getStylesheet().getDefaultEdgeStyle().remove(mxConstants.STYLE_EDGE);
            g.refresh();
        }
    }
}
