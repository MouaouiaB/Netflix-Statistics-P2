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
        this.SideTabs.addTab("Film", overViewItemListener = new OverViewItemListener("Film"));
        this.SideTabs.addTab("Serie", overViewItemListener = new OverViewItemListener("Film"));
        this.SideTabs.addTab("Aflevering", overViewItemListener = new OverViewItemListener("Aflevering"));
        this.SideTabs.addTab("Programma", overViewItemListener = new OverViewItemListener("Programma"));

        add(this.SideTabs);


    }
}
