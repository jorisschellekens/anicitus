package block.math;

import model.IBlock;
import model.IBlockFactory;

import java.awt.Color;

public class AddBlockFactory extends IBlockFactory {
    @Override
    public String getName() {
        return "+";
    }

    @Override
    public String getCategory() {
        return "math";
    }

    @Override
    public Color getColor() {
        return Color.decode("#3fadb5");
    }

    @Override
    public IBlock build() {
        return new AddBlock();
    }
}
