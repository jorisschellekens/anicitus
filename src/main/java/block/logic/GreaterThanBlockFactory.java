package block.logic;

import model.IBlock;
import model.IBlockFactory;

import java.awt.Color;

public class GreaterThanBlockFactory extends IBlockFactory {

    @Override
    public String getName() {
        return ">";
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
        return new GreaterThanBlock();
    }
}
