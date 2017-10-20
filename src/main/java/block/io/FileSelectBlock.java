package block.io;

import model.IBlock;

import javax.swing.*;
import java.io.File;

/**
 * Created by joris on 10/16/17.
 */
public class FileSelectBlock extends IBlock {

    @Override
    public String getName() {
        return "file select";
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
        JFileChooser fileChooser = new JFileChooser();
        int retval = fileChooser.showOpenDialog(null);
        if(retval == JFileChooser.APPROVE_OPTION)
            return new File[]{fileChooser.getSelectedFile()};
        else
            return new File[]{null};
    }

}
