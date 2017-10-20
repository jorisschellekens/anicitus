package block.logic;

import model.IBlock;

public class IfBlock extends IBlock{
    @Override
    public String getName() {
        return "if else";
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
        boolean branch = (boolean) in[0];
        if(branch)
            return new Object[]{in[1]};
        else
            return new Object[]{in[2]};
    }

}
