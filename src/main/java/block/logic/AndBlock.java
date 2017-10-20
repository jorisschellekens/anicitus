package block.logic;

import model.IBlock;

public class AndBlock extends IBlock{

    @Override
    public String getName() {
        return "AND";
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
        boolean retVal = ((boolean) in[0]) && ((boolean) in[1]);
        return new Boolean[]{retVal};
    }

}
