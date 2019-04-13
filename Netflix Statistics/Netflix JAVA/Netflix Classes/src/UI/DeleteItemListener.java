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
    private JTextField textPasswd;
    private JTextField textMail;
    private JTextField textStreet;
    private JTextField textStrNumber;
    private JTextField textZip;
    private JTextField textCity;

    private JLabel labelNaam;
    private JLabel labelPasswd;
    private JLabel labelMail;
    private JLabel labelStreet;
    private JLabel labelStrNumber;
    private JLabel labelZip;
    private JLabel labelCity;
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
    //Movie settings
    private JTextField textFilmId;
    private JTextField textFilmTitle;
    private JTextField textFilmAge;
    private JTextField textFilmLanguage;
    private JTextField textFilmDuration;
    private JTextField textFilmGenre;

    private JLabel labelFilmId;
    private JLabel labelFilmTitle;
    private JLabel labelFilmAge;
    private JLabel labelFilmLanguage;
    private JLabel labelFilmDuration;
    private JLabel labelFilmGenre;
    private JButton BtnFilm;
    /////////////////////////////////////
    //Serie settings
    private JTextField textSerieId;
    private JTextField textSerieTitle;
    private JTextField textSerieSeas;
    private JTextField textSerieAge;
    private JTextField textSerieLanguage;
    private JTextField textSerieGenre;
    private JTextField textSerieCompare;

    private JLabel labelSerieId;
    private JLabel labelSerieTitle;
    private JLabel labelSerieSeas;
    private JLabel labelSerieAge;
    private JLabel labelSerieLanguage;
    private JLabel labelSerieGenre;
    private JLabel labelSerieCompare;
    private JButton BtnSerie;
    ///////////////////////////////////////////
    //Episode settings
    private JTextField textEpId;
    private JTextField textEpSerie;
    private JTextField textEpSerieId;
    private JTextField textEpSeasEp;
    private JTextField textEpTitle;
    private JTextField textEpDuration;

    private JLabel labelEpId;
    private JLabel labelEpSerie;
    private JLabel labelEpSerieId;
    private JLabel labelEpSeasEp;
    private JLabel labelEpTitle;
    private JLabel labelEpDuration;
    private JButton BtnEp;
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

            BtnAcc.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    accountRepository.delete(accountRepository.readIdWithName(textName.getText()));
                    textName.setText("");
                }
            });

        }
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

        if (tabName == "Movie"){
            labelFilmTitle = new JLabel("Titel:");
            labelFilmTitle.setBounds(12, 24, 100, 16);
            add(labelFilmTitle);

            textFilmTitle = new JTextField();
            textFilmTitle.setColumns(20);
            textFilmTitle.setBounds(201, 21, 300, 22);
            add(textFilmTitle);


            BtnFilm = new JButton("Verwijder");
            BtnFilm.setBounds(322, 320, 116, 25);
            add(BtnFilm);

            BtnFilm.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    movieRepository.delete(movieRepository.readIdWithName(textFilmTitle.getText()));
                }
            });
        }

        if (tabName == "Serie"){
            labelSerieTitle = new JLabel("Titel:");
            labelSerieTitle.setBounds(12, 24, 100, 16);
            add(labelSerieTitle);

            textSerieTitle = new JTextField();
            textSerieTitle.setColumns(20);
            textSerieTitle.setBounds(201, 21, 300, 22);
            add(textSerieTitle);


            BtnSerie = new JButton("Verwijder");
            BtnSerie.setBounds(322, 320, 116, 25);
            add(BtnSerie);

            BtnSerie.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    serieRepository.delete(serieRepository.readIdWithName(textSerieTitle.getText()));
                }
            });

        }

        if (tabName == "Episode"){
            labelEpId = new JLabel("Episode ID:");
            labelEpId.setBounds(12, 24, 100, 16);
            add(labelEpId);

            textEpId = new JTextField();
            textEpId.setColumns(20);
            textEpId.setBounds(111, 21, 300, 22);
            add(textEpId);

            labelEpSerie = new JLabel("Serie:");
            labelEpSerie.setBounds(12, 64, 100, 16);
            add(labelEpSerie);

            textEpSerie = new JTextField();
            textEpSerie.setColumns(20);
            textEpSerie.setBounds(111, 64, 300, 22);
            add(textEpSerie);

            labelEpSerieId= new JLabel("Serie ID:");
            labelEpSerieId.setBounds(12, 107, 100, 16);
            add(labelEpSerieId);

            textEpSerieId = new JTextField();
            textEpSerieId.setColumns(20);
            textEpSerieId.setBounds(111, 107, 300, 22);
            add(textEpSerieId);

            labelEpSeasEp = new JLabel("Seizoen en Episode (Format: S01A01):");
            labelEpSeasEp.setBounds(12, 150, 300, 16);
            add(labelEpSeasEp);

            textEpSeasEp = new JTextField();
            textEpSeasEp.setColumns(20);
            textEpSeasEp.setBounds(300, 150, 300, 22);
            add(textEpSeasEp);

            labelEpTitle = new JLabel("Titel:");
            labelEpTitle.setBounds(12, 193, 100, 16);
            add(labelEpTitle);

            textEpTitle = new JTextField();
            textEpTitle.setColumns(20);
            textEpTitle.setBounds(111, 193, 300, 22);
            add(textEpTitle);

            labelEpDuration = new JLabel("Tijdsduur:");
            labelEpDuration.setBounds(12, 236, 100, 16);
            add(labelEpDuration);

            textEpDuration = new JTextField();
            textEpDuration.setColumns(20);
            textEpDuration.setBounds(111, 236, 300, 22);
            add(textEpDuration);

            BtnEp = new JButton("Verwijder");
            BtnEp.setBounds(322, 320, 116, 25);
            add(BtnEp);
        }

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

