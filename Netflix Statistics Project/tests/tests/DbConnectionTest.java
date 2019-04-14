package tests;
import Connection.SqlHandler;
import Domain.Account;
import Repositories.AccountRepository;
import org.junit.Assert;
import  org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import javax.swing.table.TableModel;
import java.util.ArrayList;

public class DbConnectionTest {
    AccountRepository accountRepository = new AccountRepository();
    @DisplayName("Tests Database connection")
    @Test
    public void testConnection() throws Exception{
        SqlHandler sqlHandler = new SqlHandler();
        sqlHandler.connectDatabase("jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=NetflixStatistics;integratedSecurity=true;");

        Assert.assertTrue(sqlHandler.connectDatabase("jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=NetflixStatistics;integratedSecurity=true;") == true);

    }


}
