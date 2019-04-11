package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class OverViewListener extends JPanel {
    private JTabbedPane SideTabs;
    private OverViewItemListener overViewItemListener;
    private JButton BtnAccount;
    private JButton BtnProfile;
    private JButton BtnMovie;
    private JButton BtnSerie;
    private JButton BtnEpisode;
    private JButton BtnProgram;
    private JPanel panel;
    private JTable table;


    public OverViewListener() throws SQLException {
        super(new BorderLayout());
        TabsAdd();
    }


    public void TabsAdd() throws SQLException {

        panel = new JPanel();

        table = new JTable();

        JScrollPane scrollPane = new JScrollPane();

        BtnAccount = new JButton("Account");
       BtnProfile = new JButton("Profiel");
       BtnMovie = new JButton("Film");
       BtnSerie = new JButton("Serie");
       BtnEpisode = new JButton("Aflevering");
       BtnProgram = new JButton("Program");

        BtnAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    overViewItemListener = new OverViewItemListener("Account");
                    overViewItemListener.getTable();
                    table.setModel(overViewItemListener.getTable().getModel());

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        BtnProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    overViewItemListener = new OverViewItemListener("Profile");
                    overViewItemListener.getTable();
                    table.setModel(overViewItemListener.getTable().getModel());

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        BtnMovie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    overViewItemListener = new OverViewItemListener("Film");
                    overViewItemListener.getTable();
                    table.setModel(overViewItemListener.getTable().getModel());

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        BtnSerie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    overViewItemListener = new OverViewItemListener("Serie");
                    overViewItemListener.getTable();
                    table.setModel(overViewItemListener.getTable().getModel());

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        BtnEpisode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    overViewItemListener = new OverViewItemListener("Aflevering");
                    overViewItemListener.getTable();
                    table.setModel(overViewItemListener.getTable().getModel());

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        BtnProgram.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    overViewItemListener = new OverViewItemListener("Program");
                    overViewItemListener.getTable();
                    table.setModel(overViewItemListener.getTable().getModel());

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        panel.add(BtnAccount);
        panel.add(BtnProfile);
        panel.add(BtnMovie);
        panel.add(BtnSerie);
        panel.add(BtnEpisode);
        panel.add(BtnProgram);


        scrollPane.setViewportView(table);
        add(scrollPane);
        //add(table, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);



    }


}
