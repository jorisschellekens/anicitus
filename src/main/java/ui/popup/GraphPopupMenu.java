package ui.popup;

import block.IBlockFactoryEnum;
import model.IBlockFactory;
import ui.graph.Graph;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Component;
import java.awt.Point;
import java.io.IOException;
import java.util.*;

public class GraphPopupMenu extends JPopupMenu {

    private Point clickedPoint;

    public GraphPopupMenu(Graph graph)
    {
        // 'create' menu
        JMenu createMenu = new JMenu("create");
        try {
            createMenu.setIcon(new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("img/plus.png"))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // build map category --> List<IBlockFactory>
        Map<String, List<IBlockFactory>> factoryMap = new HashMap<>();
        for(IBlockFactory f : IBlockFactoryEnum.getAvailableFactories())
        {
            String category = f.getCategory();
            category = category.substring(0,1).toUpperCase() + category.substring(1);
            if(!factoryMap.containsKey(category))
                factoryMap.put(category, new ArrayList<IBlockFactory>());
            factoryMap.get(category).add(f);
        }

        // sort all categories
        List<Map.Entry<String, List<IBlockFactory>>> entries = new ArrayList<>(factoryMap.entrySet());
        java.util.Collections.sort(entries, new Comparator<Map.Entry<String, List<IBlockFactory>>>() {
            @Override
            public int compare(Map.Entry<String, List<IBlockFactory>> o1, Map.Entry<String, List<IBlockFactory>> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        for(int i=0;i<entries.size();i++)
        {
            String category = entries.get(i).getKey();
            JMenu subMenu = new JMenu(category);

            // sort factories
            List<IBlockFactory> factories = entries.get(i).getValue();
            java.util.Collections.sort(factories, new Comparator<IBlockFactory>() {
                @Override
                public int compare(IBlockFactory o1, IBlockFactory o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });

            // addVertex to submenu
            for(int j=0;j<factories.size();j++)
                subMenu.add(new CreateBlockAction(factories.get(j), graph).setParentMenu(this));

            // addVertex submenu to create menu
            createMenu.add(subMenu);
        }
        add(createMenu);

    }

    public Point getClickedPoint()
    {
        return clickedPoint;
    }

    @Override
    public void show(Component invoker, int x, int y)
    {
        clickedPoint = new Point(x, y);
        super.show(invoker, x, y);
    }
}

