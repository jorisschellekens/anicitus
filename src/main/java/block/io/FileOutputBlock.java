package block.io;

import model.IBlock;

import javax.swing.*;
import java.io.File;

public class FileOutputBlock extends IBlock {

    private File selectedFile;

    public FileOutputBlock()
    {
        JFileChooser fileChooser = new JFileChooser();
        int retval = fileChooser.showSaveDialog(null);
        if(retval == JFileChooser.APPROVE_OPTION)
            selectedFile = fileChooser.getSelectedFile();
        else
            selectedFile = null;
    }

    public FileOutputBlock(File selectedFile)
    {
        this.selectedFile = selectedFile;
    }

    @Override
    public String[] getArgs(){return new String[]{selectedFile.getAbsolutePath()};}

    @Override
    public String getName() {
        return "file output";
    }

    @Override
    public int countInputs() {
        return 0;
    }

    @Override
    public int countOutputs() {
        return 1;
    }

    @Override
    public Object[] process(Object[] in) {
        return new Object[]{selectedFile};
    }

}
