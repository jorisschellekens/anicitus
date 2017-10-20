package block.primitive;

import block.io.FileOutputBlock;
import model.IBlock;
import model.IBlockFactory;

import java.awt.Color;
import java.io.File;

public class NumberBlockFactory extends IBlockFactory {

    @Override
    public String getName() {
        return "number";
    }

    @Override
    public String getCategory() {
        return "primitive";
    }

    @Override
    public Color getColor() {
        return Color.decode("#e8e7af");
    }

    @Override
    public IBlock build() {
        return new NumberBlock();
    }

    @Override
    public IBlock build(String[] args) {
        return new NumberBlock(Double.parseDouble(args[0]));
    }

    @Override
    public boolean hasArgs(){return true;}
}
