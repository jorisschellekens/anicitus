package block.nlp;

import model.IBlock;
import model.IBlockFactory;

import java.awt.Color;

/**
 * Created by joris on 10/16/17.
 */
public class DetermineLanguageBlockFactory extends IBlockFactory {

    @Override
    public String getName() {
        return "determine language";
    }

    @Override
    public String getCategory() {
        return "nlp";
    }

    @Override
    public Color getColor() {
        return Color.decode("#dddddd");
    }

    @Override
    public IBlock build() {
        return new DetermineLanguageBlock();
    }
}
