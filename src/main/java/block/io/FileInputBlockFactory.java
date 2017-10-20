package block.io;

import model.IBlock;
import model.IBlockFactory;

import java.awt.*;
import java.io.File;

/**
 * Created by joris on 10/16/17.
 */
public class FileInputBlockFactory extends IBlockFactory {
    @Override
    public String getName() {
        return "file input";
    }

    @Override
    public String getCategory() {
        return "io";
    }

    @Override
    public Color getColor() {
        return Color.decode("#a6bad2");
    }

    @Override
    public IBlock build() {
        return new FileInputBlock();
    }

    @Override
    public IBlock build(String[] args) {
        return new FileInputBlock(new File(args[0]));
    }

    @Override
    public boolean hasArgs(){return true;}
}
