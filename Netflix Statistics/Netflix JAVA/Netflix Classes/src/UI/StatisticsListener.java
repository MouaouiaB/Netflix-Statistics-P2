package UI;

import javax.swing.*;
import java.awt.*;

public class StatisticsListener extends JPanel implements IAddingTabs {
    private JTabbedPane SideTabs;

    public StatisticsListener(){
        super(new BorderLayout());
        TabsAdd();
    }

    @Override
    public void TabsAdd() {
        this.SideTabs = new JTabbedPane();
        this.SideTabs.setFont(new Font("Side", Font.BOLD|Font.BOLD, 20 ));
        this.SideTabs.setTabPlacement(JTabbedPane.LEFT);
        this.SideTabs.addTab("Stats1", null);
        this.SideTabs.addTab("Stats2", null);
        this.SideTabs.addTab("Stats3", null);
        this.SideTabs.addTab("Stats4", null);
        this.SideTabs.addTab("Episode", null);
        this.SideTabs.addTab("Program", null);
    }
}