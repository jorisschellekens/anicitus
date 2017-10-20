package block.string;

import model.IBlock;
import model.IBlockFactory;

import java.awt.*;

/**
 * Created by joris on 10/16/17.
 */
public class ToUpperBlockFactory extends IBlockFactory {
    @Override
    public String getName() {
        return "to uppercase";
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
        return new ToUpperBlock();
    }
}
