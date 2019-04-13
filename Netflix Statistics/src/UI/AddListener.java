package UI;

import org.omg.CORBA.PRIVATE_MEMBER;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddListener extends JPanel{

    private JTabbedPane SideTabs;
    private JTable table;
    private AddItemListener addItemListener;
    private AddItemListener acc = new AddItemListener("Account");

    public AddListener(){
        super(new BorderLayout());
        TabsAdd();
    }



    public void TabsAdd() {


        this.SideTabs = new JTabbedPane();
        this.SideTabs.setFont(new Font("Side", Font.BOLD|Font.BOLD, 20 ));
        this.SideTabs.setTabPlacement(JTabbedPane.LEFT);
        this.SideTabs.addTab("Account",this.addItemListener = new AddItemListener("Account"));
        this.SideTabs.addTab("Profiel", this.addItemListener = new AddItemListener("Profiel"));
        this.SideTabs.addTab("Movie", this.addItemListener = new AddItemListener("Movie"));
        this.SideTabs.addTab("Serie", this.addItemListener = new AddItemListener("Serie"));
        this.SideTabs.addTab("Episode", this.addItemListener = new AddItemListener("Episode"));
        this.SideTabs.addTab("Program", this.addItemListener = new AddItemListener("Program"));

        //this.SideTabs.addMouseListener(new AddItemListener());

        add(this.SideTabs);


    }
}
