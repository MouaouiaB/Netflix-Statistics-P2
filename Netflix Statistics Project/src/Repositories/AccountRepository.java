package Repositories;

import java.sql.*;
import java.util.*;
import Connection.*;
import Domain.*;

import static javax.swing.JOptionPane.showMessageDialog;


public class AccountRepository {
    private SqlHandler sqlHandler;
    private SqlConnection sqlConnection;

    public AccountRepository() {

    }

    public ResultSet readAll(){
        ResultSet resultSet = null;

        try {

            return sqlConnection.sqlHandler.executeSql("SELECT AccountID FROM Account");
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return resultSet;
    }

    public ArrayList AccountsArrayList(){
        ArrayList<Account>accounts = new ArrayList<>();
        ResultSet resultSet = null;

        try {

            resultSet = sqlConnection.sqlHandler.executeSql("SELECT * FROM Account");
            while (resultSet.next()){
                accounts.add(new Account(resultSet.getString("Accountname"),
                        resultSet.getString("FullName") ,
                        resultSet.getString("Email") ,
                        resultSet.getString("Password"),
                        resultSet.getString("Street"),
                        resultSet.getString("HouseNumber"),
                        resultSet.getString("ZipCode"),
                        resultSet.getString("City")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return accounts;

    }

    public ArrayList getAccountNames(){
        ArrayList<String>list = new ArrayList<>();
        try
        {
            String sqlQuery = "SELECT AccountName FROM Account";
            ResultSet rs = sqlConnection.sqlHandler.executeSql(sqlQuery);
            while(rs.next()) {
                list.add(rs.getString("AccountName"));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return list;
    }


    public ResultSet readAllToTable() {
        ResultSet resultSet = null;

        try {

            return sqlConnection.sqlHandler.executeSql("SELECT * FROM Account");
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return resultSet;
    }

    public int readIdWithName(String name){
        int accountId = 0;
        try
        {
            String sqlQuery = "SELECT AccountID FROM Account WHERE AccountName = '" + name + "'";
            ResultSet rs = sqlConnection.sqlHandler.executeSql(sqlQuery);
            while(rs.next()) {
                accountId = rs.getInt("AccountID");
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return accountId;
    }


    public boolean create(Account account) {
        try
        {
            String sqlQuery = "INSERT INTO Account VALUES('" +
                    account.getAccountName()+ "',' "+
                    account.getFullName() + "', '"+
                    account.getEmail()+ "',' "+
                    account.getPassword() + "',' "+
                    account.getStreet()+ "',' "+
                    account.getHouseNumber()+ "',' "+
                    account.getZipCode()+ "',' "+
                    account.getCity()+
                    "')";
            showMessageDialog(null, "Account succesvol toegevoegd");
            return sqlConnection.sqlHandler.executeSqlNoResult(sqlQuery);

        }
        catch(Exception e) {
            showMessageDialog(null, "Formulier foutief ingevuld");
            System.out.println(e);
        }

        return false;
    }

    public boolean update(Account account) {
        int id = readIdWithName(account.getAccountName());
        try
        {
            String sqlQuery = "UPDATE Account SET AccountName = '" +
                    account.getAccountName()+ "', FullName = '"+ account.getFullName() +
                    "', Email = ' "+
                    account.getEmail()+ "', Password =' "+
                    account.getPassword() + "',Street = ' "+
                    account.getStreet()+ "',HouseNumber =' "+
                    account.getHouseNumber()+ "', ZipCode = ' "+
                    account.getZipCode()+ "', City = ' "+
                    account.getCity()+ "'" + "WHERE AccountID = " + id;
            showMessageDialog(null, "Account succesvol geupdate");
            return sqlConnection.sqlHandler.executeSqlNoResult(sqlQuery);

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
            String sqlQuery = "DELETE FROM Account WHERE AccountID = "+ id;
            showMessageDialog(null, "Account succesvol verwijderd");
            return sqlConnection.sqlHandler.executeSqlNoResult(sqlQuery);

        }
        catch(Exception e) {
            showMessageDialog(null, "Formulier foutief ingevuld");
            System.out.println(e);
        }

        return false;
    }

    public ResultSet AccountOneProfile(){
        ResultSet resultSet = null;

        try {
            String query = "SELECT Account.AccountName \n" +
                    "FROM Account\n"+
                    "JOIN Profile On Account.AccountID = Profile.AccountID "+
                    "GROUP BY Account.AccountName HAVING COUNT(*) = 1";
            return sqlConnection.sqlHandler.executeSql(query);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return resultSet;
    }

    public ResultSet WatchedMovies(String title){
        ResultSet resultSet = null;

        try {
            String query = "SELECT DISTINCT Account.AccountName, Moviess.Title\n" +
                    "FROM Account\n" +
                    "INNER JOIN Profile ON Account.AccountID = Profile.AccountID\n" +
                    "INNER JOIN (SELECT Program.ProfileID,Program.MovieID , Program.Title FROM Program WHERE Program.Precentage = 100)\n" +
                    "AS Programs ON Profile.ProfileID = Programs.ProfileID\n" +
                    "INNER JOIN (SELECT Movie.MovieID FROM Movie ) AS Movies ON Programs.MovieID = Movies.MovieID\n" +
                    "INNER JOIN (SELECT Movie.Title FROM Movie ) AS Moviess ON Programs.Title = Moviess.Title\n" +
                    "WHERE Account.AccountName = '"+ title + "'";;
            return sqlConnection.sqlHandler.executeSql(query);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return resultSet;

    }


}

