package ui.menu;

import ui.AbstractIconAction;
import ui.GraphFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ZoomInAction extends AbstractIconAction{

    private GraphFrame graphFrame;

    public ZoomInAction(GraphFrame graphFrame)
    {
        super("", "img/zoom-in.png");
        putValue(Action.SHORT_DESCRIPTION, "zoom in");
        this.graphFrame = graphFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        graphFrame.getGraphComponent().zoomIn();
    }
}
