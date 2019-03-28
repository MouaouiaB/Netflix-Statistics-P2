package UI;

import javax.swing.*;
import java.awt.*;

public class DeleteListener extends JPanel implements IAddingTabs {
    private JTabbedPane SideTabs;

    public DeleteListener(){
        super(new BorderLayout());
        TabsAdd();
    }



    @Override
    public void TabsAdd() {
        this.SideTabs = new JTabbedPane();
        this.SideTabs.setFont(new Font("Side", Font.BOLD|Font.BOLD, 20 ));
        this.SideTabs.setTabPlacement(JTabbedPane.LEFT);
        this.SideTabs.addTab("Account", null);
        this.SideTabs.addTab("Profiel", null);
        this.SideTabs.addTab("Film", null);
        this.SideTabs.addTab("Serie", null);
        this.SideTabs.addTab("Aflevering", null);
        this.SideTabs.addTab("Programma", null);

        add(this.SideTabs);


    }
}
