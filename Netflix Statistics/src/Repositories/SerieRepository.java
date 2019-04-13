package Repositories;

import java.sql.*;
import java.util.*;
import Connection.*;
import Domain.*;

import Domain.Serie;

import static javax.swing.JOptionPane.showMessageDialog;

public class SerieRepository {
    private String sqlConnection;
    private SqlConnection dbConnection;
    private SqlHandler sqlHandler;

    public SerieRepository() {
        this.sqlConnection = sqlConnection;
    }

    public ResultSet readAll() {
        ResultSet resultSet = null;
        try {
            return dbConnection.sqlHandler.executeSql("SELECT * FROM Series");
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return resultSet;
    }

    public Serie read(int ProgrammaID) {
         Serie serie = null;
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            connection = DriverManager.getConnection(sqlConnection);
            statement = connection.createStatement();
            String sqlQuery = "SELECT * FROM Domain.Serie WHERE ProgrammaID= " + ProgrammaID;
            resultSet = statement.executeQuery(sqlQuery);
            resultSet.next();
            //lijst.add(new Domain.Movie(rs.getInt("FilmID"),rs.getString("Title"), rs.getString("Tijdsduur"), rs.getString("Genre"), rs.getString("Taal"), rs.getString("Leeftijds Indicatie"), rs.getString("ProgrammaID")));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return serie;
    }

    public int readIdWithName (String name){
        int SerieId = 0;
        try
        {
            String sqlQuery = "SELECT SerieID FROM Series WHERE Title = '" + name + "'";
            ResultSet rs = dbConnection.sqlHandler.executeSql(sqlQuery);
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
            return dbConnection.sqlHandler.executeSqlNoResult(sqlQuery);

        }
        catch(Exception e) {
            showMessageDialog(null, "Formulier foutief ingevuld");
            System.out.println(e);
        }

        return false;
    }

    public void delete(Serie serie) {
        if(serie == null) return;
        delete(serie.getSerieId());
    }

    public boolean delete(int id) {
        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            //String sqlQuery = "INSERT INTO ABONNEMENT VALUES (" + student.getId() + ", '" + student.getName() + "', '" + student.getStudentNumber() + "')";
            // sqlConnection.executeSqlNoResult(sqlQuery);

            //statement = connection.createStatement();
            String sqlQuery = "DELETE FROM Series WHERE SerieID = "+ id;
            showMessageDialog(null, "Serie succesvol verwijderd");
            return dbConnection.sqlHandler.executeSqlNoResult(sqlQuery);

        }
        catch(Exception e) {
            showMessageDialog(null, "Formulier foutief ingevuld");
            System.out.println(e);
        }

        return false;
    }

}
