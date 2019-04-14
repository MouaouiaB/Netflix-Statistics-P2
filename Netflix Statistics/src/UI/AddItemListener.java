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
    private JLabel label;
    //Account settings
    private JTextField textAccountName;
    private JTextField textFullName;
    private JTextField textPasswd;
    private JTextField textMail;
    private JTextField textStreet;
    private JTextField textStrNumber;
    private JTextField textZip;
    private JTextField textCity;

    private JLabel labelAccountName;
    private JLabel labelFullName;
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
    private JTextField textProfAge;

    private JLabel labelProfAcc;
    private JLabel labelProfName;
    private JLabel labelProfAge;
    private JButton BtnProf;
    //////////////////////////////////
    ///////////////////////////////////////////
    //Program settings
    private JLabel labelProgProf;
    private JLabel labelProgFiSer;
    private JLabel labelProgEp;
    private JLabel labelProgPer;
    private JLabel labelProgProfId;

    private JTextField textProgProf;
    private JTextField textProgFiSer;
    private JTextField textProgEp;
    private JTextField textProgPer;
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



        this.textAccountName = new JTextField();
        //Loads account form
        if (tabName == "Account"){

            label = new JLabel("* Vul alle velden in");
            label.setBounds(600, 24, 300, 16);
            add(label);

            labelFullName = new JLabel("Naam:");
            labelFullName.setBounds(12, 24, 100, 16);
            add(labelFullName);

            textFullName = new JTextField();
            textFullName.setColumns(20);
            textFullName.setBounds(201, 21, 300, 22);
            add(textFullName);

            labelAccountName = new JLabel("Account naam:");
            labelAccountName.setBounds(12, 64, 100, 16);
            add(labelAccountName);

            textAccountName = new JTextField();
            textAccountName.setColumns(20);
            textAccountName.setBounds(201, 64, 300, 22);
            add(textAccountName);

            labelPasswd = new JLabel("Wachtwoord:");
            labelPasswd.setBounds(12, 107, 100, 16);
            add(labelPasswd);

            textPasswd = new JTextField();
            textPasswd.setColumns(20);
            textPasswd.setBounds(201, 107, 300, 22);
            add(textPasswd);

            labelMail = new JLabel("E-mail:");
            labelMail.setBounds(12, 150, 100, 16);
            add(labelMail);

            textMail = new JTextField();
            textMail.setColumns(20);
            textMail.setBounds(201, 150, 300, 22);
            add(textMail);

            labelStreet = new JLabel("Straat:");
            labelStreet.setBounds(12, 193, 100, 16);
            add(labelStreet);

            textStreet = new JTextField();
            textStreet.setColumns(20);
            textStreet.setBounds(201, 193, 300, 22);
            add(textStreet);

            labelStrNumber = new JLabel("Huisnummer:");
            labelStrNumber.setBounds(12, 236, 100, 16);
            add(labelStrNumber);

            textStrNumber = new JTextField();
            textStrNumber.setColumns(20);
            textStrNumber.setBounds(201, 236, 300, 22);
            add(textStrNumber);

            labelZip = new JLabel("Postcode:");
            labelZip.setBounds(12, 279, 100, 16);
            add(labelZip);

            textZip = new JTextField();
            textZip.setColumns(20);
            textZip.setBounds(201, 279, 300, 22);
            add(textZip);

            labelCity = new JLabel("Stad:");
            labelCity.setBounds(12, 322, 100, 16);
            add(labelCity);

            textCity = new JTextField();
            textCity.setColumns(20);
            textCity.setBounds(201, 322, 300, 22);
            add(textCity);

            BtnAcc = new JButton("Opslaan");
            BtnAcc.setBounds(322, 370, 116, 25);
            add(BtnAcc);

            //Adds info given to repositories
            BtnAcc.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    accountRepository.create(new Account(textAccountName.getText(), textFullName.getText(), textMail.getText(), textPasswd.getText(), textStreet.getText(),textStrNumber.getText(),textZip.getText(), textCity.getText()));
                    textAccountName.setText("");
                    textFullName.setText("");
                    textMail.setText("");
                    textPasswd.setText("");
                    textStreet.setText("");
                    textStrNumber.setText("");
                    textZip.setText("");
                    textCity.setText("");
                }
            });
        }

        //Loads profile form
        if (tabName == "Profiel"){
            label = new JLabel("* Vul alle velden in");
            label.setBounds(600, 24, 300, 16);
            add(label);

            labelProfName = new JLabel("Profielnaam:");
            labelProfName.setBounds(12, 24, 100, 16);
            add(labelProfName);

            textProfName = new JTextField();
            textProfName.setColumns(20);
            textProfName.setBounds(201, 21, 300, 22);
            add(textProfName);


            labelProfAge = new JLabel("Leeftijd (alleen getallen):");
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

            //Adds info given to repositories
            BtnProf.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    profileRepository.create(new Profile(textProfName.getText(),textProfAcc.getText(), Integer.parseInt(textProfAge.getText())));
                    textProfName.setText("");
                    textProfAcc.setText("");
                    textProfAge.setText("");
                }
            });
        }


        // loads program repository
        if (tabName == "Programma"){

            label = new JLabel("U kunt de aflevering veld leeg laten als u een film kiest.");
            label.setBounds(12, 24, 700, 16);
            add(label);

            labelProgProf = new JLabel("Profiel naam:");
            labelProgProf.setBounds(12, 64, 100, 16);
            add(labelProgProf);

            textProgProf = new JTextField();
            textProgProf.setColumns(20);
            textProgProf.setBounds(201, 64, 300, 22);
            add(textProgProf);

            labelProgFiSer = new JLabel("Film/Serie");
            labelProgFiSer.setBounds(12, 107, 100, 16);
            add(labelProgFiSer);

            textProgFiSer = new JTextField();
            textProgFiSer.setColumns(20);
            textProgFiSer.setBounds(201, 107, 300, 22);
            add(textProgFiSer);

            labelProgEp = new JLabel("Aflevering:");
            labelProgEp.setBounds(12, 150, 300, 16);
            add(labelProgEp);

            textProgEp = new JTextField();
            textProgEp.setColumns(20);
            textProgEp.setBounds(201, 150, 300, 22);
            add(textProgEp);

            labelProgPer = new JLabel("Percentage (alleen getallen):");
            labelProgPer.setBounds(12, 193, 300, 16);
            add(labelProgPer);

            textProgPer = new JTextField();
            textProgPer.setColumns(20);
            textProgPer.setBounds(201, 193, 300, 22);
            add(textProgPer);

            BtnProg = new JButton("Opslaan");
            BtnProg.setBounds(322, 320, 116, 25);
            add(BtnProg);

            //sends info from body to repository
            BtnProg.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (textProgEp.getText().isEmpty()){
                        programRepository.createMovie(new Program(textProgProf.getText(), textProgFiSer.getText(), Integer.parseInt(textProgPer.getText())));
                    }
                    else {
                        programRepository.createSerie(new Program(textProgProf.getText(), textProgFiSer.getText(), textProgEp.getText(), Integer.parseInt(textProgPer.getText())));

                    }
                    textProgProf.setText("");
                    textProgFiSer.setText("");
                    textProgEp.setText("");
                    textProgPer.setText("");
                }
            });

        }
    }
}

