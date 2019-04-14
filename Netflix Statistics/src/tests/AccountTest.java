package tests;
import Domain.Account;
import Repositories.AccountRepository;
import org.junit.Assert;
import  org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import javax.swing.table.TableModel;
import java.util.ArrayList;

public class AccountTest {
    AccountRepository accountRepository = new AccountRepository();
    @DisplayName("Shows a non valid Account")
    @Test
    public void testGetAccount() throws Exception{
        ArrayList <String> names = new ArrayList<>();
        names = accountRepository.getAccountNames();
        ArrayList<String>accounts = new ArrayList<>();
        for (String s : names){
            accounts.add(s);
        }
        String acc = accounts.toString();

        Assert.assertFalse(acc == "Niks");

    }


}
