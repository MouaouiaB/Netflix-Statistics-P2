package Repositories;

import java.awt.color.ProfileDataException;
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

    public ArrayList ProfileArrayList(){
        ArrayList<Profile>profiles = new ArrayList<>();
        ResultSet resultSet = null;

        try {

            resultSet = dbConnection.sqlHandler.executeSql("SELECT * FROM Profile");
            while (resultSet.next()){
                profiles.add(new Profile(resultSet.getString("Profilename"),
                        resultSet.getString("AccountName"),
                        resultSet.getInt("Age")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return profiles;

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
            String sqlQuery = "INSERT INTO Profile VALUES('" +
                    profile.getProfileName()+ "' ,'" + profile.getName() +  "', "+ id + ", "+ profile.getBirthDate()+
                    ")";
            showMessageDialog(null, "Toevoegen van een profiel is gelukt");
            return dbConnection.sqlHandler.executeSqlNoResult(sqlQuery);

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
            String sqlQuery = "DELETE FROM Profile WHERE ProfileID = "+ id;
            showMessageDialog(null, "Profiel succesvol verwijderd");
            return dbConnection.sqlHandler.executeSqlNoResult(sqlQuery);

        }
        catch(Exception e) {
            showMessageDialog(null, "Formulier foutief ingevuld");
            System.out.println(e);
        }

        return false;
    }

    public boolean update(Profile profile) {
        int id = readIdWithName(profile.getProfileName());
        int accountid = accountRepository.readIdWithName(profile.getName());
        try {
            String sqlQuery = "UPDATE Profile SET Profilename = '" + profile.getProfileName() +
                    "', AccountName = ' " + profile.getName() +
                    "', AccountID = "+ accountid +
                    ", Age = " + profile.getBirthDate() +  "WHERE ProfileID = " + id;
            showMessageDialog(null, "Profiel gewijzigd");
            return dbConnection.sqlHandler.executeSqlNoResult(sqlQuery);
        } catch (Exception e) {
            showMessageDialog(null, "Formulier foutief ingevuld");
            System.out.println(e);
        }

        return false;
    }

}
