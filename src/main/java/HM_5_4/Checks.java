package HM_5_4;

import java.util.Map;
import java.util.Scanner;

import static HM_5_4.Utils.printPhoneBookEntryByKey;
import static HM_5_4.Utils.printPhoneBookEntryByValue;
import static HM_5_4.NewPhoneBookEntry.addNewNameWithPhoneToBook;
import static HM_5_4.NewPhoneBookEntry.addNewPhoneWithNameToBook;

public class Checks {

    static final String PHONE = "(8|\\+7|7)?([\\-]|[(]|([ ]?[(]))?(9)([0-9]{2})([\\-]|[ ]|([)][ ]?))?([0-9]{3})([\\-]|[ ])?([0-9]{2})([\\-]|[ ])?([0-9]{2})";
    static final String NAME = "[A-Za-zа-яёА-яЁ\\s]+";

    static boolean checkIfPhoneInMap(String input, Map<String, String> map) {
        return map.containsValue(input);
    }

    static boolean checkIfNameInMap(String input, Map<String, String> map) {
        return map.containsKey(input);
    }

    static boolean checkIfInputIsName(String input) {
        return input.matches(NAME);
    }

    static boolean checkIfInputIsPhone(String input) {
        return input.matches(PHONE);
    }

    static void checkNewPhone(String input, Map<String, String> map, Scanner scanner) {
        if (!checkIfPhoneInMap(input, map)) {
            addNewPhoneWithNameToBook(input, map, scanner);
        } else if (checkIfPhoneInMap(input, map)) {
            printPhoneBookEntryByValue(map, input);
        }
    }

    static void checkNewName(String input, Map<String, String> map, Scanner scanner) {
        if (!checkIfNameInMap(input, map)) {
            addNewNameWithPhoneToBook(input, map, scanner);
        } else if (checkIfNameInMap(input, map)) {
            printPhoneBookEntryByKey(map, input);
        }
    }
}

