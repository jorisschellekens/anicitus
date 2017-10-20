package block.io;

import model.IBlock;
import model.IBlockFactory;

import java.awt.Color;

public class AppendToFileBlockFactory extends IBlockFactory {
    @Override
    public String getName() {
        return "append to file";
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
        return new AppendToFileBlock();
    }
}
