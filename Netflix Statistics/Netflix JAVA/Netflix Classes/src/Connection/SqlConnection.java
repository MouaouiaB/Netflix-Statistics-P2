package Connection;

import java.sql.ResultSet;
import java.sql.*;

public class SqlConnection {
    public void executeSqlNoResult(String sqlQuery) {
    }

    public ResultSet executeSql(String sqlQuery) {
        ResultSet resultSet = null;
        Statement statement = null;
        //resultSet = statement.executeQuery(sqlQuery);
        return null;
    }
}
