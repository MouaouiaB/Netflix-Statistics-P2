package UI;

import javax.swing.*;
import java.awt.*;

public class DeleteListener extends JPanel implements IAddingTabs {
    private JTabbedPane SideTabs;
    public DeleteItemListener deleteItemListener;

    public DeleteListener(){
        super(new BorderLayout());
        TabsAdd();
    }




    @Override
    public void TabsAdd() {
        this.SideTabs = new JTabbedPane();
        this.SideTabs.setFont(new Font("Side", Font.BOLD|Font.BOLD, 20 ));
        this.SideTabs.setTabPlacement(JTabbedPane.LEFT);

        //creates side tabs
        this.SideTabs.addTab("Account", this.deleteItemListener = new DeleteItemListener("Account"));
        this.SideTabs.addTab("Profiel", this.deleteItemListener = new DeleteItemListener("Profiel"));
        this.SideTabs.addTab("Programma", this.deleteItemListener = new DeleteItemListener("Program"));

        //adds side tabs
        add(this.SideTabs);


    }
}
