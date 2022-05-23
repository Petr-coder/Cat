package HM_3_2_1;

import static HM_3_2_1.Calculation.calculateAmount;

/*
Практическое задание
1. Создайте исключения: MyArraySizeException (неправильный размер массива), и MyArrayDataException
(в ячейке массива лежит что-то не то);
2. Напишите метод, на вход которого подаётся двумерный строковый массив (String[][]) размером 4×4.
При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
3. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
Расчет данных для этой матрицы прекращается.
4. В методе main() нужно вызвать полученный метод, обработать возможные исключения MySizeArrayException и
MyArrayDataException и вывести результат расчёта.
 */
public class Task {
    public static void main(String[] args) {
        String[][] array = {{"1", "2", "2", "0"}, {"1", "2", "2", "1"}, {"1", "2", "2", "2"}, {"1", "2", "2","3"}};

        calculateAmount(array);
    }


}

class Calculation {

    static void checkArray(String[][] array) {
        if (array.length != 4) {
            throw new MyArraySizeException("The size of the two-dimensional array must be 4*4. " +
                    "Actual row amount is " + array.length);
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("The size of the two-dimensional array must be 4. " +
                        "Length of row #" + i + " is " + array[i].length);
            }
        }
    }

    static void calculateAmount(String[][] array) {
        checkArray(array);
        int amount = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    amount += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("The field array[" + i + "][" + j + "] must contain a number, " +
                            "instead of \"" + array[i][j] + "\"");
                }
            }
        }
        System.out.println(amount);
    }
}
