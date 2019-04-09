package Repositories;

import java.sql.*;
import java.util.*;

import Domain.Episode;

public class EpisodeRepository {
    private String sqlConnection;

    public EpisodeRepository(String sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public ArrayList<Episode> readAll() {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        ArrayList<Episode> lijst = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(sqlConnection);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM AFLEVERING");
            while(resultSet.next()) {
                //lijst.add(new Repositories.EpisodeRepository(rs.getInt("AfleveringID"),rs.getString("Domain.Serie"), rs.getString("ProgrammaID"), rs.getString("Title"), rs.getString("Seizoen en aflevering"), rs.getString("Tijdsduur")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return lijst;
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
                    episode.getMovieTitle()+ ", "+
                    episode.getProgramID() + ", "+
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

}
