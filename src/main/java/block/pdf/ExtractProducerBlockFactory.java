package block.pdf;

import model.IBlock;
import model.IBlockFactory;

import java.awt.Color;

public class ExtractProducerBlockFactory extends IBlockFactory {

    @Override
    public IBlock build() {
        return new ExtractProducerBlock();
    }

    @Override
    public String getName() {
        return "extract producer";
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
