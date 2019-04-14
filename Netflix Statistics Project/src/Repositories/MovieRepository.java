package Repositories;

import java.sql.*;
import java.util.*;
import Connection.*;
import Domain.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class MovieRepository {
    private SqlHandler sqlHandler;
    private SqlConnection sqlConnection;


    public MovieRepository() {

    }

    public ResultSet readAll() {
        ResultSet resultSet = null;

        try {

            return sqlConnection.sqlHandler.executeSql("SELECT * FROM Movie");
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return resultSet;
    }

    public ArrayList getMovieTitles(){
        ArrayList<String>list = new ArrayList<>();
        try
        {
            String sqlQuery = "SELECT Title FROM Movie";
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
        int MovieId = 0;
        try
        {
            String sqlQuery = "SELECT MovieID FROM Movie WHERE Title = '" + name + "'";
            ResultSet rs = sqlConnection.sqlHandler.executeSql(sqlQuery);
            while(rs.next()) {
                MovieId = rs.getInt("MovieID");
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return MovieId;
    }

    //method not used, but can be used un future projects
    public boolean create(Movie movie) {
        try
        {
            String sqlQuery = "INSERT INTO Movie VALUES('" +
                    movie.getMovieTitle()+ "', "+
                    movie.getAgeIndication()+ ",' "+
                    movie.getLanguage() + "', "+
                    movie.getLength() + ",' "+
                    movie.getGenre()+
                    "')";
            showMessageDialog(null, "Film succesvol toegevoegd");
            return sqlConnection.sqlHandler.executeSqlNoResult(sqlQuery);

        }
        catch(Exception e) {
            showMessageDialog(null, "Formulier foutief ingevuld");
            System.out.println(e);
        }

        return false;
    }

    //method not used, but can be used un future projects
    public boolean delete(int id) {
        try
        {
            String sqlQuery = "DELETE FROM Movie WHERE MovieID = "+ id;
            showMessageDialog(null, "Film succesvol verwijderd");
            return sqlConnection.sqlHandler.executeSqlNoResult(sqlQuery);

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

            return sqlConnection.sqlHandler.executeSql(query);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return resultSet;
    }

}
