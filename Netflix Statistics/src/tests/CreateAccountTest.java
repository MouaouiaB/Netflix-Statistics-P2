package tests;
import Domain.Account;
import Repositories.AccountRepository;
import org.junit.Assert;
import  org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import javax.swing.table.TableModel;
import java.util.ArrayList;

public class CreateAccountTest {

    AccountRepository accountRepository = new AccountRepository();
    @DisplayName("Create new Account")
    @Test
    public void testGetAccount() throws Exception{
        Account account = new Account("TestAccount", "TestName", "Test@hotmail.com", "TestPassword", "Street", "22A" ,
                "4707JA", "Roosendaal");

        String s = account.getAccountName();

        Assert.assertTrue(s == "TestAccount");

    }
}
