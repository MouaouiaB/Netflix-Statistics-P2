package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddListener extends JPanel{

    private JTabbedPane SideTabs;

    public AddListener(){
        super(new BorderLayout());
        TabsAdd();
    }


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
