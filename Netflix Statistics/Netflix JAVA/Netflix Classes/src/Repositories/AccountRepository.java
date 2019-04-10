package Repositories;

import java.sql.*;
import java.util.*;
import Connection.*;
import Domain.*;


public class AccountRepository {
    private String sqlConnection;
    private SqlHandler sqlHandler;
    private SqlConnection DBConnection;

    public AccountRepository() {


    }

    public ArrayList<Account> readAll() {
        ResultSet resultSet = null;

        ArrayList<Account> lijst = new ArrayList<>();
        try {

            resultSet = DBConnection.sqlHandler.executeSql("SELECT * FROM Account");
            while(resultSet.next()) {
                lijst.add(new Domain.Account(resultSet.getString("AccountName"),resultSet.getString("Email"), resultSet.getString("Wachtwoord"),  resultSet.getString("Straat"), resultSet.getInt("Huisnummer"), resultSet.getString("Postcode"), resultSet.getString("AbonneeWoonplaats")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return lijst;
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

}
