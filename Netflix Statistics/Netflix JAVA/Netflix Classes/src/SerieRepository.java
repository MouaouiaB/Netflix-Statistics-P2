
import java.sql.*;
import java.util.*;
import Connection.SqlConnection;

public class SerieRepository {
    private SqlConnection sqlConnection;

    public SerieRepository(SqlConnection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public ArrayList<Serie> readAll() {
        ArrayList<Serie> lijst = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT * FROM Serie");
            while(rs.next()) {
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
        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            String sqlQuery = "SELECT * FROM Serie WHERE ProgrammaID= " + ProgrammaID;
            ResultSet rs = sqlConnection.executeSql(sqlQuery);
            rs.next();
            //lijst.add(new Film(rs.getInt("FilmID"),rs.getString("Title"), rs.getString("Tijdsduur"), rs.getString("Genre"), rs.getString("Taal"), rs.getString("Leeftijds Indicatie"), rs.getString("ProgrammaID")));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return serie;
    }

    public void create(Serie serie) {
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
        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            String sqlQuery = "DELETE Serie WHERE ProgrammaID= " + programmaID;
            sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

}
