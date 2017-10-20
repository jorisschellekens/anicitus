package block.io;

import model.IBlock;

public class MailTextBlock extends IBlock {
    @Override
    public String getName() {
        return "mail txt";
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
        return new Object[0];
    }

}
