package block.primitive;

import model.IBlock;
import model.IBlockFactory;

import java.awt.Color;

public class DateBlockFactory extends IBlockFactory {
    @Override
    public String getName() {
        return "date";
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
        return new DateBlock();
    }
}
