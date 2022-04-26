package bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу хранилища банковских счетов пользователей
 * @author PAVEL BERZKALN
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение перечня пользователей и их банковских счетов
     * осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход объект User (пользователя),
     * далее проверяется наличие User (ключа) в Map (хранилище).
     * Если ключа нет, то добавляет в Map связанную пару User - новый Account (банковский счет)
     * @param user проверочный ключ
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод принимает на вход строку passport (паспортные данные пользователя),
     * далее проверяется наличие User (пользователея) в Map (хранилище) по параметру passport.
     * Если User найден (ключ != null), то он удаляется из Map.
     * Если User в Map не найден, то возвращается false.
     * @param passport паспортные данные пользователя
     * @return возвращает true или false (результат попытки удалить пользователя)
     */
    public boolean delUser(String passport) {
        boolean rsl = false;
        User user = findByPassport(passport);
        if (user != null) {
            users.remove(user);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод принимает на вход строку passport и объект account .
     * Далее проверяет наличие User (пользователя) в Map (хранилище) по параметру passport.
     * Если User в Map найден, то в переменную value типа List извлекается User,
     * затем по value проверяется наличие связанного с ним account.
     * Если соответствующего связанного account нет, то к он привязывается к value (содержащему User).
     * @param passport паспортные данные пользователя
     * @param account банковский счет
     */
    public void addAccount(String passport, Account account) {
       User user = findByPassport(passport);
       if (user != null) {
           List<Account> value = users.get(user);
           if (!value.contains(account)) {
               value.add(account);
           }
        }
    }

    /**
     * Метод принимает на вход сроку passport.
     * Далее в объект key типа User циклом из Map (хранилища) выгружаются User (перечень пользователей).
     * Затем key гетером по полю passport (паспортные данные пользователя) сравнивается поочередно
     * с принятым на вход passport.
     * Если результат сравнения true, то возвращается key.
     * Если результат сравнения false, то возвращается null.
     * @param passport паспортные данные пользователя
     * @return возвращает User из Map
     */
    public User findByPassport(String passport) {
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                return key;
            }
        }
        return null;
    }

    /**
     * Метод принимает на вход строку passport и строку requisite (поле реквизиты банковского счета).
     * Далее в объект user методом {@link #findByPassport(String passport)}
     * записывается User (пользоваель) из Map (хранилища).
     * Затем в переменую account в цикле передается user и потом
     * account с помощью гетера поля requisite сравнивается с принятым на вход.
     * Если результат сравнения true, то возвращается account.
     * Если результат сравнения false, то возвращается null.
     * @param passport паспортные данные пользователя
     * @param requisite реквизиты банковского счета
     * @return возвращает true или false (результат попытки найти account)
     */
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

    /**
     * Метод принимает на вход строки scrPassport, scrRequisite, destPassport,
     * destRequisite, amount.
     * Далее в объекты accountScr, accountDest методом {@link #findByRequisite(String passport, String requisite)}
     * передаются account (банковские счета) донора и реципиента.
     * Затем account проверяюттся на null и баланс account донора проверяется на наличие средств >= размера перевода.
     * Если проверка true, то accountScr сетером поля баланс присваивается значение getBalance - amount.
     * а accountDest присваивается значение getBalance + amount.
     * @param srcPassport паспортные данные донора
     * @param srcRequisite реквизиты банковского счета донора
     * @param destPassport паспортные данные реципиента
     * @param destRequisite реквизиты банковского счета реципиента
     * @param amount размер денежного перевода
     * @return возвращает true или false (результат попытки присвоить изменить баланс банковских счетов)
     */
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
