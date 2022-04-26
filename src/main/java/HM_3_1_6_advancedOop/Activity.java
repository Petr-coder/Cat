package HM_3_1_6_advancedOop;

import HM_3_1_5_enums_and_interfaces.Overcome;

public interface Activity {

    boolean jump(Wall wall);

    boolean run(Treadmill treadmill);

    default boolean goThrough(Overcome overcome) {
        boolean result=false;
        if (overcome instanceof Wall)
            result = jump((Wall) overcome);
        else if (overcome instanceof Treadmill)
            result = run((Treadmill) overcome);
        return result;
    }
}
