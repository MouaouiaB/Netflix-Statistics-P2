
import java.sql.*;
import java.util.*;

public class AfleveringRepository{
    private SqlConnection sqlConnection;

    public AfleveringRepository(SqlConnection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public ArrayList<Aflevering> readAll() {
        ArrayList<Aflevering> lijst = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT * FROM AFLEVERING");
            while(rs.next()) {
                //lijst.add(new AfleveringRepository(rs.getInt("AfleveringID"),rs.getString("Serie"), rs.getString("ProgrammaID"), rs.getString("Title"), rs.getString("Seizoen en aflevering"), rs.getString("Tijdsduur")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return lijst;
    }

    public Aflevering read(int AfleveringID) {
        Aflevering aflevering = null;
        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            String sqlQuery = "SELECT * FROM AFLEVERING WHERE AfleveringID =" + AfleveringID;
            ResultSet rs = sqlConnection.executeSql(sqlQuery);
            rs.next();

        }
        catch(Exception e) {
            System.out.println(e);
        }
        return aflevering;
    }

    public void create(Aflevering aflevering) {
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

    public void delete(Aflevering aflevering) {
        if(aflevering == null) return;
        delete(aflevering.getAfleveringID());
    }

    public void delete(int AfleveringID) {
        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            String sqlQuery = "DELETE AFLEVERING WHERE AfleveringID =" + AfleveringID;
            sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

}
