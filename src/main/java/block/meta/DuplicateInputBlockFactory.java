package block.meta;

import model.IBlock;
import model.IBlockFactory;

import java.awt.Color;

public class DuplicateInputBlockFactory extends IBlockFactory {

    @Override
    public String getName() {
        return "duplicate input";
    }

    @Override
    public String getCategory() {
        return "meta";
    }

    @Override
    public Color getColor() {
        return Color.decode("#bfedbf");
    }

    @Override
    public IBlock build() {
        return new DuplicateInputBlock();
    }

}
