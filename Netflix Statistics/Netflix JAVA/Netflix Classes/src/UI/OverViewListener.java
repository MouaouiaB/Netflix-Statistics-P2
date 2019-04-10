package UI;

import Repositories.AccountRepository;
import javafx.geometry.Side;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.sql.SQLException;

public class OverViewListener extends JPanel implements IAddingTabs {
    private JTabbedPane SideTabs;

    private AccountRepository accountRepository = new AccountRepository();
    private OverViewItemListener overViewItemListener;
    private OverViewItemListener Account = new OverViewItemListener("Account");

    public OverViewListener() throws SQLException {
        super(new BorderLayout());
        TabsAdd();
    }

    @Override
    public void TabsAdd() throws SQLException {
        this.SideTabs = new JTabbedPane();
        this.SideTabs.setFont(new Font("Side", Font.BOLD|Font.BOLD, 20 ));
        this.SideTabs.setTabPlacement(JTabbedPane.LEFT);





        this.SideTabs.addTab("Account", overViewItemListener = new OverViewItemListener("Account"));
        this.SideTabs.addTab("Profiel", overViewItemListener = new OverViewItemListener("Profiel"));
        this.SideTabs.addTab("Movie", overViewItemListener = new OverViewItemListener("Movie"));
        this.SideTabs.addTab("Serie", overViewItemListener = new OverViewItemListener("Movie"));
        this.SideTabs.addTab("Episode", overViewItemListener = new OverViewItemListener("Episode"));
        this.SideTabs.addTab("Program", overViewItemListener = new OverViewItemListener("Program"));



        /*JButton Acc = new JButton();

        add(Acc, BorderLayout.WEST);*/


        add(this.SideTabs);


    }
}
