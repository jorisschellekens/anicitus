package block.string;

import block.IBlockFactoryEnum;
import model.IBlock;
import model.IBlockFactory;

import java.awt.*;

/**
 * Created by joris on 10/18/17.
 */
public class LengthBlockFactory extends IBlockFactory {
    @Override
    public String getName() {
        return "length";
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
        return new LengthBlock();
    }
}
