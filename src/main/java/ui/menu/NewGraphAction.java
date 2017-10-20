package ui.menu;

import ui.GraphFrame;
import ui.graph.Graph;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by joris on 10/18/17.
 */
public class NewGraphAction extends AbstractAction {

    private GraphFrame graphFrame;

    public NewGraphAction(GraphFrame graphFrame)
    {
        super("New");
        this.graphFrame = graphFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        graphFrame.setTitle("untitled*");
        graphFrame.getGraph().selectAll();
        graphFrame.getGraph().removeCells(graphFrame.getGraph().getSelectionCells());
    }
}
