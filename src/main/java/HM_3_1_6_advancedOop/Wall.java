package HM_3_1_6_advancedOop;

import HM_3_1_5_enums_and_interfaces.Overcome;

public class Wall implements Overcome {

    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
