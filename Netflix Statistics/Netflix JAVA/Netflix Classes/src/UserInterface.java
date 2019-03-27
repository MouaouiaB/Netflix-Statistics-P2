import javax.swing.*;
import java.awt.*;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {
    private JFrame frame;
    private JTabbedPane Tabs;
    private JTabbedPane SideTabs;


    @Override
    public void run() {
        frame = new JFrame ("NetflixStatistics");
        frame.setPreferredSize(new Dimension(1000, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    private void createComponents(Container contentPane) {
        contentPane.setLayout(new BorderLayout());
        this.Tabs = new JTabbedPane();
        this.SideTabs = new JTabbedPane();
        this.Tabs.setFont(new Font("Overview", Font.BOLD|Font.BOLD, 20 ));
        this.SideTabs.setFont(new Font("Side", Font.BOLD|Font.BOLD, 20 ));

        this.SideTabs.setTabPlacement(JTabbedPane.LEFT);

        this.SideTabs.addTab("Per", null);
        this.SideTabs.addTab("paaar", null);

        JPanel Account = new JPanel();
        Account.add(SideTabs);
        this.Tabs.addTab("Accounts",Account);
        Account.setLayout(new GridLayout(2,1,0,0));

        JPanel AccountForm = new JPanel();
        Account.add(AccountForm);
        AccountForm.setLayout(new GridLayout(0,1,0,9));



        this.Tabs.addTab("Add",null);
        this.Tabs.addTab("Delete",null);
        this.Tabs.addTab("Update",null);
        contentPane.add(this.Tabs);



    }
}
