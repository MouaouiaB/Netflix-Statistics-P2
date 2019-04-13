package UI;

import Domain.*;
import Repositories.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddItemListener extends JPanel {

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
    private JTextField textProfAcc;
    private JTextField textProfName;
    private JTextField textProfAccId;
    private JTextField textProfAge;

    private JLabel labelProfAcc;
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
    private JLabel labelProgAcc;
    private JLabel labelProgProf;
    private JLabel labelProgFiSer;
    private JLabel labelProgEp;
    private JLabel labelProgPer;
    private JLabel labelProgProfId;

    private JTextField textProgAcc;
    private JTextField textProgProf;
    private JTextField textProgFiSer;
    private JTextField textProgEp;
    private JTextField textProgPer;
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

    public AddItemListener(String tabName){
        super(new BorderLayout());
        this.accountRepository = new AccountRepository();
        this.episodeRepository = new EpisodeRepository();
        this.profileRepository = new ProfileRepository();
        this.programRepository = new ProgramRepository();
        this.movieRepository = new MovieRepository();
        this.serieRepository = new SerieRepository();
        LoadComponents(tabName);
    }

    public void LoadComponents(String tabName){

        setBorder(new EmptyBorder(5,5,5,5));
        setLayout(null);
        this.button = new JButton();

        this.table = new JTable();



        this.textName = new JTextField();
        if (tabName == "Account"){

            labelNaam = new JLabel("Naam:");
            labelNaam.setBounds(12, 24, 100, 16);
            add(labelNaam);

            textName = new JTextField();
            textName.setColumns(20);
            textName.setBounds(111, 21, 300, 22);
            add(textName);

            labelPasswd = new JLabel("Wachtwoord:");
            labelPasswd.setBounds(12, 64, 100, 16);
            add(labelPasswd);

            textPasswd = new JTextField();
            textPasswd.setColumns(20);
            textPasswd.setBounds(111, 64, 300, 22);
            add(textPasswd);

            labelMail = new JLabel("E-mail:");
            labelMail.setBounds(12, 107, 100, 16);
            add(labelMail);

            textMail = new JTextField();
            textMail.setColumns(20);
            textMail.setBounds(111, 107, 300, 22);
            add(textMail);

            labelStreet = new JLabel("Straat:");
            labelStreet.setBounds(12, 150, 100, 16);
            add(labelStreet);

            textStreet = new JTextField();
            textStreet.setColumns(20);
            textStreet.setBounds(111, 150, 300, 22);
            add(textStreet);

            labelStrNumber = new JLabel("Huisnummer:");
            labelStrNumber.setBounds(12, 193, 100, 16);
            add(labelStrNumber);

            textStrNumber = new JTextField();
            textStrNumber.setColumns(20);
            textStrNumber.setBounds(111, 193, 300, 22);
            add(textStrNumber);

            labelZip = new JLabel("Postcode:");
            labelZip.setBounds(12, 236, 100, 16);
            add(labelZip);

            textZip = new JTextField();
            textZip.setColumns(20);
            textZip.setBounds(111, 236, 300, 22);
            add(textZip);

            labelCity = new JLabel("Stad:");
            labelCity.setBounds(12, 279, 100, 16);
            add(labelCity);

            textCity = new JTextField();
            textCity.setColumns(20);
            textCity.setBounds(111, 279, 300, 22);
            add(textCity);

            BtnAcc = new JButton("Opslaan");
            BtnAcc.setBounds(322, 320, 116, 25);
            add(BtnAcc);


            /*String number = textStrNumber.getText();
            int housenumber = Integer.parseInt(number);*/

            BtnAcc.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    accountRepository.create(new Account(textName.getText(), textMail.getText(), textPasswd.getText(), textStreet.getText(),textStrNumber.getText(),textZip.getText(), textCity.getText()));
                    textName.setText("");
                    textMail.setText("");
                    textPasswd.setText("");
                    textStreet.setText("");
                    textStrNumber.setText("");
                    textZip.setText("");
                    textCity.setText("");
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


            labelProfAge = new JLabel("Leeftijd:");
            labelProfAge.setBounds(12, 107, 300, 16);
            add(labelProfAge);


            textProfAge = new JTextField();
            textProfAge.setColumns(20);
            textProfAge.setBounds(201, 107, 300, 22);
            add(textProfAge);

            labelProfAcc = new JLabel("Account:");
            labelProfAcc.setBounds(12, 190, 100, 16);
            add(labelProfAcc);

            textProfAcc = new JTextField();
            textProfAcc.setColumns(20);
            textProfAcc.setBounds(201, 190, 300, 22);
            add(textProfAcc);



            BtnProf = new JButton("Opslaan");
            BtnProf.setBounds(322, 320, 116, 25);
            add(BtnProf);

            BtnProf.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    profileRepository.create(new Profile(textProfName.getText(),textProfAcc.getText(), Integer.parseInt(textProfAge.getText())));
                }
            });
        }

        if (tabName == "Movie"){
            labelFilmTitle = new JLabel("Titel:");
            labelFilmTitle.setBounds(12, 24, 100, 16);
            add(labelFilmTitle);

            textFilmTitle = new JTextField();
            textFilmTitle.setColumns(20);
            textFilmTitle.setBounds(111, 21, 300, 22);
            add(textFilmTitle);

            labelFilmAge = new JLabel("Leeftijfsindicatie:");
            labelFilmAge.setBounds(12, 64, 100, 16);
            add(labelFilmAge);

            textFilmAge = new JTextField();
            textFilmAge.setColumns(20);
            textFilmAge.setBounds(111, 64, 300, 22);
            add(textFilmAge);

            labelFilmLanguage = new JLabel("Taal:");
            labelFilmLanguage.setBounds(12, 107, 100, 16);
            add(labelFilmLanguage);

            textFilmLanguage = new JTextField();
            textFilmLanguage.setColumns(20);
            textFilmLanguage.setBounds(111, 107, 300, 22);
            add(textFilmLanguage);

            labelFilmDuration = new JLabel("Tijdsduur:");
            labelFilmDuration.setBounds(12, 150, 100, 16);
            add(labelFilmDuration);

            textFilmDuration = new JTextField();
            textFilmDuration.setColumns(20);
            textFilmDuration.setBounds(111, 150, 300, 22);
            add(textFilmDuration);

            labelFilmGenre = new JLabel("Genre:");
            labelFilmGenre.setBounds(12, 193, 100, 16);
            add(labelFilmGenre);

            textFilmGenre = new JTextField();
            textFilmGenre.setColumns(20);
            textFilmGenre.setBounds(111, 193, 300, 22);
            add(textFilmGenre);

            BtnFilm = new JButton("Opslaan");
            BtnFilm.setBounds(322, 320, 116, 25);
            add(BtnFilm);

            BtnFilm.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    movieRepository.create(new Movie(textFilmTitle.getText(), Integer.parseInt(textFilmDuration.getText()), textFilmGenre.getText(), textFilmLanguage.getText(), Integer.parseInt(textFilmAge.getText())));
                }
            });
        }

        if (tabName == "Serie"){
            labelSerieId = new JLabel("Serie ID:");
            labelSerieId.setBounds(12, 24, 100, 16);
            add(labelSerieId);

            textSerieId = new JTextField();
            textSerieId.setColumns(20);
            textSerieId.setBounds(111, 21, 300, 22);
            add(textSerieId);

            labelSerieTitle = new JLabel("Titel:");
            labelSerieTitle.setBounds(12, 64, 100, 16);
            add(labelSerieTitle);

            textSerieTitle = new JTextField();
            textSerieTitle.setColumns(20);
            textSerieTitle.setBounds(111, 64, 300, 22);
            add(textSerieTitle);

            labelSerieAge = new JLabel("Leeftijfsindicatie:");
            labelSerieAge.setBounds(12, 107, 100, 16);
            add(labelSerieAge);

            textSerieAge = new JTextField();
            textSerieAge.setColumns(20);
            textSerieAge.setBounds(111, 107, 300, 22);
            add(textSerieAge);

            labelSerieLanguage = new JLabel("Taal:");
            labelSerieLanguage.setBounds(12, 150, 100, 16);
            add(labelSerieLanguage);

            textSerieLanguage = new JTextField();
            textSerieLanguage.setColumns(20);
            textSerieLanguage.setBounds(111, 150, 300, 22);
            add(textSerieLanguage);

            labelSerieSeas = new JLabel("Seizoenen:");
            labelSerieSeas.setBounds(12, 193, 100, 16);
            add(labelSerieSeas);

            textSerieSeas = new JTextField();
            textSerieSeas.setColumns(20);
            textSerieSeas.setBounds(111, 193, 300, 22);
            add(textSerieSeas);

            labelSerieGenre = new JLabel("Genre:");
            labelSerieGenre.setBounds(12, 236, 100, 16);
            add(labelSerieGenre);

            textSerieGenre = new JTextField();
            textSerieGenre.setColumns(20);
            textSerieGenre.setBounds(111, 236, 300, 22);
            add(textSerieGenre);

            labelSerieCompare = new JLabel("Lijkt op:");
            labelSerieCompare.setBounds(12, 279, 100, 16);
            add(labelSerieCompare);

            textSerieCompare = new JTextField();
            textSerieCompare.setColumns(20);
            textSerieCompare.setBounds(111, 279, 300, 22);
            add(textSerieCompare);

            BtnSerie = new JButton("Opslaan");
            BtnSerie.setBounds(322, 320, 116, 25);
            add(BtnSerie);

            BtnSerie.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    serieRepository.create(new Serie(textSerieTitle.getText(), Integer.parseInt(textSerieSeas.getText()), Integer.parseInt(textSerieAge.getText()), textSerieLanguage.getText(), textSerieGenre.getText(), textSerieCompare.getText()));
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

            BtnEp = new JButton("Opslaan");
            BtnEp.setBounds(322, 320, 116, 25);
            add(BtnEp);
        }

        if (tabName == "Program"){
            /*labelProgAcc = new JLabel("Account naam:");
            labelProgAcc.setBounds(12, 24, 100, 16);
            add(labelProgAcc);

            textProgAcc = new JTextField();
            textProgAcc.setColumns(20);
            textProgAcc.setBounds(111, 21, 300, 22);
            add(textProgAcc);*/

            labelProgProf = new JLabel("Profiel naam:");
            labelProgProf.setBounds(12, 64, 100, 16);
            add(labelProgProf);

            textProgProf = new JTextField();
            textProgProf.setColumns(20);
            textProgProf.setBounds(111, 64, 300, 22);
            add(textProgProf);

            labelProgFiSer = new JLabel("Film/Serie");
            labelProgFiSer.setBounds(12, 107, 100, 16);
            add(labelProgFiSer);

            textProgFiSer = new JTextField();
            textProgFiSer.setColumns(20);
            textProgFiSer.setBounds(111, 107, 300, 22);
            add(textProgFiSer);

            labelProgEp = new JLabel("Aflevering:");
            labelProgEp.setBounds(12, 150, 300, 16);
            add(labelProgEp);

            textProgEp = new JTextField();
            textProgEp.setColumns(20);
            textProgEp.setBounds(111, 150, 300, 22);
            add(textProgEp);

            labelProgPer = new JLabel("Percentage:");
            labelProgPer.setBounds(12, 193, 100, 16);
            add(labelProgPer);

            textProgPer = new JTextField();
            textProgPer.setColumns(20);
            textProgPer.setBounds(111, 193, 300, 22);
            add(textProgPer);

            /*labelProgProfId = new JLabel("Profiel ID:");
            labelProgProfId.setBounds(12, 236, 100, 16);
            add(labelProgProfId);

            textProgProfId = new JTextField();
            textProgProfId.setColumns(20);
            textProgProfId.setBounds(111, 236, 300, 22);
            add(textProgProfId);*/

            BtnProg = new JButton("Opslaan");
            BtnProg.setBounds(322, 320, 116, 25);
            add(BtnProg);

            BtnProg.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (textProgEp.getText() == ""){
                        programRepository.createMovie(new Program(textProgProf.getText(), textProgFiSer.getText(), Integer.parseInt(textProgPer.getText())));
                    }
                    else {
                        programRepository.createSerie(new Program(textProgProf.getText(), textProgFiSer.getText(), textProgEp.getText(), Integer.parseInt(textProgPer.getText())));

                    }

                }
            });

        }
    }
}

