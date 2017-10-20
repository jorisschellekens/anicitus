package ui.menu;

import ui.AbstractIconAction;
import ui.GraphFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by joris on 10/17/17.
 */
public class ZoomOutAction extends AbstractIconAction {

    private GraphFrame graphFrame;

    public ZoomOutAction(GraphFrame graphFrame)
    {
        super("", "img/zoom-out.png");
        putValue(Action.SHORT_DESCRIPTION, "zoom out");
        this.graphFrame = graphFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        graphFrame.getGraphComponent().zoomOut();
    }
}
