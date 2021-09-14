package HM_4_17.ExtraTask;

import java.util.Arrays;

import static HM_4_17.ExtraTask.CalculationOfHumanitarianAid.CONTAINER_CAPACITY;

class Container {
    int number;
    static int count = 0;

    public Container() {
        count++;
        this.number = count;
    }

    private Box[] array = new Box[CONTAINER_CAPACITY];

    public Box[] getArray() {
        return array;
    }

    @Override
    public String toString() {
        return "Контейнер " + number + ":" + "\n"
                + Arrays.toString(array).replace("[","").replace(",","") + "\n";
    }
}