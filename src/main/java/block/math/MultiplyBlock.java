package block.math;

import model.IBlock;

public class MultiplyBlock extends IBlock{
    @Override
    public String getName() {
        return "*";
    }

    @Override
    public int countInputs() {
        return 2;
    }

    @Override
    public int countOutputs() {
        return 1;
    }

    @Override
    public Object[] process(Object[] in) {
        double d0 = (Double) in[0];
        double d1 = (Double) in[1];
        return new Object[]{d0*d1};
    }

}
