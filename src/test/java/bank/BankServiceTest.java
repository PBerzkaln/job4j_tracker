package bank;

import org.junit.Test;

import java.time.temporal.Temporal;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankServiceTest {

    @Test
    public void addUser() {
        var user = new User("3434", "Petr Arsentev");
        var bank = new BankService();
        bank.addUser(user);
        assertThat(bank.findByPassport("3434"), is(Optional.of(user)));
    }

    @Test
    public void whenDelUserIsNotSuccessfully() {
        var user = new User("3434", "Petr Arsentev");
        var bank = new BankService();
        bank.addUser(user);
        bank.delUser(user.getPassport());
        assertThat(bank.findByPassport(user.getPassport()), is(Optional.empty()));
    }

    @Test
    public void delUserIsTrue() {
        var user = new User("3434", "Petr Arsentev");
        var bank = new BankService();
        bank.addUser(user);
        assertTrue(bank.delUser(user.getPassport()));
    }

    @Test
    public void whenEnterInvalidPassport() {
        var user = new User("3434", "Petr Arsentev");
        var bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("34", "5546"), is(Optional.empty()));
    }

    @Test
    public void addAccount() {
        var user = new User("3434", "Petr Arsentev");
        var bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("3434", "5546").get().getBalance(), is(150D));
    }

    @Test
    public void transferMoney() {
        var user = new User("3434", "Petr Arsentev");
        var bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D);
        assertThat(bank.findByRequisite(user.getPassport(), "113").get().getBalance(), is(200D));
    }
}