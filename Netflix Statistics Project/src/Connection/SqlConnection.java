package Connection;


public class SqlConnection {
    public static SqlHandler sqlHandler;

    public static void createConnection() {
        sqlHandler = new SqlHandler();
        sqlHandler.connectDatabase("jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=NetflixStatistics;integratedSecurity=true;"); // databaseName invullen
    }
}
