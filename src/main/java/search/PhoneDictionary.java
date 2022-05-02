package search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Возвращает список всех пользователей, которые содержат key в любых полях.
     * @param key ключ поиска.
     * @return Список подошедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        Predicate<Person> byPhone = (i) -> i.getPhone().contains(key);
        Predicate<Person> byAddress = (i) -> i.getAddress().contains(key);
        Predicate<Person> byName = (i) -> i.getName().contains(key);
        Predicate<Person> bySurname = (i) -> i.getSurname().contains(key);
        Predicate<Person> combine = byPhone.or(byAddress).or(byName).or(bySurname);
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}