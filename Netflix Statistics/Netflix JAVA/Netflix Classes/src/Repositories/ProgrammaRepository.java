package Repositories;

import java.sql.*;
import java.util.*;

import Domain.Programma;

public class ProgrammaRepository {
    private String sqlConnection;

    public ProgrammaRepository(String sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public ArrayList<Programma> readAll() {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        ArrayList<Programma> lijst = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(sqlConnection);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Domain.Programma");
            while(resultSet.next()) {
                //lijst.add(new Domain.Programma(rs.getInt("ProgrammaID"),rs.getString("Title")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return lijst;
    }

    public Programma read(int programmaID) {
        Programma programma = null;
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            connection = DriverManager.getConnection(sqlConnection);
            statement = connection.createStatement();
            String sqlQuery = "SELECT * FROM Domain.Programma WHERE ProgrammaID= " + programmaID;
            resultSet = statement.executeQuery(sqlQuery);
            resultSet.next();
            //lijst.add(new Domain.Programma(rs.getInt("ProgrammaID"),rs.getString("Title")));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return programma;
    }

    public void create(Programma programma) {
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
            String sqlQuery = "INSERT INTO Domain.Programma VALUES(" +
                    programma.getProgrammaID()+ ", "+
                    programma.getTitle()+
                    ")";
            resultSet = statement.executeQuery(sqlQuery);
            resultSet.next();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public void delete(Programma programma) {
        if(programma == null) return;
        delete(programma.getProgrammaID());
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
            String sqlQuery = "DELETE Domain.Programma WHERE ProgrammaID= " + programmaID;
            resultSet = statement.executeQuery(sqlQuery);
            resultSet.next();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

}
