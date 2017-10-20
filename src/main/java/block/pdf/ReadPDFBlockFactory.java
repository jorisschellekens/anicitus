package block.pdf;

import model.IBlock;
import model.IBlockFactory;

import java.awt.Color;

public class ReadPDFBlockFactory extends IBlockFactory {
    @Override
    public String getName() {
        return "read PDF";
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
        return new ReadPDFBlock();
    }
}
