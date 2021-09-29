package regex;

import java.util.Scanner;

/*
Что нужно сделать
Реализуйте  удаление лишних символов при вводе номера телефона в консоли и проверку соответствия номера формату
мобильных номеров России. Если введённую строку нельзя привести к формату мобильного номера — выводите сообщение
о неверном вводе. Телефон может быть введен не только в формате 79091234567, но и с лишними символами.
Введенный номер телефона проверять с помощью регулярного выражения.
 */
public class task_regex {
    public static void main(String[] args) {
        String input = input();

        input = inputValidation(input);

    }

    static String input() {
        Scanner console = new Scanner(System.in);
        return console.nextLine();
    }

    static String inputValidation(String string) {
        String myRegex = "(8|\\+7)?([\\- ]?)(9)([0-9]{2})([\\- ]?)([0-9]{3})([\\- ]?)([0-9]{2})([\\- ]?)([0-9]{2})([\\- ]?)";
        string = string.replaceAll("[\\+\\-]", "");

        if (string.length() > 11 || string.length() < 10) {
            System.out.println("Неверный формат номера");
        } else if (string.matches(myRegex)) {


            if (string.length() != 11) {
                string = 7 + string;
            } else if (string.indexOf("8") == 0) {
                string = 7 + string.substring(1);
            }
            System.out.println(string);
        }
        return string;
    }
}
