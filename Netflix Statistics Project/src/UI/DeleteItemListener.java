package UI;

import Repositories.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteItemListener extends JPanel {
    private JTable table;
    private JTable Proftable;
    private JButton button;
    //Account settings
    private JPanel panel;
    private JTextField textName;

    private JLabel labelNaam;
    private JButton BtnAcc;
    /////////////////////////////////
    //Profile settings
    private JTextField textProfId;
    private JTextField textProfName;
    private JTextField textProfAccId;
    private JTextField textProfAge;

    private JLabel labelProfId;
    private JLabel labelProfName;
    private JLabel labelProfAccId;
    private JLabel labelProfAge;
    private JButton BtnProf;
    //////////////////////////////////
    ///////////////////////////////////////////
    //Program settings
    private JLabel labelProgId;
    private JLabel labelProgTitle;
    private JLabel labelProgFilmId;
    private JLabel labelProgSerieId;
    private JLabel labelProgEpId;
    private JLabel labelProgProfId;

    private JTextField textProgId;
    private JTextField textProgTitle;
    private JTextField textProgFilmId;
    private JTextField textProgSerieId;
    private JTextField textProgEpId;
    private JTextField textProgProfId;
    private JButton BtnProg;
    /////////////////////////////////////////////
    //Repositories
    AccountRepository accountRepository;
    EpisodeRepository episodeRepository;
    MovieRepository movieRepository;
    ProfileRepository profileRepository;
    ProgramRepository programRepository;
    SerieRepository serieRepository;

    public DeleteItemListener(String tabName){
        super(new BorderLayout());
        this.accountRepository = new AccountRepository();
        this.episodeRepository = new EpisodeRepository();
        this.profileRepository = new ProfileRepository();
        this.programRepository = new ProgramRepository();
        this.movieRepository = new MovieRepository();
        this.serieRepository = new SerieRepository();
        LoadComponents(tabName);
    }

    public void LoadComponents (String tabName){

            setBorder(new EmptyBorder(5, 5, 5, 5));
            setLayout(null);
            this.button = new JButton();

            this.table = new JTable();


        this.textName = new JTextField();
        //Loads account form
        if (tabName == "Account"){

            labelNaam = new JLabel("Account naam:");
            labelNaam.setBounds(12, 24, 100, 16);
            add(labelNaam);

            textName = new JTextField();
            textName.setColumns(20);
            textName.setBounds(201, 21, 300, 22);
            add(textName);


            BtnAcc = new JButton("Verwijder");
            BtnAcc.setBounds(322, 320, 116, 25);
            add(BtnAcc);

            //Adds info given to repositories
            BtnAcc.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    accountRepository.delete(accountRepository.readIdWithName(textName.getText()));
                    textName.setText("");
                }
            });

        }
        //Loads profile form
        if (tabName == "Profiel"){

            labelProfName = new JLabel("Profielnaam:");
            labelProfName.setBounds(12, 24, 100, 16);
            add(labelProfName);

            textProfName = new JTextField();
            textProfName.setColumns(20);
            textProfName.setBounds(201, 21, 300, 22);
            add(textProfName);

            BtnProf = new JButton("Verwijder");
            BtnProf.setBounds(322, 320, 116, 25);
            add(BtnProf);

            BtnProf.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    profileRepository.delete(profileRepository.readIdWithName(textProfName.getText()));
                    textProfName.setText("");
                }
            });
        }

        //loads program form
        if (tabName == "Program"){
            labelProgTitle = new JLabel("Programma ID kunt u vinden in het overzicht onder 'Programma's'. De titel staat er ook bij.");
            labelProgTitle.setBounds(12, 24, 900, 16);
            add(labelProgTitle);


            labelProgId = new JLabel("Programma ID (alleen getallen):");
            labelProgId.setBounds(12, 64, 300, 16);
            add(labelProgId);

            textProgId = new JTextField();
            textProgId.setColumns(20);
            textProgId.setBounds(201, 64, 300, 22);
            add(textProgId);


            BtnProg = new JButton("Verwijder");
            BtnProg.setBounds(322, 320, 116, 25);
            add(BtnProg);

            BtnProg.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    programRepository.delete(Integer.parseInt(textProgId.getText()));
                    textProfId.setText("");
                }
            });
        }
    }
}

