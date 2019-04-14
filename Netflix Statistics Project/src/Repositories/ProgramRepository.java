package Repositories;

import java.sql.*;

import Connection.*;

import Domain.Program;

import static javax.swing.JOptionPane.showMessageDialog;

public class ProgramRepository {

    private SqlConnection sqlConnection;
    private SqlHandler sqlHandler;

    MovieRepository movieRepository = new MovieRepository();
    ProfileRepository profileRepository = new ProfileRepository();
    SerieRepository serieRepository = new SerieRepository();
    EpisodeRepository episodeRepository = new EpisodeRepository();


    public ProgramRepository() {

    }

    public ResultSet readAll() {
        ResultSet resultSet = null;
        try {
            return sqlConnection.sqlHandler.executeSql("SELECT * FROM Program");
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return resultSet;
    }


    public int readIdWithName (String name){
        int accountId = 0;
        try
        {
            String sqlQuery = "SELECT ProgramID FROM Program WHERE Title = '" + name + "'";
            ResultSet rs = sqlConnection.sqlHandler.executeSql(sqlQuery);
            while(rs.next()) {
                accountId = rs.getInt("ProgramID");
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return accountId;
    }

    public boolean createMovie(Program program) {
        int profileId= profileRepository.readIdWithName(program.getProfileName());
        int movieId = movieRepository.readIdWithName(program.getTitle());


        try
        {
            String sqlQuery = "INSERT INTO Program (Title, MovieID, ProfileID, Precentage) VALUES('" +
                    program.getTitle()+ "', "+
                    movieId +", "+
                    profileId +", "+
                    program.getPrecentage()+
                    ")";
            showMessageDialog(null, "Programma toegevoegd");
            return sqlConnection.sqlHandler.executeSqlNoResult(sqlQuery);

        }
        catch(Exception e) {
            showMessageDialog(null, "Formulier foutief ingevuld");
            System.out.println(e);
        }
        return false;
    }

    public boolean createSerie(Program program) {
        int profileId= profileRepository.readIdWithName(program.getProfileName());
        int serieId = serieRepository.readIdWithName(program.getTitle());
        int episodeId = episodeRepository.readIdWithName(program.getEpisodeTitle());

        try
        {
            String sqlQuery = "INSERT INTO Program (Title, SerieID, EpisodeID, ProfileID, Precentage) VALUES('" +
                    program.getEpisodeTitle()+ "', "+
                    serieId +", "+
                    episodeId +", "+
                    profileId +", "+
                    program.getPrecentage()+
                    ")";
            showMessageDialog(null, "Programma toegevoegd");
            return sqlConnection.sqlHandler.executeSqlNoResult(sqlQuery);

        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }


    public boolean delete(int programID) {

        try
        {
            String sqlQuery = "DELETE FROM Program WHERE ProgramID = "+ programID;
            showMessageDialog(null, "Programma succesvol verwijderd");
            return sqlConnection.sqlHandler.executeSqlNoResult(sqlQuery);

        }
        catch(Exception e) {
            showMessageDialog(null, "Formulier foutief ingevuld");
            System.out.println(e);
        }

        return false;
    }

    public boolean updateSerie(Program program) {
        int programId = readIdWithName(program.getTitle());
        int profileId= profileRepository.readIdWithName(program.getProfileName());
        int serieId = serieRepository.readIdWithName(program.getTitle());
        int episodeId = episodeRepository.readIdWithName(program.getEpisodeTitle());
        //int accountId = accountRepository.readIdWithName(program.get)
        try {
            String sqlQuery = "UPDATE Program SET Title = '" + program.getTitle() +
                    "', SerieID =  " + serieId +
                    ", EpisodeID = "+ episodeId +
                    ", Precentage = " + program.getPrecentage() +  " WHERE ProgramID = " + programId;
            showMessageDialog(null, "Program succesvol gewijzigd");
            return sqlConnection.sqlHandler.executeSqlNoResult(sqlQuery);

        } catch (Exception e) {
            showMessageDialog(null, "Formulier foutief ingevuld");
            System.out.println(e);
        }

        return false;
    }

    public boolean updateMovie(Program program) {
        int programId = readIdWithName(program.getTitle());
        int profileId= profileRepository.readIdWithName(program.getProfileName());
        int movieId = movieRepository.readIdWithName(program.getTitle());
        try {
            String sqlQuery = "UPDATE Program SET Title = '" + program.getTitle() +
                    "', MovieID =  " + movieId +
                    ", Precentage = " + program.getPrecentage() +  " WHERE ProgramID = " + programId;
            showMessageDialog(null, "Program succesvol gewijzigd");
            return sqlConnection.sqlHandler.executeSqlNoResult(sqlQuery);

        } catch (Exception e) {
            showMessageDialog(null, "Formulier foutief ingevuld");
            System.out.println(e);
        }

        return false;
    }

}

