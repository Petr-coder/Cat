package HM_4_17.ExtraTask;


import java.util.ArrayList;
import java.util.List;

/*
*
*
Цель задания:
Закрепить пройденные темы: арифметические операции, циклы, условные операторы, константы.
Что нужно сделать:
Вы доставляете гуманитарную помощь в ящиках одинакового размера. У вас есть грузовики и контейнеры.
В каждый грузовик помещается максимум 12 контейнеров.
В каждый контейнер — не более 27 ящиков.
Ящики, контейнеры и грузовики пронумерованы.
Напишите программу, которая распределит ящики по контейнерам и грузовикам в зависимости от их количества.
Программа должна выводить необходимое для этого число грузовиков и контейнеров.
*/

public class CalculationOfHumanitarianAid {

    static final int TRUCK_CAPACITY = 12;
    static final int CONTAINER_CAPACITY = 27;

    public static void main(String[] args) {
        int numberOfBoxes = 325;
        List<Box> boxes = createRequairedBoxes(numberOfBoxes);
        List<Container> containers = createRequairedContainers(countRequairedContainers(numberOfBoxes));
        List<Truck> trucks = createHumanitarianAidConvoy(countRequairedTrucks(numberOfBoxes));
        fillContainersWithBoxes(boxes, containers);
        fillTrucksWithContainers(containers, trucks);

        for (Truck truck : trucks) {
            System.out.println(truck);
        }

        System.out.println("Необходимо:\n" +
                "грузовиков — " + countRequairedTrucks(numberOfBoxes) + " шт.\n" +
                "контейнеров — " + countRequairedContainers(numberOfBoxes) + " шт.\n");
    }

    private static List<Truck> createHumanitarianAidConvoy(int number) {

        List<Truck> list = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            list.add(new Truck());
        }

        return list;
    }

    private static void fillTrucksWithContainers(List<Container> containerList, List<Truck> truckList) {
        int quantityOfContainers = containerList.size();
        int numberOfContainer = 0;

        for (int i = 0; i < truckList.size(); i++) {

            for (int k = 0; k < TRUCK_CAPACITY; k++) {
                if (numberOfContainer == quantityOfContainers)
                    break;

                truckList.get(i).getArray()[k] = containerList.get(numberOfContainer);
                numberOfContainer++;
            }
        }
    }


    private static void fillContainersWithBoxes(List<Box> boxList, List<Container> containerList) {
        int quantityOfBoxes = boxList.size();
        int numberOfBoxes = 0;

        for (int i = 0; i < containerList.size(); i++) {

            for (int k = 0; k < CONTAINER_CAPACITY; k++) {
                if (numberOfBoxes == quantityOfBoxes)
                    break;
                containerList.get(i).getArray()[k] = boxList.get(numberOfBoxes);
                numberOfBoxes++;
            }

        }
    }

    private static List<Box> createRequairedBoxes(int number) {
        List<Box> list = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            list.add(new Box());
        }
        return list;
    }

    private static List<Container> createRequairedContainers(int number) {
        List<Container> list = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            list.add(new Container());
        }
        return list;
    }

    private static int countRequairedTrucks(int numberOfBoxes) {
        int numberOfContainers = countRequairedContainers(numberOfBoxes);
        double result = (double) numberOfContainers / TRUCK_CAPACITY;

        if (result == (int) result) {
            return (int) result;
        } else {
            return (int) result + 1;
        }
    }

    private static int countRequairedContainers(int numberOfBoxes) {
        double result = 0;

        if (numberOfBoxes > 0) {
            result = (double) numberOfBoxes / CONTAINER_CAPACITY;

            if (result == (int) result) {
                result = (int) result;
            } else {
                result = (int) result + 1;
            }
        }
        return (int) result;
    }
}

