package block.primitive;

import model.IBlock;

public class RandomNumberBlock extends IBlock {

    private static java.util.Random RND = new java.util.Random(System.currentTimeMillis());

    @Override
    public String getName() {
        return "random";
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
        int lb = ((Double) in[0]).intValue();
        int ub = ((Double) in[1]).intValue();
        double rnd = (double) (RND.nextInt(ub - lb)  + lb);
        return new Object[]{rnd};
    }

}
