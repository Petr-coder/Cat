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
        String input = "8-999-364";
        boolean result = input.matches("^((\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
        System.out.println(result);
    }

    static String input() {
        Scanner console = new Scanner(System.in);
        return console.nextLine();
    }

    static void inputValidation(String string) {
        String regex = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";

        if (string.matches(regex)) {

        }

    }
}
