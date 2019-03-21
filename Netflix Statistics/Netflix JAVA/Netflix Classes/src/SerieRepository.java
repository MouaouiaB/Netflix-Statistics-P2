
import java.sql.*;
import java.util.*;
import Connection.SqlConnection;

public class SerieRepository {
    private String sqlConnection;

    public SerieRepository(String sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public ArrayList<Serie> readAll() {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        ArrayList<Serie> lijst = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(sqlConnection);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Serie");
            while(resultSet.next()) {
                //lijst.add(new Serie(rs.getString("Title"), rs.getString("Genre"), rs.getString("Taal"), rs.getString("Seizoen"), rs.getString("Leeftijds Indicatie"), rs.getString("Lijktop"), rs.getString("ProgrammaID")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return lijst;
    }

    public Serie read(int ProgrammaID) {
         Serie serie = null;
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            connection = DriverManager.getConnection(sqlConnection);
            statement = connection.createStatement();
            String sqlQuery = "SELECT * FROM Serie WHERE ProgrammaID= " + ProgrammaID;
            resultSet = statement.executeQuery(sqlQuery);
            resultSet.next();
            //lijst.add(new Film(rs.getInt("FilmID"),rs.getString("Title"), rs.getString("Tijdsduur"), rs.getString("Genre"), rs.getString("Taal"), rs.getString("Leeftijds Indicatie"), rs.getString("ProgrammaID")));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return serie;
    }

    public void create(Serie serie) {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            // sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public void delete(Serie serie) {
        if(serie == null) return;
        delete(serie.getProgrammaID());
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
            String sqlQuery = "DELETE Serie WHERE ProgrammaID= " + programmaID;
            resultSet = statement.executeQuery(sqlQuery);
            resultSet.next();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

}
