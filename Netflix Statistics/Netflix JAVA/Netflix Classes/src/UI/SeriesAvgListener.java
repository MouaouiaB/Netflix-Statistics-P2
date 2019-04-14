package UI;

import Repositories.AccountRepository;
import Repositories.EpisodeRepository;
import Repositories.SerieRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SeriesAvgListener extends JPanel implements IAddingTabs {
    private JComboBox Account;
    private JComboBox Serie;
    private JTabbedPane SideTabs;
    private JButton PrecEpisode;
    private JTable table;
    private JPanel panel;
    private JScrollPane scrollPane;
    private JLabel LabelAccount;
    private JLabel LabelSerie;
    private GetDataItemListener getDataItemListener;
    private EpisodeRepository episodeRepository = new EpisodeRepository();
    private AccountRepository accountRepository = new AccountRepository();
    private SerieRepository serieRepository = new SerieRepository();

    public SeriesAvgListener() throws SQLException {
        super(new BorderLayout());
        TabsAdd();
    }

    @Override
    public void TabsAdd() throws SQLException {
        panel = new JPanel();
        table = new JTable();

        PrecEpisode = new JButton("Laat zien");

        table.setBounds(12, 55, 475, 309);
        scrollPane = new JScrollPane();



        Serie = new JComboBox();
        Serie.setModel(new DefaultComboBoxModel(serieRepository.getTitles().toArray()));
        Serie.setBounds(600, 13, 200, 22);


        LabelSerie = new JLabel("Serie");

        PrecEpisode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    getDataItemListener = new GetDataItemListener("Gemiddeld");
                    getDataItemListener.avgSelectedSerie(Serie.getSelectedItem().toString());
                    getDataItemListener.getTable();
                    table.setModel(getDataItemListener.getTable().getModel());




                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });


        panel.add(LabelSerie);
        panel.add(Serie);
        panel.add(PrecEpisode);



        /*WachtedMovie = new JButton("Accounts met 1 profiel");
        PrecEpisode = new JButton("Gemmideld bekeken aflevering");
        LongestMovie = new JButton("Langste Film onder 16");
        MoviesByPerson = new JButton("Films bekeken per persoon");*/




        /*panel.add(WachtedMovie);
        panel.add(PrecEpisode);
        panel.add(LongestMovie);
        panel.add(MoviesByPerson);*/


        scrollPane.setViewportView(table);
        add(scrollPane);
        add(panel, BorderLayout.NORTH);
    }

}
