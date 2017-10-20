package block.iot;

import model.IBlock;
import org.json.JSONObject;
import sun.misc.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Formatter;

/**
 * Created by joris on 10/20/17.
 */
public class WeatherPressureBlock extends IBlock{

    @Override
    public String getName() {
        return "weather (pressure)";
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
        double pressure = 0.0;
        try {
            String url = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22"+in[0].toString()+"%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
            InputStream is = new URL(url).openStream();
            String txt = new String(IOUtils.readFully(is, -1, true));
            pressure = new JSONObject(txt).getJSONObject("query").getJSONObject("results").getJSONObject("channel").getJSONObject("atmosphere").getDouble("pressure");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Object[]{pressure};
    }

}
