package block.string;

import model.IBlock;

/**
 * Created by joris on 10/16/17.
 */
public class ToUpperBlock extends IBlock{

    @Override
    public String getName() {
        return "to uppercase";
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
        return new String[]{in[0].toString().toUpperCase()};
    }

}
