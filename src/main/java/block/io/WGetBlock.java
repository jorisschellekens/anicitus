package block.io;

import model.IBlock;
import sun.misc.IOUtils;
import sun.nio.ch.IOUtil;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class WGetBlock extends IBlock {
    @Override
    public String getName() {
        return "wget";
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
        String url = in[0].toString();
        String txt = "";
        try{
            InputStream is = new URL(url).openStream();
            txt = new String(IOUtils.readFully(is, -1, true));
        }catch(Exception ex) {
        }
        return new Object[]{txt};
    }

}
