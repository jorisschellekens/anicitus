package block.io;

import model.IBlock;

import javax.swing.*;

public class AlertBlock extends IBlock {

    @Override
    public String getName() {
        return "alert";
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
        JOptionPane.showMessageDialog(null, in[0].toString());
        return new Object[0];
    }

}
