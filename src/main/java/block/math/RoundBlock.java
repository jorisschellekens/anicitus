package block.math;

import model.IBlock;

public class RoundBlock extends IBlock {
    @Override
    public String getName() {
        return "round";
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
        double d = (Double) in[0];
        d = java.lang.Math.round(d);
        return new Object[]{d};
    }
}
