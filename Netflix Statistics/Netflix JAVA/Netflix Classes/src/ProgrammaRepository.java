
import java.sql.*;
import java.util.*;
import Connection.SqlConnection;

public class ProgrammaRepository {
    private SqlConnection sqlConnection;

    public ProgrammaRepository(SqlConnection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public ArrayList<Programma> readAll() {
        ArrayList<Programma> lijst = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT * FROM Programma");
            while(rs.next()) {
                //lijst.add(new Programma(rs.getInt("ProgrammaID"),rs.getString("Title")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return lijst;
    }

    public Programma read(int programmaID) {
        Programma programma = null;
        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            String sqlQuery = "SELECT * FROM Programma WHERE ProgrammaID= " + programmaID;
            ResultSet rs = sqlConnection.executeSql(sqlQuery);
            rs.next();
            //lijst.add(new Programma(rs.getInt("ProgrammaID"),rs.getString("Title")));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return programma;
    }

    public void create(Programma programma) {
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

    public void delete(Programma programma) {
        if(programma == null) return;
        delete(programma.getProgrammaID());
    }

    public void delete(int programmaID) {
        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            String sqlQuery = "DELETE Programma WHERE ProgrammaID= " + programmaID;
            sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

}
