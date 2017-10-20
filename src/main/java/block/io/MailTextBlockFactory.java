package block.io;

import model.IBlock;
import model.IBlockFactory;

import java.awt.Color;

public class MailTextBlockFactory extends IBlockFactory {
    @Override
    public String getName() {
        return "mail text";
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
        return new MailTextBlock();
    }
}
