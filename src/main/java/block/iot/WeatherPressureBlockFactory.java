package block.iot;

import model.IBlock;
import model.IBlockFactory;

import java.awt.*;

/**
 * Created by joris on 10/20/17.
 */
public class WeatherPressureBlockFactory extends IBlockFactory {
    @Override
    public String getName() {
        return "weather (pressure)";
    }

    @Override
    public String getCategory() {
        return "iot";
    }

    @Override
    public Color getColor(){ return Color.decode("#d7bfd7");}


    @Override
    public IBlock build() {
        return new WeatherPressureBlock();
    }
}
