package block.io;

import model.IBlock;

/**
 * Created by joris on 10/16/17.
 */
public class ConsoleOutBlock extends IBlock {

    @Override
    public String getName() {
        return "console out";
    }

    @Override
    public int countInputs() {
        return 1;
    }

    @Override
    public int countOutputs() {
        return 0;
    }

    @Override
    public Object[] process(Object[] in) {
        System.out.println(in[0].toString());
        return new Object[0];
    }

}
