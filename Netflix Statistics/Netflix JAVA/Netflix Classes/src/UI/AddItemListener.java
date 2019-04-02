package UI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddItemListener extends JPanel {

    private JTable table;
    private JTable Proftable;
    private JButton button;

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


            labelNaam = new JLabel("Naam2");
            labelNaam.setBounds(12, 74, 87, 16);
            add(labelNaam);

            textName = new JTextField();
            textName.setColumns(10);
            textName.setBounds(400, 71, 116, 22);
            add(textName);

            table.setBounds(75, 200, 700, 600);
            add(table);

            add(button);
        }






    }
}
