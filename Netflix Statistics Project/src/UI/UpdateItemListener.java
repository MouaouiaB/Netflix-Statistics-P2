package UI;

import Domain.*;
import Repositories.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UpdateItemListener extends JPanel {

    private JTable table;
    private JTable Proftable;
    private JButton button;
    private JLabel label;
    private JComboBox comboBox;
    private JComboBox profCombox;
    private JComboBox progCombox;
    //Account settings
    private JPanel panel;
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

    public UpdateItemListener(String tabName){
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




        if (tabName == "Account"){

            labelAccountName = new JLabel("Account:");
            labelAccountName.setBounds(500, 13, 200, 22);
            add(labelAccountName);

            comboBox = new JComboBox();
            comboBox.setBounds(600, 13, 200, 22);
            add(comboBox);
            AccountComboBox();

            label = new JLabel("* Vul alle velden in");
            label.setBounds(600, 64, 300, 16);
            add(label);

            labelFullName = new JLabel("Naam:");
            labelFullName.setBounds(12, 64, 100, 16);
            add(labelFullName);

            textFullName = new JTextField();
            textFullName.setColumns(20);
            textFullName.setBounds(201, 64, 300, 22);
            add(textFullName);

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

            BtnAcc = new JButton("Wijzig");
            BtnAcc.setBounds(322, 350, 116, 25);
            add(BtnAcc);

            BtnAcc.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    accountRepository.update(new Account(comboBox.getSelectedItem().toString(),textFullName.getText(), textMail.getText(), textPasswd.getText(), textStreet.getText(), textStrNumber.getText(), textZip.getText(), textCity.getText()));
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
        if (tabName == "Profiel"){

            labelProfName = new JLabel("Profiel:");
            labelProfName.setBounds(500, 13, 200, 22);
            add(labelProfName);

            profCombox = new JComboBox();
            profCombox.setBounds(600, 13, 200, 22);
            add(profCombox);
            ProfileComboBox();

            label = new JLabel("* Vul alle velden in");
            label.setBounds(600, 64, 300, 16);
            add(label);

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



            BtnProf = new JButton("Wijzig");
            BtnProf.setBounds(322, 320, 116, 25);
            add(BtnProf);

            BtnProf.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    profileRepository.update(new Profile(profCombox.getSelectedItem().toString() , textProfAcc.getText() ,Integer.parseInt(textProfAge.getText())));
                    textProfAcc.setText("");
                    textProfAge.setText("");
                }
            });
        }

        if (tabName == "Program"){
            label = new JLabel("U kunt de aflevering veld leeg laten als u een film kiest.");
            label.setBounds(12, 24, 700, 16);
            add(label);

            labelAccountName = new JLabel("Profiel:");
            labelAccountName.setBounds(500, 13, 200, 22);
            add(labelAccountName);

            progCombox = new JComboBox();
            progCombox.setBounds(600, 13, 200, 22);
            add(progCombox);
            ProgramComboBox();

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

            BtnProg = new JButton("Wijzig");
            BtnProg.setBounds(322, 320, 116, 25);
            add(BtnProg);


            BtnProg.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (textProgEp.getText().isEmpty()){
                        programRepository.updateMovie(new Program(progCombox.getSelectedItem().toString(), textProgFiSer.getText(), Integer.parseInt(textProgPer.getText())));
                    }
                    else {
                        programRepository.updateSerie(new Program(progCombox.getSelectedItem().toString(), textProgFiSer.getText(), textProgEp.getText(), Integer.parseInt(textProgPer.getText())));

                    }
                    textProgProf.setText("");
                    textProgFiSer.setText("");
                    textProgEp.setText("");
                    textProgPer.setText("");
                }
            });

        }

    }

    public void AccountComboBox() {

        ArrayList<Account> accounts = accountRepository.AccountsArrayList();
        ArrayList<String> accountsnames = new ArrayList<>();
        for (Account a : accounts) {
            accountsnames.add(a.getAccountName());


        }
        comboBox.setModel(new DefaultComboBoxModel(accountsnames.toArray()));

    }
    public void ProfileComboBox(){
        ArrayList<Profile>profiles = profileRepository.ProfileArrayList();
        ArrayList<String>profilenames = new ArrayList<>();
        for (Profile p : profiles){
            profilenames.add(p.getProfileName());
        }
        profCombox.setModel(new DefaultComboBoxModel(profilenames.toArray()));
    }

    public void ProgramComboBox(){
        ArrayList<Profile>profiles = profileRepository.ProfileArrayList();
        ArrayList<String>profilenames = new ArrayList<>();
        for (Profile p : profiles){
            profilenames.add(p.getProfileName());
        }
        progCombox.setModel(new DefaultComboBoxModel(profilenames.toArray()));
    }
}

