package UI;

import javax.swing.*;
import java.awt.*;

public class AddItemListener extends JPanel {

    private JTable table;
    private JButton button;

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;

    private JLabel labelNaam;

    public AddItemListener(String tabName){
        super(new BorderLayout());
        LoadComponents(tabName);
    }

    public void LoadComponents(String tabName){


        this.table = new JTable();
        this.button = new JButton();

        this.textField1 = new JTextField();
        if (tabName == "Account"){
            labelNaam = new JLabel("Naam");
            labelNaam.setBounds(273, 74, 56, 16);
            add(labelNaam);

            textField1 = new JTextField();
            textField1.setColumns(10);
            textField1.setBounds(322, 71, 116, 22);
            add(textField1);

            table.setRowHeight(2);
            add(table);

        }
        if (tabName == "Profiel"){

            button.setText("test");
            add(button);
        }



    }
}
