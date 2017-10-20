package block.string;

import model.IBlock;
import model.IBlockFactory;

import java.awt.Color;

public class ReplaceBlockFactory extends IBlockFactory {
    @Override
    public String getName() {
        return "replace";
    }

    @Override
    public String getCategory() {
        return "string";
    }

    @Override
    public Color getColor() {
        return Color.decode("#e97b00");
    }

    @Override
    public IBlock build() {
        return new ReplaceBlock();
    }
}
