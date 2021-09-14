package HM_4_17.ExtraTask;

import java.util.Arrays;

import static HM_4_17.ExtraTask.CalculationOfHumanitarianAid.TRUCK_CAPACITY;

class Truck {
    int number;
    static int count = 0;

    public Truck() {
        count++;
        this.number = count;
    }

    public Container[] getArray() {
        return array;
    }

    private Container[] array = new Container[TRUCK_CAPACITY];


    @Override
    public String toString() {
        return "Грузовик " + number + ":" + "\n"
                + Arrays.toString(array).replace("[","").replace(",","")  + "\n";
    }
}
