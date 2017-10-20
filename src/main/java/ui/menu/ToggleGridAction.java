package ui.menu;

import com.mxgraph.swing.mxGraphComponent;
import ui.AbstractIconAction;
import ui.GraphFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ToggleGridAction extends AbstractIconAction{

    private GraphFrame graphFrame;

    public ToggleGridAction(GraphFrame graphFrame)
    {
        super("", "img/square-grid.png");
        putValue(Action.SHORT_DESCRIPTION, "toggle grid");
        this.graphFrame = graphFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mxGraphComponent graphComponent = graphFrame.getGraphComponent();
        if(graphComponent.isGridVisible()) {
            graphComponent.setGridVisible(false);
            graphComponent.refresh();
        }else
        {
            graphComponent.setGridVisible(true);
            graphComponent.setGridStyle(mxGraphComponent.GRID_STYLE_DOT);
            graphComponent.refresh();
        }
    }
}
