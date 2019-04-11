package Repositories;

import java.sql.*;
import java.util.*;
import Connection.*;
import Domain.*;

public class MovieRepository {
    private SqlHandler sqlHandler;
    private SqlConnection DBConnection;
    private String sqlConnection;

    public MovieRepository() {
        this.sqlConnection = sqlConnection;
    }

    public ResultSet readAll() {
        ResultSet resultSet = null;

        ArrayList<Account> lijst = new ArrayList<>();
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

    public void create(Movie movie) {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            // sqlConnection.executeSqlNoResult(sqlQuery);
            connection = DriverManager.getConnection(sqlConnection);
            statement = connection.createStatement();
            String sqlQuery = "INSERT INTO FILM VALUES(" +
                    movie.getMovieID()+ ", "+
                    movie.getMovieTitle()+ ", "+
                    movie.getLength()+ ", "+
                    movie.getGenre() + ", "+
                    movie.getLanguage()+ ", "+
                    movie.getAgeIndication()+ ", "+
                    movie.getProgramID()+
                    ")";
            resultSet = statement.executeQuery(sqlQuery);
            resultSet.next();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public void delete(Movie movie) {
        if(movie == null) return;
        delete(movie.getMovieID());
    }

    public void delete(int filmID) {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            connection = DriverManager.getConnection(sqlConnection);
            statement = connection.createStatement();
            String sqlQuery = "DELETE FILM WHERE FilmID= " + filmID;
            resultSet = statement.executeQuery(sqlQuery);
            resultSet.next();
        }
        catch(Exception e) {
            System.out.println(e);
            //ted

        }
    }

}
