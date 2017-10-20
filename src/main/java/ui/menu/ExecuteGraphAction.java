package ui.menu;

import model.Executor;
import ui.AbstractIconAction;
import ui.GraphFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by joris on 10/17/17.
 */
public class ExecuteGraphAction extends AbstractIconAction {

    private GraphFrame graphFrame;

    public ExecuteGraphAction(GraphFrame graphFrame)
    {
        super("", "img/play-button.png");
        putValue(Action.SHORT_DESCRIPTION, "execute graph");
        this.graphFrame = graphFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Executor.execute(graphFrame.getGraph());
    }
}
