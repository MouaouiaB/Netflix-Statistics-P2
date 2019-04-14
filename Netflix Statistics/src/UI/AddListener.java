package UI;

import org.omg.CORBA.PRIVATE_MEMBER;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddListener extends JPanel{

    private JTabbedPane SideTabs;
    private AddItemListener addItemListener;
    private AddItemListener acc = new AddItemListener("Account");

    public AddListener(){
        super(new BorderLayout());
        TabsAdd();
    }


    //Adds side tabs
    public void TabsAdd() {

        this.SideTabs = new JTabbedPane();
        this.SideTabs.setFont(new Font("Side", Font.BOLD|Font.BOLD, 20 ));
        this.SideTabs.setTabPlacement(JTabbedPane.LEFT);

        //Side tabs
        this.SideTabs.addTab("Account",this.addItemListener = new AddItemListener("Account"));
        this.SideTabs.addTab("Profiel", this.addItemListener = new AddItemListener("Profiel"));
        this.SideTabs.addTab("Programma", this.addItemListener = new AddItemListener("Programma"));

        add(this.SideTabs);


    }
}
