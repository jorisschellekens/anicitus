package block.logic;

import model.IBlock;
import model.IBlockFactory;

import java.awt.Color;

public class NotBlockFactory extends IBlockFactory {
    @Override
    public String getName() {
        return "NOT";
    }

    @Override
    public String getCategory() {
        return "logic";
    }

    @Override
    public Color getColor() {
        return Color.decode("#e59191");
    }

    @Override
    public IBlock build() {
        return new NotBlock();
    }

}
