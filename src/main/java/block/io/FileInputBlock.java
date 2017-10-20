package block.io;

import model.IBlock;

import javax.swing.*;
import java.io.File;

/**
 * Created by joris on 10/16/17.
 */
public class FileInputBlock extends IBlock {

    private File selectedFile = null;

    public FileInputBlock()
    {
        JFileChooser fileChooser = new JFileChooser();
        int retval = fileChooser.showOpenDialog(null);
        if(retval == JFileChooser.APPROVE_OPTION)
            selectedFile = fileChooser.getSelectedFile();
        else
            selectedFile = null;
    }

    public FileInputBlock(File selectedFile)
    {
        this.selectedFile = selectedFile;
    }

     @Override
     public String[] getArgs(){return new String[]{selectedFile.getAbsolutePath()};}

    @Override
    public String getName() {
        return "file input";
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
