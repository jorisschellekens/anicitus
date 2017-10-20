package block.logic;

import model.IBlock;

public class NotBlock extends IBlock {
    @Override
    public String getName() {
        return "NOT";
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
        boolean retval = !((boolean) in[0]);
        return new Boolean[]{retval};
    }

}
