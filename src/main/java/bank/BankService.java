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

    public void delUser(String passport) {
        User key = findByPassport(passport);
        users.remove(key);
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
        if (findByPassport(passport) != null) {
            for (Account account : users.get(findByPassport(passport))) {
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
        if (findByRequisite(srcPassport, srcRequisite) != null
                && findByRequisite(srcPassport, srcRequisite).getBalance() >= amount) {
            Account accountScr = findByRequisite(srcPassport, srcRequisite);
            Account accountDest = findByRequisite(destPassport, destRequisite);
            accountScr.setBalance(accountScr.getBalance() - amount);
            accountDest.setBalance(accountDest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
