package Repositories;

import java.sql.*;
import java.util.*;
import Connection.*;
import Domain.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class ProfileRepository {
    private String sqlConnection;
    private SqlConnection dbConnection;
    private SqlHandler sqlHandler;
    private AccountRepository accountRepository = new AccountRepository();


    public ProfileRepository() {

    }

    public ResultSet readAll() {
        ResultSet resultSet = null;
        try {
            return dbConnection.sqlHandler.executeSql("SELECT * FROM Profile");
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return resultSet;
    }

    public Profile read(int abonneeID) {
        Profile profile = null;

        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            connection = DriverManager.getConnection(sqlConnection);
            statement = connection.createStatement();
            String sqlQuery = "SELECT * FROM Profiel WHERE AbonneeID= " + abonneeID;
            resultSet = statement.executeQuery(sqlQuery);
            resultSet.next();
            //lijst.add(new Domain.Profile(rs.getString("Domain.Profile naam"), rs.getString("Geboortedatum"), rs.getString("AbonneeID")));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return profile;
    }

    public int readIdWithName (String name){
        int profileId = 0;
        try
        {
            String sqlQuery = "SELECT ProfileID FROM Profile WHERE Profilename = '" + name + "'";
            ResultSet rs = dbConnection.sqlHandler.executeSql(sqlQuery);
            while(rs.next()) {
                profileId = rs.getInt("ProfileID");
            }

        }
        catch(Exception e) {
            System.out.println(e);
        }
        return profileId;
    }

    public boolean create(Profile profile) {
        int id  = accountRepository.readIdWithName(profile.getName());
        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            // sqlConnection.executeSqlNoResult(sqlQuery);
            String sqlQuery = "INSERT INTO Profile VALUES('" +
                    profile.getProfileName()+ "', "+ id + ", "+ profile.getBirthDate()+
                    ")";
            //System.out.println(sqlQuery);
            showMessageDialog(null, "Toevoegen van een profiel is gelukt");
            return dbConnection.sqlHandler.executeSqlNoResult(sqlQuery);

        }
        catch(Exception e) {
            showMessageDialog(null, "Formulier foutief ingevuld");
            System.out.println(e);
        }
        return false;
    }

    public void delete(Profile profile) {
        if(profile == null) return;
        delete(profile.getProfileId());
    }

    public void delete(int abonneeID) {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            connection = DriverManager.getConnection(sqlConnection);
            statement = connection.createStatement();
            String sqlQuery = "DELETE Profiel WHERE AbonneeID= " + abonneeID;
            resultSet = statement.executeQuery(sqlQuery);
            resultSet.next();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

}
