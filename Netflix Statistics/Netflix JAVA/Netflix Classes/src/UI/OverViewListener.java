package UI;

import javax.swing.*;
import java.awt.*;

public class OverViewListener extends JPanel implements IAddingTabs {
    private JTabbedPane SideTabs;

    public OverViewListener(){
        super(new BorderLayout());
        TabsAdd();
    }

    @Override
    public void TabsAdd() {
        this.SideTabs = new JTabbedPane();
        this.SideTabs.setFont(new Font("Side", Font.BOLD|Font.BOLD, 20 ));
        this.SideTabs.setTabPlacement(JTabbedPane.LEFT);
        this.SideTabs.addTab("movies", null);
        this.SideTabs.addTab("series", null);

        add(this.SideTabs);


    }
}
