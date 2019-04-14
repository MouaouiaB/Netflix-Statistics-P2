package Repositories;

import java.sql.*;
import java.util.*;
import Connection.*;

import Domain.Serie;

import static javax.swing.JOptionPane.showMessageDialog;

public class SerieRepository {
    private SqlConnection sqlConnection;
    private SqlHandler sqlHandler;

    public SerieRepository() {

    }

    public ResultSet readAll() {
        ResultSet resultSet = null;
        try {
            return sqlConnection.sqlHandler.executeSql("SELECT * FROM Series");
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return resultSet;
    }

    public ArrayList getTitles(){
        ArrayList<String>list = new ArrayList<>();
        try
        {
            String sqlQuery = "SELECT Title FROM Series";
            ResultSet rs = sqlConnection.sqlHandler.executeSql(sqlQuery);
            while(rs.next()) {
                list.add(rs.getString("Title"));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return list;
    }


    public int readIdWithName (String name){
        int SerieId = 0;
        try
        {
            String sqlQuery = "SELECT SerieID FROM Series WHERE Title = '" + name + "'";
            ResultSet rs = sqlConnection.sqlHandler.executeSql(sqlQuery);
            while(rs.next()) {
                SerieId = rs.getInt("SerieID");
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return SerieId;
    }

    public boolean create(Serie serie) {
        try
        {
            String sqlQuery = "INSERT INTO Series VALUES('" +
                    serie.getSerieTitle()+ "', "+
                    serie.getSeasons()+ ", "+
                    serie.getAgeIndication() + ", '"+
                    serie.getLanguage() + "',' "+
                    serie.getGenre()+"',' "+
                    serie.getLooksLike()+
                    "')";
            showMessageDialog(null, "Serie succesvol toegevoegd");
            return sqlConnection.sqlHandler.executeSqlNoResult(sqlQuery);

        }
        catch(Exception e) {
            showMessageDialog(null, "Formulier foutief ingevuld");
            System.out.println(e);
        }

        return false;
    }


    public boolean delete(int id) {
        try
        {
            String sqlQuery = "DELETE FROM Series WHERE SerieID = "+ id;
            showMessageDialog(null, "Serie succesvol verwijderd");
            return sqlConnection.sqlHandler.executeSqlNoResult(sqlQuery);

        }
        catch(Exception e) {
            showMessageDialog(null, "Formulier foutief ingevuld");
            System.out.println(e);
        }

        return false;
    }

}
