package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class UserInterface implements Runnable {
    private JFrame frame;
    private JTabbedPane Tabs;
    private JTabbedPane SideTabs;
    private AddListener addListener;
    private DeleteListener deleteListener;
    private UpdateListener updateListener;
    private OverViewListener overViewListener;


    public UserInterface() throws SQLException {

    }
    @Override
    public void run() {
        frame = new JFrame ("NetflixStatistics");
        frame.setPreferredSize(new Dimension(1000, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        try {
            createComponents(frame.getContentPane());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        frame.pack();
        frame.setVisible(true);


    }

    private void createComponents(Container contentPane) throws SQLException {
        contentPane.setLayout(new BorderLayout());
        this.Tabs = new JTabbedPane();

        this.Tabs.setFont(new Font("Overview", Font.BOLD|Font.BOLD, 20 ));



        JPanel Account = new JPanel();



        this.Tabs.addTab("Toevoegen",addListener = new AddListener());
        Account.setLayout(new GridLayout(2,1,0,0));



        this.Tabs.addTab("Verwijderen",deleteListener = new DeleteListener());
        this.Tabs.addTab("Wijzigen",updateListener = new UpdateListener());
        this.Tabs.addTab("Overzicht",overViewListener = new OverViewListener());
        this.Tabs.addTab("Statestieken",null);



        Account.add(Tabs);
        contentPane.add(Account);

        contentPane.add(this.Tabs);



    }
}
