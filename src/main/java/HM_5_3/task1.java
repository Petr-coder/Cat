package HM_5_3;

import java.util.Scanner;
import java.util.TreeSet;

/*
Что нужно сделать
Напишите программу, в которой будет храниться перечень адресов электронной почты.
Адреса можно добавлять через консоль командой ADD и печатать весь список командой LIST.
Программа должна проверять корректность вводимых email’ов и печатать сообщение об ошибке при необходимости.
Принцип работы команд:
LIST — выводит список электронных адресов.
ADD — проверяет и, если формат адреса верный, добавляет в множество.
 */
public class task1 {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        inputEmail(treeSet);
    }

    static void inputEmail(TreeSet<String> treeSet) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wanna stop loop? Type \"stop\"");

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();

            if (input.matches(".*?\\bLIST\\b.*?")) {
                printTreeSet(treeSet);

            } else if (input.matches("ADD[\\s]+\\w+.*@*")) {
                input = getRidOfADD(input);
                addEmailIfCorrect(input, treeSet);

            } else if (input.matches("stop")) {
                break;

            } else {
                System.out.println("Incorrect input");
            }

        }
    }

    static void addEmailIfCorrect(String input, TreeSet<String> treeSet) {
        String emailRegex = "\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}";

        if (input.matches(emailRegex)) {
            treeSet.add(input);
        } else {
            System.out.println("Invalid email");
        }
    }

    static void printTreeSet(TreeSet<String> treeSet) {
        if (treeSet.isEmpty()) {
            System.out.println("TreeSet is empty. There is nothing to print");
        } else {
            for (String string : treeSet) {
                System.out.println(string);
            }
        }
    }

    static String getRidOfADD(String input) {
        int index = input.indexOf(" ");
        return input.substring(index).trim();
    }
}
