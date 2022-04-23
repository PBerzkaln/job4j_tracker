package bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public boolean delUser(String passport) {
        boolean rsl = false;
        User user = findByPassport(passport);
        if (user != null) {
            users.remove(user);
            rsl = true;
        }
        return rsl;
    }

    public void addAccount(String passport, Account account) {
       User user = findByPassport(passport);
       List<Account> value = users.get(user);
       if (!value.contains(account)) {
           value.add(account);
           users.put(user, value);
        }
    }

    public User findByPassport(String passport) {
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                return key;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account accountScr = findByRequisite(srcPassport, srcRequisite);
        Account accountDest = findByRequisite(destPassport, destRequisite);
        if (accountScr != null && accountDest != null && accountScr.getBalance() >= amount) {
            accountScr.setBalance(accountScr.getBalance() - amount);
            accountDest.setBalance(accountDest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
