package block.string;

import model.IBlock;
import model.IBlockFactory;

import java.awt.Color;

public class SubstringBlockFactory extends IBlockFactory {
    @Override
    public String getName() {
        return "substring";
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
        return new SubstringBlock();
    }
}
