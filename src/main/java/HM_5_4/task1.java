package HM_5_4;

/*
Что нужно сделать
1. Напишите программу, которая будет работать как телефонная книга:
- Если пишем новое имя, программа просит ввести номер телефона и запоминает его.
- Если новый номер телефона — просит ввести имя и также запоминает.
- Если вводим существующее имя или номер телефона, программа выводит всю информацию о контакте.
- При вводе команды LIST программа печатает в консоль список всех абонентов в алфавитном порядке с номерами.
2. Определяйте имя и телефон с помощью регулярных выражений.
3. Подумайте, что выбрать в качестве ключа и значения для Map, выберите лучший вариант по вашему мнению.
Опишите, какие минусы и плюсы видите в вашем выборе.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static HM_5_4.NewPhoneBookEntry.keepAddingToPhoneBook;
import static HM_5_4.Utils.printsSubscribersInAlphabeticalOrder;

public class task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();
        map.put("Ivanov", "79991234567");
        map.put("Petrov", "79991234565");
        map.put("Sidorov", "79991234566");

        printsSubscribersInAlphabeticalOrder(map);
        keepAddingToPhoneBook(map, scanner);
        printsSubscribersInAlphabeticalOrder(map);
    }
}
