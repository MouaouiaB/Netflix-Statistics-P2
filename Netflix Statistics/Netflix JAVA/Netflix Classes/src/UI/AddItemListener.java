package UI;

import Domain.Account;
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

    public AddItemListener(String tabName){
        super(new BorderLayout());
        this.accountRepository = new AccountRepository();
        this.episodeRepository = new EpisodeRepository();
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
                    accountRepository.create(new Account(textName.getText(), textMail.getText(), textPasswd.getText(), textStreet.getText(),Integer.parseInt(textStrNumber.getText()),textZip.getText(), textCity.getText()));
                }
            });


            table.setBounds(75, 200, 700, 600);




        }
        if (tabName == "Profiel"){


            labelProfId = new JLabel("Profiel ID:");
            labelProfId.setBounds(12, 24, 100, 16);
            add(labelProfId);

            textProfId = new JTextField();
            textName.setColumns(20);
            textName.setBounds(111, 21, 300, 22);
            add(textName);

            labelProfName = new JLabel("Profielnaam:");
            labelProfName.setBounds(12, 64, 100, 16);
            add(labelProfName);

            textProfName = new JTextField();
            textProfName.setColumns(20);
            textProfName.setBounds(111, 64, 300, 22);
            add(textProfName);

            labelProfAccId = new JLabel("Abonnee ID:");
            labelProfAccId.setBounds(12, 107, 100, 16);
            add(labelProfAccId);

            textProfAccId =  new JTextField();
            textProfAccId.setColumns(20);
            textProfAccId.setBounds(111, 107, 300, 22);
            add(textProfAccId);

            labelProfAge = new JLabel("Leeftijd:");
            labelProfAge.setBounds(12, 150, 100, 16);
            add(labelProfAge);

            textProfAge = new JTextField();
            textProfAge.setColumns(20);
            textProfAge.setBounds(111, 150, 300, 22);
            add(textProfAge);

            BtnProf = new JButton("Opslaan");
            BtnProf.setBounds(322, 320, 116, 25);
            add(BtnProf);
        }

        if (tabName == "Movie"){
            labelFilmId = new JLabel("Movie ID:");
            labelFilmId.setBounds(12, 24, 100, 16);
            add(labelFilmId);

            textFilmId = new JTextField();
            textFilmId.setColumns(20);
            textFilmId.setBounds(111, 21, 300, 22);
            add(textFilmId);

            labelFilmTitle = new JLabel("Titel:");
            labelFilmTitle.setBounds(12, 64, 100, 16);
            add(labelFilmTitle);

            textFilmTitle = new JTextField();
            textFilmTitle.setColumns(20);
            textFilmTitle.setBounds(111, 64, 300, 22);
            add(textFilmTitle);

            labelFilmAge = new JLabel("Leeftijfsindicatie:");
            labelFilmAge.setBounds(12, 107, 100, 16);
            add(labelFilmAge);

            textFilmAge = new JTextField();
            textFilmAge.setColumns(20);
            textFilmAge.setBounds(111, 107, 300, 22);
            add(textFilmAge);

            labelFilmLanguage = new JLabel("Taal:");
            labelFilmLanguage.setBounds(12, 150, 100, 16);
            add(labelFilmLanguage);

            textFilmLanguage = new JTextField();
            textFilmLanguage.setColumns(20);
            textFilmLanguage.setBounds(111, 150, 300, 22);
            add(textFilmLanguage);

            labelFilmDuration = new JLabel("Tijdsduur:");
            labelFilmDuration.setBounds(12, 193, 100, 16);
            add(labelFilmDuration);

            textFilmDuration = new JTextField();
            textFilmDuration.setColumns(20);
            textFilmDuration.setBounds(111, 193, 300, 22);
            add(textFilmDuration);

            labelFilmGenre = new JLabel("Genre:");
            labelFilmGenre.setBounds(12, 236, 100, 16);
            add(labelFilmGenre);

            textFilmGenre = new JTextField();
            textFilmGenre.setColumns(20);
            textFilmGenre.setBounds(111, 236, 300, 22);
            add(textFilmGenre);

            BtnFilm = new JButton("Opslaan");
            BtnFilm.setBounds(322, 320, 116, 25);
            add(BtnFilm);
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
            labelProgId = new JLabel("Program ID:");
            labelProgId.setBounds(12, 24, 100, 16);
            add(labelProgId);

            textProgId = new JTextField();
            textProgId.setColumns(20);
            textProgId.setBounds(111, 21, 300, 22);
            add(textProgId);

            labelProgTitle = new JLabel("Titel:");
            labelProgTitle.setBounds(12, 64, 100, 16);
            add(labelProgTitle);

            textProgTitle = new JTextField();
            textProgTitle.setColumns(20);
            textProgTitle.setBounds(111, 64, 300, 22);
            add(textProgTitle);

            labelProgFilmId= new JLabel("Movie ID:");
            labelProgFilmId.setBounds(12, 107, 100, 16);
            add(labelProgFilmId);

            textProgFilmId = new JTextField();
            textProgFilmId.setColumns(20);
            textProgFilmId.setBounds(111, 107, 300, 22);
            add(textProgFilmId);

            labelProgSerieId = new JLabel("Serie ID:");
            labelProgSerieId.setBounds(12, 150, 300, 16);
            add(labelProgSerieId);

            textProgSerieId = new JTextField();
            textProgSerieId.setColumns(20);
            textProgSerieId.setBounds(111, 150, 300, 22);
            add(textProgSerieId);

            labelProgEpId = new JLabel("Episode ID:");
            labelProgEpId.setBounds(12, 193, 100, 16);
            add(labelProgEpId);

            textProgEpId = new JTextField();
            textProgEpId.setColumns(20);
            textProgEpId.setBounds(111, 193, 300, 22);
            add(textProgEpId);

            labelProgProfId = new JLabel("Profiel ID:");
            labelProgProfId.setBounds(12, 236, 100, 16);
            add(labelProgProfId);

            textProgProfId = new JTextField();
            textProgProfId.setColumns(20);
            textProgProfId.setBounds(111, 236, 300, 22);
            add(textProgProfId);

            BtnProg = new JButton("Opslaan");
            BtnProg.setBounds(322, 320, 116, 25);
            add(BtnProg);
        }
    }
}
