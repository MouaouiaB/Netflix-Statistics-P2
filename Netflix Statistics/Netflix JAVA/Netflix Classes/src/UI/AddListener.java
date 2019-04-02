package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddListener extends JPanel implements IAddingTabs{

    private JTabbedPane SideTabs;
    private JTable table;
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
        this.SideTabs.addTab("Film", this.addItemListener = new AddItemListener("Film"));
        this.SideTabs.addTab("Serie", this.addItemListener = new AddItemListener("Serie"));
        this.SideTabs.addTab("Aflevering", this.addItemListener = new AddItemListener("Aflevering"));
        this.SideTabs.addTab("Programma", this.addItemListener = new AddItemListener("Programma"));


        add(this.SideTabs);


    }
}
