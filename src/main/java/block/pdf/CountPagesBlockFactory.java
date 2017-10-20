package block.pdf;

import model.IBlock;
import model.IBlockFactory;

import java.awt.Color;

public class CountPagesBlockFactory extends IBlockFactory {

    @Override
    public IBlock build() {
        return new CountPagesBlock();
    }

    @Override
    public String getName() { return "count pages"; }

    public String getCategory(){ return "pdf"; }

    public Color getColor(){ return Color.decode("#d7bfd7");}
}
