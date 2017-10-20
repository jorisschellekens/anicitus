package block.iot;

import model.IBlock;
import sun.misc.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Formatter;

/**
 * Created by joris on 10/20/17.
 */
public class StockAskBlock extends IBlock {

    private static transient String YAHOO_URL = "http://download.finance.yahoo.com/d/quotes.csv?s=%1$s&f=a";

    @Override
    public String getName(){
        return "stock (ask)";
    }

    @Override
    public int countInputs() {
        return 1;
    }

    @Override
    public int countOutputs() {
        return 1;
    }

    @Override
    public Object[] process(Object[] in) {
        double number = 0.0;
        try {
            String url = new Formatter().format(YAHOO_URL, in[0].toString()).toString();
            InputStream is = new URL(url).openStream();
            number = Double.parseDouble(new String(IOUtils.readFully(is, -1, true)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Object[]{number};
    }
}
