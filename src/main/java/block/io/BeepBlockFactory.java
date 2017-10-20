package block.io;

import model.IBlock;
import model.IBlockFactory;

import java.awt.*;

/**
 * Created by joris on 10/17/17.
 */
public class BeepBlockFactory extends IBlockFactory {
    @Override
    public String getName() {
        return "beep";
    }

    @Override
    public String getCategory() {
        return "io";
    }

    @Override
    public Color getColor() {
        return Color.decode("#a6bad2");
    }

    @Override
    public IBlock build() {
        return new BeepBlock();
    }
}
