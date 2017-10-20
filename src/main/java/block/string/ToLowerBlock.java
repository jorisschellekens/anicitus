package block.string;

import model.IBlock;

/**
 * Created by joris on 10/16/17.
 */
public class ToLowerBlock extends IBlock{

    @Override
    public String getName() {
        return "to lowercase";
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
        return new String[]{in[0].toString().toLowerCase()};
    }

}
