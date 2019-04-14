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
    private JComboBox comboBox;
    private GetDataItemListener getDataItemListener;
    private EpisodeRepository episodeRepository = new EpisodeRepository();
    private AccountRepository accountRepository = new AccountRepository();

    public StatisticsListener(){
        super(new BorderLayout());
        TabsAdd();
    }

    @Override
    public void TabsAdd() {
        new GridLayout(6, 6, 0, 0);
        panel = new JPanel();

        table = new JTable();

        scrollPane = new JScrollPane();

        comboBox = new JComboBox();

        WachtedMovie = new JButton("Accounts met 1 profiel");
        LongestMovie = new JButton("Langste Film onder 16");

        WachtedMovie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    getDataItemListener = new GetDataItemListener("Accounts");
                    getDataItemListener.getTable();
                    table.setModel(getDataItemListener.getTable().getModel());

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        LongestMovie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    getDataItemListener = new GetDataItemListener("Langste");
                    getDataItemListener.getTable();
                    table.setModel(getDataItemListener.getTable().getModel());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        panel.add(WachtedMovie);
        panel.add(LongestMovie);


        scrollPane.setViewportView(table);
        add(scrollPane);
        add(panel, BorderLayout.NORTH);
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

