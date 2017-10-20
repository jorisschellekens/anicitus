package block.primitive;

import model.IBlock;

import javax.swing.*;

public class NumberBlock extends IBlock {

    private double number;

    public NumberBlock()
    {
        try {
            number = Double.parseDouble(JOptionPane.showInputDialog("Enter your number here."));
        }catch(Exception ex){}
    }

    public NumberBlock(double number)
    {
        this.number = number;
    }

    @Override
    public String[] getArgs(){return new String[]{number+""};}

    @Override
    public String getName() {
        return Double.toString(number);
    }

    @Override
    public int countInputs() {
        return 0;
    }

    @Override
    public int countOutputs() {
        return 1;
    }

    @Override
    public Object[] process(Object[] in) {
        return new Double[]{number};
    }

}
