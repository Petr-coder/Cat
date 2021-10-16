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

public class task1 {

    static final String PHONE = "(8|\\+7|7)?([\\-]|[(]|([ ]?[(]))?(9)([0-9]{2})([\\-]|[ ]|([)][ ]?))?([0-9]{3})([\\-]|[ ])?([0-9]{2})([\\-]|[ ])?([0-9]{2})";
    static final String NAME = "[A-Za-zа-яёА-яЁ\\s]+";

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Ivanov", "79991234567");
        map.put("Petrov", "79991234565");
        map.put("Sidorov", "79991234566");


        printsSubscribersInAlphabeticalOrder(map);

        keepAddingToPhoneBook(map);
        printsSubscribersInAlphabeticalOrder(map);
    }

    static void keepAddingToPhoneBook(Map<String, String> map) {

        while (true) {
            String input = input();

            if (input.matches("stop")) {
                break;

            } else if (input.matches("LIST")) {
                printsSubscribersInAlphabeticalOrder(map);

            } else if (checkIfInputIsPhone(input)) {
                input = convertPhoneToCorrectFormat(input);

                if (!checkIfPhoneInMap(input, map)) {
                    addNewPhoneWithNameToBook(input, map);
                } else if (checkIfPhoneInMap(input, map)) {
                    printPhoneBookEntryByValue(map, input);
                }

            } else if (checkIfInputIsName(input)) {
                if (!checkIfNameInMap(input, map)) {
                    addNewNameWithPhoneToBook(input, map);
                } else if (checkIfNameInMap(input, map)) {
                    printPhoneBookEntryByKey(map, input);
                }

            } else {
                System.out.println("Input incorrect. Please try again");
            }
        }
    }


    static String input() {
        System.out.println("Wanna stop loop? Type \"stop\"");
        Scanner scanner = new Scanner(System.in);
        String input;

        input = scanner.nextLine();

        return input;
    }

    static boolean checkIfInputIsPhone(String input) {
        if (input.matches(PHONE)) {
            return true;
        } else {
            return false;
        }
    }

    static boolean checkIfInputIsName(String input) {
        if (input.matches(NAME)) {
            return true;
        } else
            return false;
    }

    static boolean checkIfNameInMap(String input, Map<String, String> map) {
        if (map.containsKey(input)) {
            return true;
        } else {
            return false;
        }
    }

    static boolean checkIfPhoneInMap(String input, Map<String, String> map) {
        if (map.containsValue(input)) {
            return true;
        } else {
            return false;
        }
    }

    static String convertPhoneToCorrectFormat(String input) {
        input = input.replaceAll("[^\\d]", "");
        if (input.length() != 11) {
            input = 7 + input;
        } else if (input.indexOf("8") == 0) {
            input = 7 + input.substring(1);
        }
        return input;
    }

    static void addNewPhoneWithNameToBook(String input, Map<String, String> map) {
        System.out.println("It is a new phone number. Please enter name to add it to the phone book");
        Scanner scanner = new Scanner(System.in);
        String name;

        while (true) {
            name = scanner.nextLine().trim();
            if (checkIfInputIsName(name)) {
                if (checkIfNameInMap(name, map)) {
                    System.out.println("The name is already in the phone book. Please choose another name");
                } else {
                    break;
                }
            } else {
                System.out.println("Input incorrect. Please enter name");
            }
        }
        map.put(name, input);

        System.out.println("Phone Book Entry has been written");
        printPhoneBookEntryByValue(map, name);
    }

    static void addNewNameWithPhoneToBook(String input, Map<String, String> map) {
        System.out.println("It is a new name. Please enter phone to add it to the phone book. " +
                "Expected format - 79991234567");
        Scanner scanner = new Scanner(System.in);
        String phone;

        while (true) {
            phone = scanner.nextLine().trim();

            if (checkIfInputIsPhone(phone)) {
                if (checkIfPhoneInMap(phone, map)) {
                    System.out.println("The number is already in the phone book. Please choose another number");
                } else {
                    phone = convertPhoneToCorrectFormat(phone);

                    break;
                }
            } else {
                System.out.println("Input incorrect. Please enter phone number");
            }
        }

        map.put(input, phone);
        System.out.println("Phone Book Entry has been written");
        printPhoneBookEntryByKey(map, phone);
    }

    static void printsSubscribersInAlphabeticalOrder(Map<String, String> map) {
        map.entrySet().stream()
                .sorted(Map.Entry.<String, String>comparingByKey())
                .forEach(System.out::println);
    }

    static void printPhoneBookEntryByValue(Map<String, String> map, String input) {

        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue().equals(input)) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }

    static void printPhoneBookEntryByKey(Map<String, String> map, String input) {

        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey().equals(input)) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
}
