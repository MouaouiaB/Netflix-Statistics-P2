package UI;

import javax.swing.*;
import java.awt.*;

public class UpdateListener extends JPanel implements IAddingTabs {
    private JTabbedPane SideTabs;
    public UpdateItemListener updateItemListener;

    public UpdateListener(){
        super(new BorderLayout());
        TabsAdd();
    }

    @Override
    public void TabsAdd() {
        this.SideTabs = new JTabbedPane();
        this.SideTabs.setFont(new Font("Side", Font.BOLD|Font.BOLD, 20 ));
        this.SideTabs.setTabPlacement(JTabbedPane.LEFT);
        this.SideTabs.addTab("Account", this.updateItemListener = new UpdateItemListener("Account"));
        this.SideTabs.addTab("Profiel", this.updateItemListener = new UpdateItemListener("Profiel"));
        this.SideTabs.addTab("Programma", this.updateItemListener = new UpdateItemListener("Program"));


        add(this.SideTabs);


    }
}
