package block.string;

import model.IBlock;
import model.IBlockFactory;

import java.awt.Color;

public class ContainsBlockFactory extends IBlockFactory {

    @Override
    public String getName() {
        return "contains";
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
        return new ContainsBlock();
    }
}
