package UI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

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
    //////////////////////////////////

    //Film settings
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
    /////////////////////////////////////

    public AddItemListener(String tabName){
        super(new BorderLayout());
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
            labelNaam.setBounds(12, 24, 87, 16);
            add(labelNaam);

            textName = new JTextField();
            textName.setColumns(20);
            textName.setBounds(111, 21, 300, 22);
            add(textName);

            labelPasswd = new JLabel("Wachtwoord:");
            labelPasswd.setBounds(12, 64, 77, 16);
            add(labelPasswd);

            textPasswd = new JTextField();
            textPasswd.setColumns(20);
            textPasswd.setBounds(111, 64, 300, 22);
            add(textPasswd);

            labelMail = new JLabel("E-mail:");
            labelMail.setBounds(12, 107, 77, 16);
            add(labelMail);

            textMail = new JTextField();
            textMail.setColumns(20);
            textMail.setBounds(111, 107, 300, 22);
            add(textMail);

            labelStreet = new JLabel("Straat:");
            labelStreet.setBounds(12, 150, 77, 16);
            add(labelStreet);

            textStreet = new JTextField();
            textStreet.setColumns(20);
            textStreet.setBounds(111, 150, 300, 22);
            add(textStreet);

            labelStrNumber = new JLabel("Huisnummer:");
            labelStrNumber.setBounds(12, 193, 77, 16);
            add(labelStrNumber);

            textStrNumber = new JTextField();
            textStrNumber.setColumns(20);
            textStrNumber.setBounds(111, 193, 300, 22);
            add(textStrNumber);

            labelZip = new JLabel("Postcode:");
            labelZip.setBounds(12, 236, 77, 16);
            add(labelZip);

            textZip = new JTextField();
            textZip.setColumns(20);
            textZip.setBounds(111, 236, 300, 22);
            add(textZip);

            labelCity = new JLabel("Stad:");
            labelCity.setBounds(12, 279, 77, 16);
            add(labelCity);

            textCity = new JTextField();
            textCity.setColumns(20);
            textCity.setBounds(111, 279, 300, 22);
            add(textCity);


            table.setBounds(75, 200, 700, 600);




        }
        if (tabName == "Profiel"){


            labelProfId = new JLabel("Profiel ID:");
            labelProfId.setBounds(12, 24, 87, 16);
            add(labelProfId);

            textProfId = new JTextField();
            textName.setColumns(20);
            textName.setBounds(111, 21, 300, 22);
            add(textName);

            labelProfName = new JLabel("Profielnaam:");
            labelProfName.setBounds(12, 64, 77, 16);
            add(labelProfName);

            textProfName = new JTextField();
            textProfName.setColumns(20);
            textProfName.setBounds(111, 64, 300, 22);
            add(textProfName);

            labelProfAccId = new JLabel("Abonnee ID:");
            labelProfAccId.setBounds(12, 107, 77, 16);
            add(labelProfAccId);

            textProfAccId =  new JTextField();
            textProfAccId.setColumns(20);
            textProfAccId.setBounds(111, 107, 300, 22);
            add(textProfAccId);

            labelProfAge = new JLabel("Leeftijd:");
            labelProfAge.setBounds(12, 150, 77, 16);
            add(labelProfAge);

            textProfAge = new JTextField();
            textProfAge.setColumns(20);
            textProfAge.setBounds(111, 150, 300, 22);
            add(textProfAge);
        }

        if (tabName == "Film"){
            labelFilmId = new JLabel("Film ID:");
            labelFilmId.setBounds(12, 24, 87, 16);
            add(labelFilmId);

            textFilmId = new JTextField();
            textFilmId.setColumns(20);
            textFilmId.setBounds(111, 21, 300, 22);
            add(textFilmId);

            labelFilmTitle = new JLabel("Titel:");
            labelFilmTitle.setBounds(12, 64, 77, 16);
            add(labelFilmTitle);

            textFilmTitle = new JTextField();
            textFilmTitle.setColumns(20);
            textFilmTitle.setBounds(111, 64, 300, 22);
            add(textFilmTitle);

            labelFilmAge = new JLabel("Leeftijfsindicatie:");
            labelFilmAge.setBounds(12, 107, 77, 16);
            add(labelFilmAge);

            textFilmAge = new JTextField();
            textFilmAge.setColumns(20);
            textFilmAge.setBounds(111, 107, 300, 22);
            add(textFilmAge);

            labelFilmLanguage = new JLabel("Taal:");
            labelFilmLanguage.setBounds(12, 150, 77, 16);
            add(labelFilmLanguage);

            textFilmLanguage = new JTextField();
            textFilmLanguage.setColumns(20);
            textFilmLanguage.setBounds(111, 150, 300, 22);
            add(textFilmLanguage);

            labelFilmDuration = new JLabel("Tijdsduur:");
            labelFilmDuration.setBounds(12, 193, 77, 16);
            add(labelFilmDuration);

            textFilmDuration = new JTextField();
            textFilmDuration.setColumns(20);
            textFilmDuration.setBounds(111, 193, 300, 22);
            add(textFilmDuration);

            labelFilmGenre = new JLabel("Genre:");
            labelFilmGenre.setBounds(12, 236, 77, 16);
            add(labelFilmGenre);

            textFilmGenre = new JTextField();
            textFilmGenre.setColumns(20);
            textFilmGenre.setBounds(111, 236, 300, 22);
            add(textFilmGenre);
        }





    }
}
