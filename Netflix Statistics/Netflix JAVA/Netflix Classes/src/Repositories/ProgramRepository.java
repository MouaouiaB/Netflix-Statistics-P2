package Repositories;

import java.sql.*;
import java.util.*;
import Connection.*;
import Domain.*;

import Domain.Program;

public class ProgramRepository {
    private String sqlConnection;
    private SqlConnection dbConnection;
    private SqlHandler sqlHandler;

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

    public void create(Program program) {
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
            String sqlQuery = "INSERT INTO Domain.Program VALUES(" +
                    program.getProgramId()+ ", "+
                    program.getTitle()+
                    ")";
            resultSet = statement.executeQuery(sqlQuery);
            resultSet.next();
        }
        catch(Exception e) {
            System.out.println(e);
        }
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
