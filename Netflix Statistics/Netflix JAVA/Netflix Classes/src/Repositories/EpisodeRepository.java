package Repositories;

import java.sql.*;
import java.util.*;
import Connection.*;
import Domain.*;

import Domain.Episode;

public class EpisodeRepository {
    private SqlHandler sqlHandler;
    private SqlConnection DBConnection;
    private String sqlConnection;

    public EpisodeRepository() {
        this.sqlHandler = new SqlHandler();
    }

    public ResultSet readAll() {
        ResultSet resultSet = null;

        ArrayList<Account> lijst = new ArrayList<>();
        try {

            return DBConnection.sqlHandler.executeSql("SELECT * FROM Episode");
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return resultSet;
    }

    public Episode read(int AfleveringID) {
        Episode episode = null;

        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;


        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            connection = DriverManager.getConnection(sqlConnection);
            statement = connection.createStatement();
            String sqlQuery = "SELECT * FROM AFLEVERING WHERE AfleveringID =" + AfleveringID;
            resultSet = statement.executeQuery(sqlQuery);
            resultSet.next();


        }
        catch(Exception e) {
            System.out.println(e);
        }
        return episode;
    }

    public void create(Episode episode) {
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
            String sqlQuery = "INSERT INTO AFLEVERING VALUES(" +
                    episode.getEpisodeID()+ ", "+
                    episode.getSerieName()+ ", "+
                    episode.getSerieName()+ ", "+

                    episode.getSeasonAndEpisode()+ ", "+
                    episode.getLengthe()+
                    ")";
            resultSet = statement.executeQuery(sqlQuery);
            resultSet.next();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public void delete(Episode episode) {
        if(episode == null) return;
        delete(episode.getEpisodeID());
    }

    public void delete(int AfleveringID) {

        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            connection = DriverManager.getConnection(sqlConnection);
            statement = connection.createStatement();
            String sqlQuery = "DELETE AFLEVERING WHERE AfleveringID =" + AfleveringID;
            resultSet = statement.executeQuery(sqlQuery);
            resultSet.next();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public ResultSet AvgEpisode(){
        ResultSet resultSet = null;

        try {
            String query = "SELECT Episode.Serie,Episode.Title, AVG(Precentage) as 'Bekeken %'\n" +
                    "FROM Episode\n" +
                    "INNER JOIN Series ON Episode.SerieID = Series.SerieID\n" +
                    "INNER JOIN Program ON Episode.EpisodeID = Program.EpisodeID\n" +
                    "INNER JOIN Profile ON Program.ProfileID = Profile.ProfileID\n" +
                    "INNER JOIN Account ON Profile.AccountID = Account.AccountID\n" +
                    "GROUP BY Episode.Title, Episode.Serie";

            return DBConnection.sqlHandler.executeSql(query);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return resultSet;
    }

}

