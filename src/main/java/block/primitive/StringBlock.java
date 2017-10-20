package block.primitive;

import model.IBlock;

import javax.swing.*;

public class StringBlock extends IBlock {

    private String text = "";

    public StringBlock()
    {
        text = JOptionPane.showInputDialog("Enter your text here.");
    }

    public StringBlock(String text)
    {
        this.text = text;
    }

    @Override
    public String[] getArgs(){return new String[]{text};}

    @Override
    public String getName() {
        return "'"  + text + "'";
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
        return new Object[]{text};
    }

}
