package block.primitive;

import model.IBlock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateBlock extends IBlock {
    @Override
    public String getName() {
        return "date";
    }

    @Override
    public int countInputs() {
        return 0;
    }

    @Override
    public int countOutputs() {
        return 1;
    }

    @Override
    public Object[] process(Object[] in) {
        String txt = new SimpleDateFormat("dd-MM-yyyy").format(new Date(System.currentTimeMillis()));
        return new Object[]{txt};
    }

}
