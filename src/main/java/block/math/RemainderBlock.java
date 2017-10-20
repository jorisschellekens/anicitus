package block.math;

import model.IBlock;

public class RemainderBlock extends IBlock{
    @Override
    public String getName() {
        return "mod";
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
        int d0 = ((Double) in[0]).intValue();
        int d1 = ((Double) in[1]).intValue();
        return new Object[]{(d0 % d1) + 0.0};
    }

}
