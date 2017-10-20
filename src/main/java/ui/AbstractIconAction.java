/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author joris
 */
public abstract class AbstractIconAction extends AbstractAction{
    
    public AbstractIconAction(String name, String iconPath)
    {
        super(name);
        
        Icon ico = loadIcon(iconPath);
        if(ico != null)
        {
            super.putValue(Action.LARGE_ICON_KEY, ico);
            super.putValue(Action.SMALL_ICON, ico);
        }
    }

    private Icon loadIcon(String path)
    {
        try {
            BufferedImage bi = ImageIO.read(getClass().getClassLoader().getResourceAsStream(path));
            return new ImageIcon(bi);
        } catch (IOException | NullPointerException ex) {
        }
        return null;
    }
}