package H_M_5_2;

import java.util.ArrayList;
import java.util.Scanner;

/*
Что нужно сделать
Разработайте список дел, который управляется командами в консоли. Команды: LIST, ADD, EDIT, DELETE.
Рекомендуется использовать регулярные выражения.
Принцип работы команд:
- LIST — выводит дела с их порядковыми номерами;
- ADD — добавляет дело в конец списка или дело на определённое место, сдвигая остальные дела вперёд, если указать номер;
- EDIT — заменяет дело с указанным номером;
- DELETE — удаляет.
Примеры команд
- LIST
- ADD Какое-то дело
- ADD 4 Какое-то дело на четвёртом месте
- EDIT 3 Новое название дела
- DELETE 7
Команды вводятся одной строкой пользователем в консоль.
*/
public class task1 {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("asfdasfd");
        arrayList.add("sdfsdf");
        input(arrayList);

    }

    static void input(ArrayList<String> arrayList) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wanna stop it? Type \"stop\"");

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();

            if (input.matches(".*?\\bLIST\\b.*?")) {

                printArrayListWithNumbers(arrayList);
            } else if (input.matches("ADD[\\s]+[A-Za-zа-яёА-яЁ\\s+_.\\-+@.+]+")) {

                String input2 = input.replaceAll(".*?\\bADD\\b.*?", "").trim();
                arrayList.add(input2);

            } else if (input.matches("ADD[\\s]+[0-9]+[\\s]+[A-Za-zа-яёА-яЁ0-9\\s+_.\\-+@.]+")) {

                int index = getIndexToInsertIntoArray(input);
                String task = getTextToAddIntoArray(input);
                arrayList.add(index, task);

            } else if (input.matches("EDIT[\\s]+[0-9]+[\\s]+[A-Za-zа-яёА-яЁ0-9\\s]+")) {

                int index = getIndexToInsertIntoArray(input);
                String task = getTextToAddIntoArray(input);
                arrayList.set(index, task);

            } else if (input.matches(".*?\\bDELETE\\b.*?[\\s]+[0-9]+")) {
                int index = Integer.parseInt(input.replaceAll("[^\\d]", "").trim());
                arrayList.remove(index);
            } else if (input.matches("stop")) {

                printArrayListWithNumbers(arrayList);
                break;
            }

        }
    }

    static void printArrayListWithNumbers(ArrayList<String> arrayList) {
        for (int i = 0; i < arrayList.size(); i++)
            System.out.println("№ " + i + ": " + arrayList.get(i));
    }

    static int getIndexToInsertIntoArray(String input) {
        input = input.replaceAll("[a-zA-ZА-ЯЁа-яё+_.\\-+@.]", "").trim();
        String[] array = input.split("[\\s]+");

        return Integer.parseInt(array[0].trim());
    }

    static String getTextToAddIntoArray(String input) {
        String TextTask = input.replaceAll("([ADD]|[EDIT])[\\s]+", "");
        int indexOfTaskInText = TextTask.indexOf(" ");
        return TextTask.substring(indexOfTaskInText).trim();
    }
}