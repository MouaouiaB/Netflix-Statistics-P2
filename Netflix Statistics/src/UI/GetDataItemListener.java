package UI;

import Repositories.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class GetDataItemListener extends JPanel{
    private JTable table;

    private AccountRepository accountRepository = new AccountRepository();
    private EpisodeRepository episodeRepository =  new EpisodeRepository();
    private MovieRepository movieRepository = new MovieRepository();

    public GetDataItemListener(String name) throws SQLException {
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
    public void avgSelectedSerie(String Serie) throws SQLException {
        ResultSet rs = episodeRepository.AvgEpisode(Serie);
        table = new JTable(buildTableModel(rs));
        table.setBounds(12, 55, 475, 309);


        add(table);
    }

    public void avgEpisodeByAccount(String account, String Serie) throws SQLException {
        ResultSet rs = episodeRepository.AvgEpisodeAccount(account, Serie);
        table = new JTable(buildTableModel(rs));
        table.setBounds(12, 55, 475, 309);


        add(table);
    }

    public void watchedMovies(String title) throws SQLException {
        ResultSet rs = accountRepository.WatchedMovies(title);
        table = new JTable(buildTableModel(rs));
        table.setBounds(12, 55, 475, 309);


        add(table);
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

        return table;

    }

    public JTable getTable() {
        return table;
    }
}
