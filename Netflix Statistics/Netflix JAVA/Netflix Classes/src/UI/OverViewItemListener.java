package UI;

import javax.swing.*;
import java.awt.*;

public class OverViewItemListener extends JPanel {

    public OverViewItemListener(String tabName){
        super(new BorderLayout());
        LoadComponents(tabName);
    }

    public void LoadComponents(String tabName){
        if (tabName == "Account"){
            JTable table = new JTable();

            // Customize the table
            table.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 14)); // Font of the header
            table.setFont(new Font("Verdana", Font.PLAIN, 12)); // Font of the actual data
            table.getTableHeader().setReorderingAllowed(false); // Disable dragging of the columns
            table.setEnabled(false); // D
            add(table);
        }

    }
}
