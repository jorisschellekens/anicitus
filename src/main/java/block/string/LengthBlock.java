package block.string;

import model.IBlock;

/**
 * Created by joris on 10/18/17.
 */
public class LengthBlock extends IBlock {

    @Override
    public String getName() {
        return "length";
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
        String txt = in[0].toString();
        return new Integer[]{txt.length()};
    }

}
