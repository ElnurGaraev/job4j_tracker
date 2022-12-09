package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *Класс описывает модель банковской системы,
 *которая содержит списки пользователей с их счетами
 *
 * @author Garaev Elnur
 * @version 1.0
 */

public class BankService {

    /** Хранение счетов осуществляется в коллекции типа Account
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добовляет пользователя в хранилище которого нет в базе
     * @param user пользователь, который добавляется в хранилище
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод удаляет пользователя из системы
     * @param passport метод принимает паспортные данные для идентификации пользователя
     * @return метод возвращает true, если пользователь найден и удален,
     * либо вернет false если пользователь с указанным паспортом не существует
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, " ")) != null;
    }

    /**
     * Метод добавляет новый счет пользователю, если пользователь найден
     * и у него нет такого счета
     * @param passport метод принимает данные паспорта для идентификации пользователя
     * ме@param account в качестве второго аргумента метод принимает счет,
     * который добавляется в список счетов клиента
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accountUser = users.get(user);
            if (!accountUser.contains(account)) {
                accountUser.add(account);
            }
        }
    }

    /**
     * Метод ищет в хранилище пользователя по его паспортным данным
     * @param passport паспортные данные по которым ищят пользователя.
     * @return метод возвращяет пользователя если пользователь найден или значение null,
     * если пользователя нет
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод ищет пользователя в хранилище по паспортным данным и реквизитам пользователя
     * @param passport данные паспорта пользователя
     * @param requisite реквизиты счета
     * @return возвращает счет если найден в списке, либо null если счет не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account result = null;
        if (user != null) {
            List<Account> value = users.get(user);
            for (Account account : value) {
                if (account.getRequisite().equals(requisite)) {
                    result = account;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод осущевляет перевод с одного счета на другой
     * на осноании паспортных данных и реквизитов счетов пользователей
     * @param srcPassport паспортные данные пользователя с которого нужно перевести
     * @param srcRequisite реквизиты счета данные пользователя с которого делают перевод
     * @param destPassport паспортные даные другого пользователя
     * @param destRequisite реквизиты счета другого пользователя
     * @param amount сумма, которая переводится с одного счета на другой
     * @return возвращает true, если перевод состоялся, либо false если счет не найден
     * или недостаточно средств
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance((destAccount.getBalance() + amount));
            rsl = true;
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
