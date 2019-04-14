package UI;

import Repositories.AccountRepository;
import Repositories.EpisodeRepository;
import Repositories.MovieRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class FilmsByAccountsListener extends JPanel implements IAddingTabs {
    private JComboBox AccountBox;
    private JButton PrecEpisode;
    private JButton refresh;
    private JTable table;
    private JPanel panel;
    private JScrollPane scrollPane;
    private JLabel LabelAccount;
    private JLabel labelText;
    private GetDataItemListener getDataItemListener;
    private EpisodeRepository episodeRepository = new EpisodeRepository();
    private AccountRepository accountRepository = new AccountRepository();
    private MovieRepository movieRepository = new MovieRepository();

    public FilmsByAccountsListener() throws SQLException {
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

        AccountBox = new JComboBox();
        AccountBox.setModel(new DefaultComboBoxModel(accountRepository.getAccountNames().toArray()));
        AccountBox.setBounds(600, 13, 200, 22);


        labelText = new JLabel("Bekeken film per account:    ");
        LabelAccount = new JLabel("Account:");

        PrecEpisode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    getDataItemListener = new GetDataItemListener("Gemiddeld");
                    getDataItemListener.watchedMovies(AccountBox.getSelectedItem().toString());
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
                AccountBox.setModel(new DefaultComboBoxModel(accountRepository.getAccountNames().toArray()));
            }
        });

        panel.add(labelText);
        panel.add(LabelAccount);
        panel.add(AccountBox);
        panel.add(PrecEpisode);
        panel.add(refresh);


        scrollPane.setViewportView(table);
        add(scrollPane);
        add(panel, BorderLayout.NORTH);

    }
}
