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
    private StatisticsListener statisticsListener;


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

        addListener = new AddListener();
        deleteListener = new DeleteListener();
        updateListener = new UpdateListener();
        overViewListener = new OverViewListener();
        statisticsListener = new StatisticsListener();
        this.Tabs = new JTabbedPane();

        this.Tabs.setFont(new Font("Overview", Font.BOLD|Font.BOLD, 20 ));

        JPanel panel = new JPanel();

        this.Tabs.addTab("Toevoegen",addListener);
        this.Tabs.addTab("Verwijderen",deleteListener);
        this.Tabs.addTab("Wijzigen",updateListener);
        this.Tabs.addTab("Overzicht",overViewListener);
        this.Tabs.addTab("Statistieken",statisticsListener);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(Tabs);
        contentPane.add(panel);

        //contentPane.add(this.Tabs);



    }
}
