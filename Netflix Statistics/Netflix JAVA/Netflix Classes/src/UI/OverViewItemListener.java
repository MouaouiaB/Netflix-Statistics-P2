package UI;

import Connection.SqlConnection;
import Connection.SqlHandler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;


public class OverViewItemListener extends JPanel {


    private SqlConnection sqlConnection = new SqlConnection();
    private JTable table;
    private String name;



    public OverViewItemListener(String tabName) throws SQLException {
        super(new BorderLayout());
        LoadComponents(tabName);
    }

    public void LoadComponents(String tabName) throws SQLException {
        if (tabName == "Account"){
            ResultSet rs = sqlConnection.sqlHandler.executeSql("SELECT * FROM Account");
            table = new JTable(buildTableModel(rs));



            // Closes the Connection
            //JOptionPane.showMessageDialog(null, new JScrollPane(table));
            add(table);

        }

    }

    public  static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        DefaultTableModel table = new DefaultTableModel(data, columnNames);
        table.fireTableDataChanged();
        return table;

    }


}
