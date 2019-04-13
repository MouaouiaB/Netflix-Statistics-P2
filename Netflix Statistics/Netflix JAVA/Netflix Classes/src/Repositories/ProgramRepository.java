package Repositories;

import java.sql.*;
import java.util.*;
import Connection.*;
import Domain.*;

import Domain.Program;

import static javax.swing.JOptionPane.showMessageDialog;

public class ProgramRepository {
    private String sqlConnection;
    private SqlConnection dbConnection;
    private SqlHandler sqlHandler;

    MovieRepository movieRepository = new MovieRepository();
    ProfileRepository profileRepository = new ProfileRepository();
    SerieRepository serieRepository = new SerieRepository();
    EpisodeRepository episodeRepository = new EpisodeRepository();
    AccountRepository accountRepository = new AccountRepository();

    public ProgramRepository() {
        this.sqlConnection = sqlConnection;
    }

    public ResultSet readAll() {
        ResultSet resultSet = null;
        try {
            return dbConnection.sqlHandler.executeSql("SELECT * FROM Program");
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return resultSet;
    }


    public Program read(int programmaID) {
        Program program = null;
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            connection = DriverManager.getConnection(sqlConnection);
            statement = connection.createStatement();
            String sqlQuery = "SELECT * FROM Domain.Program WHERE ProgrammaID= " + programmaID;
            resultSet = statement.executeQuery(sqlQuery);
            resultSet.next();
            //lijst.add(new Domain.Program(rs.getInt("ProgrammaID"),rs.getString("Title")));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return program;
    }

    public boolean createMovie(Program program) {
        int profileId= profileRepository.readIdWithName(program.getProfileName());
        int movieId = movieRepository.readIdWithName(program.getTitle());
        //int accountId = accountRepository.readIdWithName(program.get)

        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            // sqlConnection.executeSqlNoResult(sqlQuery);

            String sqlQuery = "INSERT INTO Program (Title, MovieID, ProfileID, Precentage) VALUES('" +
                    program.getTitle()+ "', "+
                    movieId +", "+
                    profileId +", "+
                    program.getPrecentage()+
                    ")";
            showMessageDialog(null, "Programma toegevoegd");
            return dbConnection.sqlHandler.executeSqlNoResult(sqlQuery);

        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean createSerie(Program program) {
        int profileId= profileRepository.readIdWithName(program.getProfileName());
        int serieId = serieRepository.readIdWithName(program.getTitle());
        int episodeId = episodeRepository.readIdWithName(program.getEpisodeTitle());
        //int accountId = accountRepository.readIdWithName(program.get)

        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            // sqlConnection.executeSqlNoResult(sqlQuery);

            String sqlQuery = "INSERT INTO Program (Title, SerieID, EpisodeID, ProfileID, Precentage) VALUES('" +
                    program.getTitle()+ "', "+
                    serieId +", "+
                    episodeId +", "+
                    profileId +", "+
                    program.getPrecentage()+
                    ")";
            showMessageDialog(null, "Programma toegevoegd");
            return dbConnection.sqlHandler.executeSqlNoResult(sqlQuery);

        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public void delete(Program program) {
        if(program == null) return;
        delete(program.getProgramId());
    }

    public void delete(int programmaID) {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            connection = DriverManager.getConnection(sqlConnection);
            statement = connection.createStatement();
            String sqlQuery = "DELETE Domain.Program WHERE ProgrammaID= " + programmaID;
            resultSet = statement.executeQuery(sqlQuery);
            resultSet.next();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

}

