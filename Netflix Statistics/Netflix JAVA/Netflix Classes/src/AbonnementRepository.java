
import java.sql.*;
import java.util.*;

public class AbonnementRepository {
    private SqlConnection sqlConnection;

    public AbonnementRepository(SqlConnection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public ArrayList<Abonnement> readAll() {
        ArrayList<Abonnement> lijst = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT * FROM ABONNEMENT");
            while(rs.next()) {
                //lijst.add(new Abonnement(rs.getInt("Id"),rs.getString("Name"), rs.getString("StudentNumber")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return lijst;
    }

    public Abonnement read(int id) {
        Abonnement abonnement = null;
        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            String sqlQuery = "SELECT * FROM ABONNEMENT WHERE Id=" + id;
            ResultSet rs = sqlConnection.executeSql(sqlQuery);
            rs.next();
            // abonnement = new Abonnement(rs.getInt("Id"),rs.getString("Name"), rs.getString("StudentNumber"));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return abonnement;
    }

    public void create(Abonnement abonnement) {
        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            //String sqlQuery = "INSERT INTO ABONNEMENT VALUES (" + student.getId() + ", '" + student.getName() + "', '" + student.getStudentNumber() + "')";
            // sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public void delete(Abonnement abonnement) {
        if(abonnement==null) return;
        //delete(abonnement.getId());
    }

    public void delete(int id) {
        try
        {
            //let op: het samenvoegen van strings binnen SQL commando's is ONVEILIG. Pas dit niet toe in een productieomgeving.
            //later in het curriculum wordt behandeld op welke wijze je je hiertegen kunt beschermen.
            String sqlQuery = "DELETE ABONNEMENT WHERE Id=" + id;
            sqlConnection.executeSqlNoResult(sqlQuery);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

}
