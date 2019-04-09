package UI;

import javax.swing.*;
import java.awt.*;

public class OverViewListener extends JPanel implements IAddingTabs {
    private JTabbedPane SideTabs;
    private OverViewItemListener overViewItemListener;

    public OverViewListener(){
        super(new BorderLayout());
        TabsAdd();
    }

    @Override
    public void TabsAdd() {
        this.SideTabs = new JTabbedPane();
        this.SideTabs.setFont(new Font("Side", Font.BOLD|Font.BOLD, 20 ));
        this.SideTabs.setTabPlacement(JTabbedPane.LEFT);
        this.SideTabs.addTab("Account", overViewItemListener = new OverViewItemListener("Account"));
        this.SideTabs.addTab("Profiel", overViewItemListener = new OverViewItemListener("Profiel"));
        this.SideTabs.addTab("Movie", overViewItemListener = new OverViewItemListener("Movie"));
        this.SideTabs.addTab("Serie", overViewItemListener = new OverViewItemListener("Movie"));
        this.SideTabs.addTab("Episode", overViewItemListener = new OverViewItemListener("Episode"));
        this.SideTabs.addTab("Program", overViewItemListener = new OverViewItemListener("Program"));

        add(this.SideTabs);


    }
}
