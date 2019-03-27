package Repositories;

import Domain.Film;

import java.sql.*;
import java.util.*;

public class FilmRepository {
    private String sqlConnection;

    public FilmRepository(String sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public ArrayList<Film> readAll() {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        ArrayList<Film> lijst = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(sqlConnection);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM FILM");
            while(resultSet.next()) {
                //lijst.add(new Domain.Film(rs.getInt("FilmID"),rs.getString("Title"), rs.getString("Tijdsduur"), rs.getString("Genre"), rs.getString("Taal"), rs.getString("Leeftijds Indicatie"), rs.getString("ProgrammaID")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return lijst;
    }

    public Film read(int filmID) {
        Film film = null;

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
            //lijst.add(new Domain.Film(rs.getInt("FilmID"),rs.getString("Title"), rs.getString("Tijdsduur"), rs.getString("Genre"), rs.getString("Taal"), rs.getString("Leeftijds Indicatie"), rs.getString("ProgrammaID")));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return film;
    }

    public void create(Film film) {
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
                    film.getFilmID()+ ", "+
                    film.getTitle()+ ", "+
                    film.getTijdsduur()+ ", "+
                    film.getGenre() + ", "+
                    film.getTaal()+ ", "+
                    film.getLeeftijdsIndicatie()+ ", "+
                    film.getProgrammaID()+
                    ")";
            resultSet = statement.executeQuery(sqlQuery);
            resultSet.next();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public void delete(Film film) {
        if(film == null) return;
        delete(film.getFilmID());
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
