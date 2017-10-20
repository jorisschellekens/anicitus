package block.pdf;

import model.IBlock;
import model.IBlockFactory;

import java.awt.Color;

public class ExtractAuthorBlockFactory extends IBlockFactory {

    @Override
    public IBlock build() {
        return new ExtractAuthorBlock();
    }

    @Override
    public String getName() {
        return "extract author";
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
