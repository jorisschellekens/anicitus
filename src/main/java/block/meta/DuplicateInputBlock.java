package block.meta;

import model.IBlock;

public class DuplicateInputBlock extends IBlock {

    @Override
    public String getName() {
        return "duplicate input";
    }

    @Override
    public int countInputs() {
        return 1;
    }

    @Override
    public int countOutputs() {
        return 2;
    }

    @Override
    public Object[] process(Object[] in) {
        return new Object[]{in[0], in[0]};
    }

}
