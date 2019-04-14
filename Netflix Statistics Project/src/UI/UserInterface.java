package UI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.Container;
import java.awt.Dimension;
import java.sql.SQLException;

public class UserInterface implements Runnable {
    private JFrame frame;
    private JTabbedPane Tabs;

    //Listeners
    private AddListener addListener;
    private DeleteListener deleteListener;
    private UpdateListener updateListener;
    private OverViewListener overViewListener;
    private StatisticsListener statisticsListener;
    private SerieByAccountListener serieByAccountListener;
    private FilmsByAccountsListener filmsByAccountsListener;
    private SeriesAvgListener seriesAvgListener;


    public UserInterface() throws SQLException {

    }
    @Override
    public void run() {
        frame = new JFrame ("NetflixStatistics");
        frame.setPreferredSize(new Dimension(1100, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        try {
            createComponents(frame.getContentPane());
        } catch (SQLException e) {
            e.printStackTrace();
        }


        frame.pack();
        frame.setVisible(true);


    }

    //Creates Interface
    private void createComponents(Container contentPane) throws SQLException {
        addListener = new AddListener();
        deleteListener = new DeleteListener();
        updateListener = new UpdateListener();
        overViewListener = new OverViewListener();
        statisticsListener = new StatisticsListener();
        serieByAccountListener = new SerieByAccountListener();
        filmsByAccountsListener = new FilmsByAccountsListener();
        seriesAvgListener = new SeriesAvgListener();

        this.Tabs = new JTabbedPane();

        this.Tabs.setFont(new Font("Overview", Font.BOLD|Font.BOLD, 20 ));

        JPanel panel = new JPanel();

        this.Tabs.addTab("Toevoegen",addListener);
        this.Tabs.addTab("Verwijderen",deleteListener);
        this.Tabs.addTab("Wijzigen",updateListener);
        this.Tabs.addTab("Tabellen",overViewListener);
        this.Tabs.addTab("Statestieken",statisticsListener);
        this.Tabs.addTab("Overzicht 1", serieByAccountListener);
        this.Tabs.addTab("Overzicht 2", filmsByAccountsListener);
        this.Tabs.addTab("Overzicht 3", seriesAvgListener);



        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Tabs);

        contentPane.add(panel);
        contentPane.add(bottomBar(), BorderLayout.SOUTH);
    }

    public JPanel bottomBar() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(3, 10, 3, 10));
        panel.add(new JLabel("Netflix Statistix", JLabel.LEFT), BorderLayout.WEST);
        panel.add(new JLabel("Informatica 2e Jaar 23IVT2C1 Ayman, Mouaouia, Rik", JLabel.RIGHT), BorderLayout.EAST);
        return panel;
    }
}
