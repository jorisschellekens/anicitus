package block.iot;

import model.IBlock;
import model.IBlockFactory;
import sun.misc.IOUtils;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Formatter;

/**
 * Created by joris on 10/20/17.
 */
public class StockBidBlockFactory extends IBlockFactory {

    @Override
    public String getName() {
        return "stock (bid)";
    }

    @Override
    public String getCategory() {
        return "iot";
    }

    @Override
    public Color getColor(){ return Color.decode("#d7bfd7");}

    @Override
    public IBlock build() {
        return new StockBidBlock();
    }
}
