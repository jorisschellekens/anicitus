package block.string;

import model.IBlock;

/**
 * Created by joris on 10/16/17.
 */
public class ConcatenateBlock extends IBlock {
    @Override
    public String getName() {
        return "concatenate";
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
        return new String[]{in[0].toString() + in[1].toString()};
    }

}
