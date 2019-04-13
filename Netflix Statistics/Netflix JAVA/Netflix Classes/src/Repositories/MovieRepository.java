package Repositories;

import java.sql.*;
import java.util.*;
import Connection.*;
import Domain.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class MovieRepository {
    private SqlHandler sqlHandler;
    private SqlConnection DBConnection;
    private String sqlConnection;

    public MovieRepository() {
        this.sqlConnection = sqlConnection;
    }

    public ResultSet readAll() {
        ResultSet resultSet = null;

        try {

            return DBConnection.sqlHandler.executeSql("SELECT * FROM Movie");
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return resultSet;
    }

    public Movie read(int filmID) {
        Movie movie = null;

        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            connection = DriverManager.getConnection(sqlConnection);
            statement = connection.createStatement();
            String sqlQuery = "SELECT * FROM FILM WHERE FilmID= " + filmID;
            resultSet = statement.executeQuery(sqlQuery);
            resultSet.next();
            //lijst.add(new Domain.Movie(rs.getInt("FilmID"),rs.getString("Title"), rs.getString("Tijdsduur"), rs.getString("Genre"), rs.getString("Taal"), rs.getString("Leeftijds Indicatie"), rs.getString("ProgrammaID")));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return movie;
    }

    public int readIdWithName (String name){
        int MovieId = 0;
        try
        {
            String sqlQuery = "SELECT MovieID FROM Movie WHERE Title = '" + name + "'";
            ResultSet rs = DBConnection.sqlHandler.executeSql(sqlQuery);
            while(rs.next()) {
                MovieId = rs.getInt("MovieID");
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return MovieId;
    }

    public boolean create(Movie movie) {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            //String sqlQuery = "INSERT INTO ABONNEMENT VALUES (" + student.getId() + ", '" + student.getName() + "', '" + student.getStudentNumber() + "')";
            // sqlConnection.executeSqlNoResult(sqlQuery);

            //statement = connection.createStatement();
            String sqlQuery = "INSERT INTO Movie VALUES('" +
                    movie.getMovieTitle()+ "', "+
                    movie.getAgeIndication()+ ",' "+
                    movie.getLanguage() + "', "+
                    movie.getLength() + ",' "+
                    movie.getGenre()+
                    "')";
            showMessageDialog(null, "Film succesvol toegevoegd");
            return DBConnection.sqlHandler.executeSqlNoResult(sqlQuery);

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
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            //String sqlQuery = "INSERT INTO ABONNEMENT VALUES (" + student.getId() + ", '" + student.getName() + "', '" + student.getStudentNumber() + "')";
            // sqlConnection.executeSqlNoResult(sqlQuery);

            //statement = connection.createStatement();
            String sqlQuery = "DELETE FROM Movie WHERE MovieID = "+ id;
            showMessageDialog(null, "Film succesvol verwijderd");
            return DBConnection.sqlHandler.executeSqlNoResult(sqlQuery);

        }
        catch(Exception e) {
            showMessageDialog(null, "Formulier foutief ingevuld");
            System.out.println(e);
        }

        return false;
    }

    public ResultSet MovieLongestUnderSixteen(){
        ResultSet resultSet = null;

        try {
            String query = "SELECT TOP 1 Title, Length, AgeIndication\n" +
                    "FROM Movie\n" +
                    "WHERE Movie.AgeIndication < 16 \n" +
                    "Order by Length Desc";

            return DBConnection.sqlHandler.executeSql(query);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return resultSet;
    }

}
