package block.io;

import model.IBlock;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by joris on 10/16/17.
 */
public class ReadBytesBlock extends IBlock {

    @Override
    public String getName() {
        return "read bytes";
    }

    @Override
    public int countInputs() {
        return 1;
    }

    @Override
    public int countOutputs() {
        return 1;
    }

    @Override
    public Object[] process(Object[] in) {

        String txt = "";
        if(!(in[0] instanceof File))
            return new String[]{txt};

        File inputFile = (File) in[0];
        try {
            txt = new String(Files.readAllBytes(inputFile.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new String[]{txt};
    }

}
