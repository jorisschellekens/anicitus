package block.pdf;

import model.IBlock;

public class TextToPDFBlock extends IBlock {

    @Override
    public String getName() {
        return "TXT to PDF";
    }

    @Override
    public int countInputs() {
        return 0;
    }

    @Override
    public int countOutputs() {
        return 0;
    }

    @Override
    public Object[] process(Object[] in) {
        return new Object[0];
    }

}
