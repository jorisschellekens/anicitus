package block.primitive;

import model.IBlock;
import model.IBlockFactory;

import java.awt.Color;

public class RandomNumberBlockFactory extends IBlockFactory {
    @Override
    public String getName() {
        return "random";
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
        return new RandomNumberBlock();
    }
}
