
import java.sql.*;
import java.util.*;

public class ProfileRepository {
    private Connection.SqlConnection sqlConnection;

    public ProfileRepository(Connection.SqlConnection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public ArrayList<Profile> readAll() {
        ArrayList<Profile> lijst = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT * FROM Profiel");
            while(rs.next()) {
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
        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            String sqlQuery = "SELECT * FROM Profiel WHERE AbonneeID= " + abonneeID;
            ResultSet rs = sqlConnection.executeSql(sqlQuery);
            rs.next();
            //lijst.add(new Profile(rs.getString("Profile naam"), rs.getString("Geboortedatum"), rs.getString("AbonneeID")));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return profile;
    }

    public void create(Profile profile) {
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
        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            String sqlQuery = "DELETE Profiel WHERE AbonneeID= " + abonneeID;
            sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

}
