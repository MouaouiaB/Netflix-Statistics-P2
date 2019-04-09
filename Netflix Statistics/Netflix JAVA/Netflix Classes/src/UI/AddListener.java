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
        this.SideTabs.addTab("Movie", this.addItemListener = new AddItemListener("Movie"));
        this.SideTabs.addTab("Serie", this.addItemListener = new AddItemListener("Serie"));
        this.SideTabs.addTab("Episode", this.addItemListener = new AddItemListener("Episode"));
        this.SideTabs.addTab("Program", this.addItemListener = new AddItemListener("Program"));


        add(this.SideTabs);


    }
}
