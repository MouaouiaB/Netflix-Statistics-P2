import Connection.SqlConnection;
import UI.UserInterface;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SqlConnection.createConnection();
        SwingUtilities.invokeLater(new UserInterface());
        //test

    }
}
