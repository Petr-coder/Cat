package HM_5_1;

/*
1. Создайте массив из мнемонической фразы:
Каждый охотник желает знать, где сидит фазан.
2. Напишите код, который меняет порядок расположения элементов внутри массива на обратный. Массив должен остаться тот же

Пример
Первоначальный массив: [“a”, “b”, “c”, “d”].
Массив с элементами в обратном порядке: [“d”, “c”, “b”, “a”].
 */
public class task1 {
    public static void main(String[] args) {
        String mnemonicPhrase = "Каждый охотник желает знать, где сидит фазан.";
        String[] array = mnemonicPhrase.split(" ");


        String[] array2 = new String[]{"a", "b", "c", "d"};

        int size = array2.length;
        String temp;

        for (int i = 0; i < array2.length / 2; i++) {
            temp = array2[size - i - 1];
            array2[size - i - 1] = array2[i];
            array2[i] = temp;
        }

    }

}
