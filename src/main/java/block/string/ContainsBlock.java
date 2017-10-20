package block.string;

import model.IBlock;

public class ContainsBlock extends IBlock {

    @Override
    public String getName() {
        return "contains";
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
        boolean retVal = in[0].toString().contains(in[1].toString());
        return new Object[]{retVal};
    }

}
