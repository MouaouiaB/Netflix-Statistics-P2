package Repositories;

import java.sql.*;
import java.util.*;
import Connection.*;
import Domain.*;

import static javax.swing.JOptionPane.showMessageDialog;


public class AccountRepository {
    private String sqlConnection;
    private SqlHandler sqlHandler;
    private SqlConnection DBConnection;

    public AccountRepository() {


    }

    public ResultSet readAll() {
        ResultSet resultSet = null;

        ArrayList<Account> lijst = new ArrayList<>();
        try {

            return DBConnection.sqlHandler.executeSql("SELECT * FROM Account");
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
            String sqlQuery = "SELECT AccountID FROM Account WHERE AccountName = '" + name + "'";
            ResultSet rs = DBConnection.sqlHandler.executeSql(sqlQuery);
            while(rs.next()) {
                accountId = rs.getInt("AccountID");
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return accountId;
    }

    public Account read(int id) {
        Account account = null;
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            connection = DriverManager.getConnection(sqlConnection);
            statement = connection.createStatement();
            String sqlQuery = "SELECT * FROM Account WHERE AccountID=" + id;
            resultSet = statement.executeQuery("SELECT * FROM Account WHERE AccountID=" + id);
            resultSet.next();
            // account = new Domain.Account(rs.getInt("Id"),rs.getString("Name"), rs.getString("StudentNumber"));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return account;
    }

    public boolean create(Account account) {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            //String sqlQuery = "INSERT INTO ABONNEMENT VALUES (" + student.getId() + ", '" + student.getName() + "', '" + student.getStudentNumber() + "')";
            // sqlConnection.executeSqlNoResult(sqlQuery);

            //statement = connection.createStatement();
            String sqlQuery = "INSERT INTO Account VALUES('" +
                    account.getAccountName()+ "',' "+
                    account.getEmail()+ "',' "+
                    account.getPassword() + "',' "+
                    account.getStreet()+ "',' "+
                    account.getHouseNumber()+ "',' "+
                    account.getZipCode()+ "',' "+
                    account.getCity()+
                    "')";
            showMessageDialog(null, "Account succesvol toegevoegd");
            return DBConnection.sqlHandler.executeSqlNoResult(sqlQuery);

        }
        catch(Exception e) {
            System.out.println(e);
        }

        return false;
    }

    public void delete(Account account) {
        if(account ==null) return;
        delete(account.getAccountId());
    }

    public void delete(int id) {

        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            connection = DriverManager.getConnection(sqlConnection);
            statement = connection.createStatement();
            String sqlQuery = "DELETE ABONNEMENT WHERE Id=" + id;
            resultSet = statement.executeQuery(sqlQuery);
            resultSet.next();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public ResultSet AccountOneProfile(){
        ResultSet resultSet = null;

        try {
            String query = "SELECT Account.AccountName \n" +
                    "FROM Account\n"+
                    "JOIN Profile On Account.AccountID = Profile.AccountID "+
                    "GROUP BY Account.AccountName HAVING COUNT(*) = 1";
            return DBConnection.sqlHandler.executeSql(query);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return resultSet;
    }

    public ResultSet WatchedMovies(){
        ResultSet resultSet = null;

        try {
            String query = "SELECT DISTINCT Account.AccountName, Moviess.Title\n" +
                    "FROM Account\n" +
                    "INNER JOIN Profile ON Account.AccountID = Profile.AccountID\n" +
                    "INNER JOIN (SELECT Program.ProfileID,Program.MovieID , Program.Title FROM Program WHERE Program.Precentage = 100)\n" +
                    "AS Programs ON Profile.ProfileID = Programs.ProfileID\n" +
                    "INNER JOIN (SELECT Movie.MovieID FROM Movie ) AS Movies ON Programs.MovieID = Movies.MovieID\n" +
                    "INNER JOIN (SELECT Movie.Title FROM Movie ) AS Moviess ON Programs.Title = Moviess.Title\n";
            return DBConnection.sqlHandler.executeSql(query);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return resultSet;

    }


}

