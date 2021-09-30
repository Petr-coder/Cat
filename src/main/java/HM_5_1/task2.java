package HM_5_1;

/*
Что нужно сделать
Создайте массив типа float с температурами 30 пациентов (от 32 до 40 градусов).

Напишите код, который выводит среднюю температуру по больнице и количество здоровых пациентов
(с температурой от 36,2 до 36,9), а также температуры всех пациентов.

Вынесите в константы условия задания:
- количество пациентов,
- минимальная и максимальная температура пациентов,
- минимальная и максимальная температура диапазона здоровых пациентов.

Пример
Температуры пациентов: 36.7 38.9 34.7
Средняя температура: 36.76
Количество здоровых: 1
 */


import java.util.Random;

public class task2 {

    static final int PATIENT_NUMBER = 30;

    static final float MINIMUM_TEMPERATURE = 32f;
    static final float MAXIMUM_TEMPERATURE = 40f;

    static final float MINIMUM_HEALTHY_TEMPERATURE = 36.2f;
    static final float MAXIMUM_HEALTHY_TEMPERATURE = 36.9f;

    public static void main(String[] args) {
        float[] array = createAndfillArray(PATIENT_NUMBER);
        printInfoAboutPatients(array);
    }

    static float[] createAndfillArray(int number) {
        float[] array = new float[number];

        for (int i = 0; i < array.length; i++) {
            array[i] = generateNumber(MINIMUM_TEMPERATURE, MAXIMUM_TEMPERATURE);
        }

        return array;
    }

    static float generateNumber(float min, float max) {
        return min + new Random().nextFloat() * (max - min);
    }

    static void printInfoAboutPatients(float[] array) {
        printEveryPatientTemperature(array);
        printAverageTemperatureOfPatients(array);
        printQuantityOfHealthyPatients(array);
    }

    static void printAverageTemperatureOfPatients(float[] array) {
        float sumOfTemperature = 0;

        for (int i = 0; i < array.length; i++) {
            sumOfTemperature += array[i];
        }

        System.out.print("Средняя температура: ");
        System.out.printf("%.2f", sumOfTemperature / PATIENT_NUMBER);
    }

    static void printQuantityOfHealthyPatients(float[] array) {
        int numberOfTheHealthy = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] >= MINIMUM_HEALTHY_TEMPERATURE && array[i] <= MAXIMUM_HEALTHY_TEMPERATURE) {
                numberOfTheHealthy++;
            }
        }
        System.out.println("\n"+"Количество здоровых: " + numberOfTheHealthy);
    }

    static void printEveryPatientTemperature(float[] array) {
        System.out.print("Температуры пациентов: ");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%.2f", array[i]);
            System.out.print(" ");
        }
        System.out.println("");
    }
}

