package HM_5_4;

import java.util.Map;
import java.util.Scanner;

import static HM_5_4.Checks.*;
import static HM_5_4.Utils.convertPhoneToCorrectFormat;
import static HM_5_4.Utils.printsSubscribersInAlphabeticalOrder;

public class NewPhoneBookEntry {

    static void addNewNameWithPhoneToBook(String input, Map<String, String> map, Scanner scanner) {
        System.out.println("It is a new name. Please enter phone to add it to the phone book. " +
                "Expected format - 79991234567");
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
    }

    static void addNewPhoneWithNameToBook(String input, Map<String, String> map, Scanner scanner) {
        System.out.println("It is a new phone number. Please enter name to add it to the phone book");
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
    }

    static void keepAddingToPhoneBook(Map<String, String> map, Scanner scanner) {

        while (true) {
            String input = input(scanner);

            if (input.matches("stop")) {
                break;

            } else if (input.matches("LIST")) {
                printsSubscribersInAlphabeticalOrder(map);

            } else if (checkIfInputIsPhone(input)) {
                input = convertPhoneToCorrectFormat(input);
                checkNewPhone(input, map, scanner);

            } else if (checkIfInputIsName(input)) {
                checkNewName(input, map, scanner);

            } else {
                System.out.println("Input incorrect. Please try again");
            }
        }
    }

    static String input(Scanner scanner) {
        System.out.println("Wanna stop loop? Type \"stop\"");
        String input = scanner.nextLine();
        //здесь не уверен, что сбоя не будет, если напишу
        //return scanner.nextLine();
        return input;
    }
}
