package HM_5_4;

import java.util.Map;

public class Utils {
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

    static String convertPhoneToCorrectFormat(String input) {
        input = input.replaceAll("[^\\d]", "");
        if (input.length() != 11) {
            input = 7 + input;
        } else if (input.indexOf("8") == 0) {
            input = 7 + input.substring(1);
        }
        return input;
    }
}
