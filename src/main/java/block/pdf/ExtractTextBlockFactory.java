package block.pdf;

import model.IBlock;
import model.IBlockFactory;

import java.awt.Color;

public class ExtractTextBlockFactory extends IBlockFactory{

    @Override
    public String getName() {
        return "extract text";
    }

    @Override
    public String getCategory() {
        return "pdf";
    }

    @Override
    public Color getColor() {
        return Color.decode("#d7bfd7");
    }

    @Override
    public IBlock build() {
        return new ExtractTextBlock();
    }
}
