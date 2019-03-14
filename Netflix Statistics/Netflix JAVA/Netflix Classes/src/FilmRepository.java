
import java.sql.*;
import java.util.*;

public class FilmRepository {
    private Connection.SqlConnection sqlConnection;

    public FilmRepository(Connection.SqlConnection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public ArrayList<Film> readAll() {
        ArrayList<Film> lijst = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT * FROM FILM");
            while(rs.next()) {
                //lijst.add(new Film(rs.getInt("FilmID"),rs.getString("Title"), rs.getString("Tijdsduur"), rs.getString("Genre"), rs.getString("Taal"), rs.getString("Leeftijds Indicatie"), rs.getString("ProgrammaID")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return lijst;
    }

    public Film read(int filmID) {
        Film film = null;
        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            String sqlQuery = "SELECT * FROM FILM WHERE FilmID= " + filmID;
            ResultSet rs = sqlConnection.executeSql(sqlQuery);
            rs.next();
            //lijst.add(new Film(rs.getInt("FilmID"),rs.getString("Title"), rs.getString("Tijdsduur"), rs.getString("Genre"), rs.getString("Taal"), rs.getString("Leeftijds Indicatie"), rs.getString("ProgrammaID")));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return film;
    }

    public void create(Film film) {
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

    public void delete(Film film) {
        if(film == null) return;
        delete(film.getFilmID());
    }

    public void delete(int filmID) {
        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            String sqlQuery = "DELETE FILM WHERE FilmID= " + filmID;
            sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

}
