package block.primitive;

import model.IBlock;
import model.IBlockFactory;

import java.awt.Color;

public class StringBlockFactory extends IBlockFactory {
    @Override
    public String getName() {
        return "string";
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
        return new StringBlock();
    }

    @Override
    public IBlock build(String[] args) {
        return new StringBlock(args[0]);
    }

    @Override
    public boolean hasArgs(){return true;}
}
