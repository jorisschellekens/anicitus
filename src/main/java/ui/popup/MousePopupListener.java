package ui.popup;

import javax.swing.*;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MousePopupListener extends MouseAdapter {

    private JPopupMenu popup;
    private Point clickedPoint;

    public MousePopupListener(JPopupMenu popupMenu)
    {
        this.popup = popupMenu;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        checkPopup(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        checkPopup(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        checkPopup(e);
    }

    private void checkPopup(MouseEvent e) {
        if(!e.isPopupTrigger())
            return;
        clickedPoint = new Point(e.getX(), e.getY());
        Component panel = (Component) e.getSource();
        popup.show(panel, e.getX(), e.getY());
    }
}