package UI;

import Repositories.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class StatisticsItemListener extends JPanel{
    private JTable table;
    private AccountRepository accountRepository = new AccountRepository();
    private MovieRepository movieRepository = new MovieRepository();

    public StatisticsItemListener(String name) throws SQLException {

        LoadComponents(name);
    }

    public void LoadComponents(String tabName) throws SQLException {
        if (tabName == "Accounts"){
            ResultSet rs = accountRepository.AccountOneProfile();
            table = new JTable(buildTableModel(rs));


            add(table);
        }



        if (tabName == "Langste"){
            ResultSet rs = movieRepository.MovieLongestUnderSixteen();
            table = new JTable(buildTableModel(rs));


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

    public JTable getTable() {
        return table;
    }
}
