package Repositories;

import java.sql.*;
import java.util.*;
import Domain.*;


public class AbonnementRepository {
    private String sqlConnection;

    public AbonnementRepository(String sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public ArrayList<Abonnement> readAll() {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        ArrayList<Abonnement> lijst = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(sqlConnection);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM ABONNEMENT");
            while(resultSet.next()) {
                //lijst.add(new Domain.Abonnement(rs.getInt("Id"),rs.getString("Name"), rs.getString("StudentNumber")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return lijst;
    }

    public Abonnement read(int id) {
        Abonnement abonnement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            connection = DriverManager.getConnection(sqlConnection);
            statement = connection.createStatement();
            String sqlQuery = "SELECT * FROM ABONNEMENT WHERE Id=" + id;
            resultSet = statement.executeQuery(sqlQuery);
            resultSet.next();
            // abonnement = new Domain.Abonnement(rs.getInt("Id"),rs.getString("Name"), rs.getString("StudentNumber"));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return abonnement;
    }

    public void create(Abonnement abonnement) {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            //String sqlQuery = "INSERT INTO ABONNEMENT VALUES (" + student.getId() + ", '" + student.getName() + "', '" + student.getStudentNumber() + "')";
            // sqlConnection.executeSqlNoResult(sqlQuery);
            connection = DriverManager.getConnection(sqlConnection);
            statement = connection.createStatement();
            String sqlQuery = "INSERT INTO ABONNEMENT VALUES(" +
                    abonnement.getAbonneeID()+ ", "+
                    abonnement.getAbonneeNaam()+ ", "+
                    abonnement.getEmail()+ ", "+
                    abonnement.getWachtwoord() + ", "+
                    abonnement.getStraat()+ ", "+
                    abonnement.getHuisnummer()+ ", "+
                    abonnement.getPostcode()+ ", "+
                    abonnement.getAbonneeWoonplaats()+
                    ")";
            resultSet = statement.executeQuery(sqlQuery);
            resultSet.next();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public void delete(Abonnement abonnement) {
        if(abonnement==null) return;
        delete(abonnement.getAbonneeID());
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
