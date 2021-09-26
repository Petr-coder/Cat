package StringExperiments;

import java.util.Scanner;

/*
Напишите программу, которая на входе через консоль принимает фамилию, имя и отчество одной строкой
(например, «Иванов Сергей Петрович») и выводит фамилию, имя и отчество отдельно в формате:
Фамилия: Иванов
Имя: Сергей
Отчество: Петрович
 */
public class task3 {

    public static void main(String[] args) {
        readConsole();
    }

    static void readConsole() {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine().trim();
        int index = input.indexOf(" ");
        int index2 = input.lastIndexOf(" ");


        String lastName = input.substring(0, index);
        String firstName = input.substring(index, index2).trim();
        String middleName = input.substring(index2).trim();


        System.out.println("Фамилия: " + lastName);
        System.out.println("Имя: " + firstName);
        System.out.println("Отчество: " + middleName);
    }
}
