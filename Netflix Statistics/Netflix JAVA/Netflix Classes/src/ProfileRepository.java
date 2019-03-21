
import java.sql.*;
import java.util.*;

public class ProfileRepository {
    private String sqlConnection;

    public ProfileRepository(String sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public ArrayList<Profile> readAll() {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        ArrayList<Profile> lijst = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(sqlConnection);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Profiel");
            while(resultSet.next()) {
                //lijst.add(new Profile(rs.getString("Profile naam"), rs.getString("Geboortedatum"), rs.getString("AbonneeID")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return lijst;
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
            //lijst.add(new Profile(rs.getString("Profile naam"), rs.getString("Geboortedatum"), rs.getString("AbonneeID")));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return profile;
    }

    public void create(Profile profile) {
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

    public void delete(Profile profile) {
        if(profile == null) return;
        delete(profile.getAbonneeID());
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
