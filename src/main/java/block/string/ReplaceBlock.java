package block.string;

import model.IBlock;

public class ReplaceBlock extends IBlock {
    @Override
    public String getName() {
        return "replace";
    }

    @Override
    public int countInputs() {
        return 3;
    }

    @Override
    public int countOutputs() {
        return 1;
    }

    @Override
    public Object[] process(Object[] in) {
        String txt = in[0].toString().replace(in[1].toString(), in[2].toString());
        return new Object[]{txt};
    }

}
