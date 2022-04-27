package HM_3_1_6_advancedOop;

public class Treadmill implements OvercomeObstacle {

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

    @Override
    public boolean interact(Activity activity) {
        return activity.run(this);
    }
}
