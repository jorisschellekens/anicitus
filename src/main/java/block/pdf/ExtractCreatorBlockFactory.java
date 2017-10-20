package block.pdf;

import model.IBlock;
import model.IBlockFactory;

import java.awt.Color;

public class ExtractCreatorBlockFactory extends IBlockFactory {

    @Override
    public IBlock build() {
        return new ExtractCreatorBlock();
    }

    @Override
    public String getName() {
        return "extract creator";
    }

    @Override
    public String getCategory() {
        return "pdf";
    }

    @Override
    public Color getColor() {
        return Color.decode("#d7bfd7");
    }

}
