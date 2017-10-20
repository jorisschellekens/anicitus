package block.io;

import model.IBlock;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class AppendToFileBlock extends IBlock {

    @Override
    public String getName() {
        return "append to file";
    }

    @Override
    public int countInputs() {
        return 2;
    }

    @Override
    public int countOutputs() {
        return 0;
    }

    @Override
    public Object[] process(Object[] in) {
        File inputFile = (File) in[0];
        try {
            if (!inputFile.exists())
                inputFile.createNewFile();
            Writer writer = new BufferedWriter(new FileWriter(inputFile, true));
            writer.write(in[1].toString()+"\n");
            writer.flush();
            writer.close();
        }catch(IOException ex){}
        return new Object[0];
    }

}
