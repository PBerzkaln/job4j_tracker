package bank;

import java.util.*;

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
        users.putIfAbsent(user, new ArrayList<>());
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
        var rsl = false;
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            users.remove(user.get());
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
       Optional<User> user = findByPassport(passport);
       if (user.isPresent()) {
           List<Account> value = users.get(user.get());
           if (!value.contains(account)) {
               value.add(account);
           }
        }
    }

    /**
     * Метод принимает на вход строку passport.
     * Далее разворачивает ключи в stream и фильтрует их по аргументу passport.
     * @param passport паспортные данные пользователя
     * @return возвращает User из Map
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(p -> p.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод принимает на вход строку passport и строку requisite.
     * Далее через метод {@link #findByPassport(String passport)} ищет user.
     * Если user != 0, то разворачивает account в stream, затем фильтрует их
     * по аргументу requisite.
     * @param passport паспортные данные пользователя
     * @param requisite реквизиты банковского счета
     * @return возвращает account или null
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.flatMap(value -> users.get(value)
                .stream()
                .filter(account -> account.getRequisite().equals(requisite))
                .findFirst());
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
        var rsl = false;
        Optional<Account> accountScr = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> accountDest = findByRequisite(destPassport, destRequisite);
        if (accountScr.isPresent() && accountDest.isPresent() && accountScr.get().getBalance() >= amount) {
            accountScr.get().setBalance(accountScr.get().getBalance() - amount);
            accountDest.get().setBalance(accountDest.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}