package UI;

import Repositories.AccountRepository;
import Repositories.EpisodeRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class StatisticsListener extends JPanel implements IAddingTabs {
    private JTabbedPane SideTabs;
    private JButton WachtedMovie;
    private JButton PrecEpisode;
    private JButton LongestMovie;
    private JButton MoviesByPerson;
    private JTable table;
    private JPanel panel;
    private JScrollPane scrollPane;
    private StatisticsItemListener statisticsItemListener;
    private EpisodeRepository episodeRepository = new EpisodeRepository();
    private AccountRepository accountRepository = new AccountRepository();

    public StatisticsListener(){
        super(new BorderLayout());
        TabsAdd();
    }

    @Override
    public void TabsAdd() {
        panel = new JPanel();
        table = new JTable();
        scrollPane = new JScrollPane();

        WachtedMovie = new JButton("Accounts met 1 profiel");
        PrecEpisode = new JButton("Gemmideld bekeken aflevering");
        LongestMovie = new JButton("Langste Film onder 16");
        MoviesByPerson = new JButton("Films bekeken per persoon");

        WachtedMovie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    statisticsItemListener = new StatisticsItemListener("Accounts");
                    statisticsItemListener.getTable();
                    table.setModel(statisticsItemListener.getTable().getModel());

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        PrecEpisode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    statisticsItemListener = new StatisticsItemListener("Gemiddeld");
                    statisticsItemListener.getTable();
                    table.setModel(statisticsItemListener.getTable().getModel());

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }
        });
        LongestMovie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    statisticsItemListener = new StatisticsItemListener("Langste");
                    statisticsItemListener.getTable();
                    table.setModel(statisticsItemListener.getTable().getModel());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        MoviesByPerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    statisticsItemListener = new StatisticsItemListener("Film");
                    statisticsItemListener.getTable();
                    table.setModel(statisticsItemListener.getTable().getModel());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        panel.add(WachtedMovie);
        panel.add(PrecEpisode);
        panel.add(LongestMovie);
        panel.add(MoviesByPerson);

        scrollPane.setViewportView(table);
        add(scrollPane);
        add(panel, BorderLayout.SOUTH);
        /*this.SideTabs = new JTabbedPane();
        this.SideTabs.setFont(new Font("Side", Font.BOLD|Font.BOLD, 20 ));
        this.SideTabs.setTabPlacement(JTabbedPane.LEFT);
        this.SideTabs.addTab("Stats1", null);
        this.SideTabs.addTab("Stats2", null);
        this.SideTabs.addTab("Stats3", null);
        this.SideTabs.addTab("Stats4", null);
        this.SideTabs.addTab("Episode", null);
        this.SideTabs.addTab("Program", null);*/
    }
}

