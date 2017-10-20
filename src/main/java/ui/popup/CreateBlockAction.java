package ui.popup;

import model.IBlockFactory;
import ui.graph.Graph;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CreateBlockAction extends AbstractAction
{
    private IBlockFactory blockFactory;
    private Graph graph;
    private GraphPopupMenu parentMenu;

    public CreateBlockAction(IBlockFactory blockFactory, Graph graph)
    {
        super(fixCase(blockFactory.getName()));
        this.blockFactory = blockFactory;
        this.graph = graph;
    }

    private static String fixCase(String s)
    {
        return s.substring(0,1).toUpperCase() + s.substring(1);
    }

    public CreateBlockAction setParentMenu(GraphPopupMenu parentMenu)
    {
        this.parentMenu = parentMenu;
        return this;
    }

    public void actionPerformed(ActionEvent e) {
        graph.addVertex(blockFactory.build(), parentMenu.getClickedPoint().x, parentMenu.getClickedPoint().y);
    }
}
