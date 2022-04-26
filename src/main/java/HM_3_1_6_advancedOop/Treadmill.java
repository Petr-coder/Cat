package HM_3_1_6_advancedOop;

import HM_3_1_5_enums_and_interfaces.Overcome;

public class Treadmill implements Overcome {

    private int length;

    public Treadmill(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
