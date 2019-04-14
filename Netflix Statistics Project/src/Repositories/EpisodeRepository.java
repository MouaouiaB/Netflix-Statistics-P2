package Repositories;

import java.sql.*;

import Connection.*;

import Domain.Episode;

import static javax.swing.JOptionPane.showMessageDialog;

public class EpisodeRepository {
    private SqlHandler sqlHandler;
    private SqlConnection sqlConnection;

    private SerieRepository serieRepository = new SerieRepository();

    public EpisodeRepository() {
        this.sqlHandler = new SqlHandler();
    }

    public ResultSet readAll() {
        ResultSet resultSet = null;


        try {

            return sqlConnection.sqlHandler.executeSql("SELECT * FROM Episode");
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return resultSet;
    }


    public int readIdWithName (String name){
        int MovieId = 0;
        try
        {
            String sqlQuery = "SELECT EpisodeID FROM Episode WHERE Title = '" + name + "'";
            ResultSet rs = sqlConnection.sqlHandler.executeSql(sqlQuery);
            while(rs.next()) {
                MovieId = rs.getInt("EpisodeID");
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return MovieId;
    }

    //method not used, but can be used un future projects
    public boolean create(Episode episode) {
        int serieId = serieRepository.readIdWithName(episode.getSerieName());

        try
        {
            String sqlQuery = "INSERT INTO Episode VALUES('" +
                    episode.getSerieName()+ "', "+
                    serieId + ", '"+
                    episode.getSeasonAndEpisode()+ "', '"+
                    episode.getTitle() + "', "+
                    episode.getLengthe() +
                    ")";
            showMessageDialog(null, "Episode succesvol toegevoegd");
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
            String sqlQuery = "DELETE FROM Episode WHERE EpisodeID = "+ id;
            showMessageDialog(null, "Aflevering succesvol verwijderd");
            return sqlConnection.sqlHandler.executeSqlNoResult(sqlQuery);

        }
        catch(Exception e) {
            showMessageDialog(null, "Formulier foutief ingevuld");
            System.out.println(e);
        }

        return false;
    }

    public ResultSet AvgEpisodeAccount(String Account, String Serie){
        ResultSet resultSet = null;

        try {
            String query = "SELECT Episode.Serie,Episode.Title, AVG(Precentage) as 'Bekeken %'\n" +
                    "FROM Episode\n" +
                    "INNER JOIN Series ON Episode.SerieID = Series.SerieID\n" +
                    "INNER JOIN Program ON Episode.EpisodeID = Program.EpisodeID\n" +
                    "INNER JOIN Profile ON Program.ProfileID = Profile.ProfileID\n" +
                    "INNER JOIN Account ON Profile.AccountID = Account.AccountID\n" +
                    " Where Series.Title = '" + Serie + "' AND Account.AccountName = '" + Account+ "'" +
                    "GROUP BY Episode.Title, Episode.Serie";

            return sqlConnection.sqlHandler.executeSql(query);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return resultSet;
    }

    public ResultSet AvgEpisode(String Serie){
        ResultSet resultSet = null;

        try {
            String query = "SELECT Episode.EpisodeID, Episode.Title, AVG(Precentage) as 'Bekeken %'\n" +
                    "FROM Episode\n" +
                    "INNER JOIN Series ON Episode.SerieID = Series.SerieID\n" +
                    "INNER JOIN Program ON Episode.EpisodeID = Program.EpisodeID\n" +
                    "INNER JOIN Profile ON Program.ProfileID = Profile.ProfileID\n" +
                    "INNER JOIN Account ON Profile.AccountID = Account.AccountID\n" +
                    " Where Series.Title = '" + Serie + "' " +
                    "GROUP BY Episode.EpisodeID, Episode.Title";

            return sqlConnection.sqlHandler.executeSql(query);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return resultSet;
    }



}

