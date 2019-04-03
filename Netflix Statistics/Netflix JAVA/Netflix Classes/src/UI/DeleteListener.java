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
        this.SideTabs.addTab("Account", this.deleteItemListener = new DeleteItemListener("Account"));
        this.SideTabs.addTab("Profiel", this.deleteItemListener = new DeleteItemListener("Profiel"));
        this.SideTabs.addTab("Film", this.deleteItemListener = new DeleteItemListener("Film"));
        this.SideTabs.addTab("Serie", this.deleteItemListener = new DeleteItemListener("Serie"));
        this.SideTabs.addTab("Aflevering", this.deleteItemListener = new DeleteItemListener("Aflevering"));
        this.SideTabs.addTab("Programma", this.deleteItemListener = new DeleteItemListener("Programma"));

        add(this.SideTabs);


    }
}
