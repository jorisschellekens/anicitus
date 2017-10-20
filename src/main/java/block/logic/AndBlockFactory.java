package block.logic;

import model.IBlock;
import model.IBlockFactory;

import java.awt.Color;

public class AndBlockFactory extends IBlockFactory {
    @Override
    public String getName() {
        return "AND";
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
        return new AndBlock();
    }
}
