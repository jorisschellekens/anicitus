package ui.menu;

import model.JsonGraphIO;
import ui.GraphFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class SaveGraphAction extends AbstractAction {

    private GraphFrame graphFrame;

    public SaveGraphAction(GraphFrame graphFrame)
    {
        super("Save");
        this.graphFrame = graphFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int retval = fileChooser.showSaveDialog(graphFrame);
        if(retval != JFileChooser.APPROVE_OPTION)
            return;

        File outputFile = fileChooser.getSelectedFile();
        try {
            JsonGraphIO.store(graphFrame.getGraph(), outputFile);
            graphFrame.setTitle(outputFile.getName());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
