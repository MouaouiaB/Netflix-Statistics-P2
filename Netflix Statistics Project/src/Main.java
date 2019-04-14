import Connection.SqlConnection;
import UI.UserInterface;

import javax.swing.*;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        SqlConnection.createConnection();
        SwingUtilities.invokeLater(new UserInterface());
    }
}
