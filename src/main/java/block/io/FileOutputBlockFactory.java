package block.io;

import model.IBlock;
import model.IBlockFactory;

import java.awt.Color;
import java.io.File;

public class FileOutputBlockFactory extends IBlockFactory {
    @Override
    public String getName() {
        return "file output";
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
        return new FileOutputBlock();
    }

    @Override
    public IBlock build(String[] args) {
        return new FileOutputBlock(new File(args[0]));
    }

    @Override
    public boolean hasArgs(){return true;}
}
