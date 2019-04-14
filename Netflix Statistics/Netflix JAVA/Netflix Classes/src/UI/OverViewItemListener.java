package UI;

import Connection.SqlConnection;
import Repositories.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.Vector;



public class OverViewItemListener extends JPanel {


    private SqlConnection sqlConnection = new SqlConnection();
    private JTable table;
    private JScrollPane scrollPane;

    private AccountRepository accountRepository = new AccountRepository();
    private ProfileRepository profileRepository = new ProfileRepository();
    private EpisodeRepository episodeRepository =  new EpisodeRepository();
    private SerieRepository serieRepository = new SerieRepository();
    private ProgramRepository programRepository = new ProgramRepository();
    private MovieRepository movieRepository = new MovieRepository();


    public OverViewItemListener(String name) throws SQLException {
        super(new BorderLayout());

        LoadComponents(name);
    }

    public void LoadComponents(String tabName) throws SQLException {
        if (tabName == "Account"){
            ResultSet rs = accountRepository.readAllToTable();
            table = new JTable(buildTableModel(rs));
            scrollPane = new JScrollPane(table);


            add(scrollPane);
            add(table);


        }
        if (tabName == "Profile"){
            ResultSet rs = profileRepository.readAll();
            table = new JTable(buildTableModel(rs));
            scrollPane = new JScrollPane(table);

            add(scrollPane);
            add(table);
        }

        if (tabName == "Film"){
            ResultSet rs = movieRepository.readAll();
            table = new JTable(buildTableModel(rs));
            scrollPane = new JScrollPane(table);

            add(scrollPane);
            add(table);
        }

        if (tabName == "Serie"){
            ResultSet rs = serieRepository.readAll();
            table = new JTable(buildTableModel(rs));
            scrollPane = new JScrollPane(table);

            add(scrollPane);
            add(table);
        }

        if (tabName == "Aflevering"){
            ResultSet rs = episodeRepository.readAll();
            table = new JTable(buildTableModel(rs));
            scrollPane = new JScrollPane(table);

            add(scrollPane);
            add(table);
        }

        if (tabName == "Program"){
            ResultSet rs = programRepository.readAll();
            table = new JTable(buildTableModel(rs));
            scrollPane = new JScrollPane(table);

            add(scrollPane);
            add(table);
        }



    }

    //creates columns and data for the table
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
