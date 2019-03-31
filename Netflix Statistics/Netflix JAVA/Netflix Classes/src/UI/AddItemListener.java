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
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;

    private JLabel labelNaam;
    private JLabel labelPasswd;

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

            labelNaam = new JLabel("Naam");
            labelNaam.setBounds(12, 24, 87, 16);
            add(labelNaam);

            textName = new JTextField();
            textName.setColumns(10);
            textName.setBounds(111, 21, 116, 22);
            add(textName);

            labelPasswd = new JLabel("Wachtwoord");
            labelPasswd.setBounds(12, 64, 77, 16);
            add(labelPasswd);

            textPasswd = new JTextField();
            textPasswd.setColumns(10);
            textPasswd.setBounds(111, 64, 116, 22);
            add(textPasswd);


            table.setBounds(75, 200, 700, 600);
            add(table);



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
