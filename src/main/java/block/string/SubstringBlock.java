package block.string;

import model.IBlock;

public class SubstringBlock extends IBlock {
    @Override
    public String getName() {
        return "substring";
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
        String s = in[0].toString();
        int from = (Integer) in[1];
        from = java.lang.Math.max(0, from);

        int to = (Integer) in[2];
        to = java.lang.Math.min(to, s.length());

        return new Object[]{s.substring(from, to)};
    }

}
