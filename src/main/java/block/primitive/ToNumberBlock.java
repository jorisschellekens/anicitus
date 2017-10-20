package block.primitive;

import model.IBlock;

public class ToNumberBlock extends IBlock {
    @Override
    public String getName() {
        return "to number";
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
        double d = 0;
        try
        {
            d = Double.parseDouble(in[0].toString());
        }catch (Exception ex){}
        return new Object[]{d};
    }
}
