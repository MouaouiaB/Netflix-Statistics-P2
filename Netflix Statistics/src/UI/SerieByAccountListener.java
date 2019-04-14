package UI;

import Repositories.AccountRepository;
import Repositories.EpisodeRepository;
import Repositories.SerieRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SerieByAccountListener extends JPanel implements IAddingTabs {
    private JComboBox Account;
    private JComboBox Serie;

    private JButton PrecEpisode;
    private JButton refresh;

    private JTable table;

    private JPanel panel;

    private JScrollPane scrollPane;

    private JLabel LabelAccount;
    private JLabel LabelSerie;
    private JLabel LabelText;

    private GetDataItemListener getDataItemListener;

    private AccountRepository accountRepository = new AccountRepository();
    private SerieRepository serieRepository = new SerieRepository();

    public SerieByAccountListener() throws SQLException {
        super(new BorderLayout());
        TabsAdd();
    }

    @Override
    public void TabsAdd() throws SQLException {
        panel = new JPanel();
        table = new JTable();

        PrecEpisode = new JButton("Laat zien");
        refresh = new JButton("Refresh account box");

        table.setBounds(12, 55, 475, 309);
        scrollPane = new JScrollPane();



        Account = new JComboBox();
        Account.setModel(new DefaultComboBoxModel(accountRepository.getAccountNames().toArray()));
        Account.setBounds(600, 13, 200, 22);

        Serie = new JComboBox();
        Serie.setModel(new DefaultComboBoxModel(serieRepository.getTitles().toArray()));
        Serie.setBounds(600, 13, 200, 22);


        LabelText = new JLabel("Gemiddeld bekeken per aflevering:    ");
        LabelAccount = new JLabel("Account:");
        LabelSerie = new JLabel("Serie");

        PrecEpisode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    getDataItemListener = new GetDataItemListener("Gemiddeld");
                    getDataItemListener.avgEpisodeByAccount(Account.getSelectedItem().toString(), Serie.getSelectedItem().toString());
                    getDataItemListener.getTable();
                    table.setModel(getDataItemListener.getTable().getModel());




                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        //refreshes account box after adding new account
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Account.setModel(new DefaultComboBoxModel(accountRepository.getAccountNames().toArray()));
                Serie.setModel(new DefaultComboBoxModel(serieRepository.getTitles().toArray()));
            }
        });


        panel.add(LabelText);
        panel.add(LabelAccount);
        panel.add(Account);
        panel.add(LabelSerie);
        panel.add(Serie);
        panel.add(PrecEpisode);
        panel.add(refresh);

        scrollPane.setViewportView(table);
        add(scrollPane);
        add(panel, BorderLayout.NORTH);
    }

}
