package model;

import java.io.Serializable;

/**
 * Created by joris on 10/14/17.
 */
public abstract class IBlock implements Serializable{

    public abstract String getName();

    public abstract int countInputs();

    public abstract int countOutputs();

    public abstract Object[] process(Object[] in);

    public String[] getArgs(){ return new String[]{}; }

    public String toString()
    {
        return getName();
    }

}
