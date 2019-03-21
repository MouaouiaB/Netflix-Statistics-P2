
import java.sql.*;
import java.util.*;
import Connection.SqlConnection;

public class AfleveringRepository{
    private String sqlConnection;

    public AfleveringRepository(String sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public ArrayList<Aflevering> readAll() {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        ArrayList<Aflevering> lijst = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(sqlConnection);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM AFLEVERING");
            while(resultSet.next()) {
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

        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;


        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            connection = DriverManager.getConnection(sqlConnection);
            statement = connection.createStatement();
            String sqlQuery = "SELECT * FROM AFLEVERING WHERE AfleveringID =" + AfleveringID;
            resultSet = statement.executeQuery(sqlQuery);
            resultSet.next();


        }
        catch(Exception e) {
            System.out.println(e);
        }
        return aflevering;
    }

    public void create(Aflevering aflevering) {
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
            String sqlQuery = "INSERT INTO AFLEVERING VALUES(" +
                    aflevering.getAfleveringID()+ ", "+
                    aflevering.getSerieNaam()+ ", "+
                    aflevering.getTitle()+ ", "+
                    aflevering.getProgrammaID() + ", "+
                    aflevering.getSeizoenEnAflevering()+ ", "+
                    aflevering.getTijdsduur()+
                    ")";
            resultSet = statement.executeQuery(sqlQuery);
            resultSet.next();
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

        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            connection = DriverManager.getConnection(sqlConnection);
            statement = connection.createStatement();
            String sqlQuery = "DELETE AFLEVERING WHERE AfleveringID =" + AfleveringID;
            resultSet = statement.executeQuery(sqlQuery);
            resultSet.next();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

}
