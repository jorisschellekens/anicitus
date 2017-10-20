package model;

import java.awt.*;

/**
 * Created by joris on 10/14/17.
 */
public abstract class IBlockFactory {

    public abstract String getName();

    public abstract String getCategory();

    public abstract Color getColor();

    public boolean hasArgs(){ return false; }

    public abstract IBlock build();

    public IBlock build(String[] args){ return build(); }

    public String toString()
    {
        return getName();
    }

}
