package block.logic;

import model.IBlock;

public class GreaterThanBlock extends IBlock {

    @Override
    public String getName() {
        return ">";
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
        int cmp = ((Comparable) in[0]).compareTo(in[1]);
        return new Boolean[]{cmp > 0};
    }

}
