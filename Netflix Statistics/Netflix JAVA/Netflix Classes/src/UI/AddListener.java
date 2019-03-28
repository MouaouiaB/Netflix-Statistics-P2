package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddListener extends JPanel implements IAddingTabs{

    private JTabbedPane SideTabs;
    public AddItemListener addItemListener;

    public AddListener(){
        super(new BorderLayout());
        TabsAdd();
    }


    @Override
    public void TabsAdd() {


        this.SideTabs = new JTabbedPane();
        this.SideTabs.setFont(new Font("Side", Font.BOLD|Font.BOLD, 20 ));
        this.SideTabs.setTabPlacement(JTabbedPane.LEFT);
        this.SideTabs.addTab("Account", this.addItemListener = new AddItemListener("Account"));
        this.SideTabs.addTab("Profiel", this.addItemListener = new AddItemListener("Profiel"));
        this.SideTabs.addTab("Film", null);
        this.SideTabs.addTab("Serie", null);
        this.SideTabs.addTab("Aflevering", null);
        this.SideTabs.addTab("Programma", null);


        add(this.SideTabs);


    }
}
