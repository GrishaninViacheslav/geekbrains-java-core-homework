package GeekBrians.Slava_5655380.Homework.Lesson10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

// ЗАДАНИЕ 2. Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
public class TeleDir {
    private HashMap<String, LinkedList<Long>> nameTeleMap = new HashMap<>();

    // В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер телефона по фамилии.
    // Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
    // тогда при запросе такой фамилии должны выводиться все телефоны.
    public void add(String surname, Long number) {

        LinkedList<Long> numbers = nameTeleMap.get(surname);
        if (numbers == null) {
            numbers = new LinkedList<Long>();
            numbers.add(number);
            nameTeleMap.put(surname, numbers);
        } else
            numbers.add(number);
    }

    public LinkedList<Long> get(String surname) {
        return nameTeleMap.get(surname);
    }

    public Iterator<Map.Entry<String, LinkedList<Long>>> iterator() {
        return nameTeleMap.entrySet().iterator();
    }
}
