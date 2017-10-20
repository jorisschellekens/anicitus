package ui.menu;

import model.JsonGraphIO;
import ui.GraphFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class OpenGraphAction extends AbstractAction {

    private GraphFrame graphFrame;

    public OpenGraphAction(GraphFrame graphFrame)
    {
        super("Open");
        this.graphFrame = graphFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int retval = fileChooser.showOpenDialog(graphFrame);
        if(retval != JFileChooser.APPROVE_OPTION)
            return;

        File inputFile = fileChooser.getSelectedFile();
        graphFrame.setTitle(inputFile.getName());
        graphFrame.getGraph().selectAll();
        graphFrame.getGraph().clearSelection();

        try {
            JsonGraphIO.load(graphFrame.getGraph(), inputFile);
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }


    }

}
