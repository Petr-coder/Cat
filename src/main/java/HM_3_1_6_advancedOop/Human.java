package HM_3_1_6_advancedOop;

public class Human implements Activity {

    private int jumpLimit;
    private int runLimit;

    public Human(int jumpLimit, int runLimit) {
        this.jumpLimit = jumpLimit;
        this.runLimit = runLimit;
    }

    public int getJumpLimit() {
        return jumpLimit;
    }

    public void setJumpLimit(int jumpLimit) {
        this.jumpLimit = jumpLimit;
    }

    public int getRunLimit() {
        return runLimit;
    }

    public void setRunLimit(int runLimit) {
        this.runLimit = runLimit;
    }

    @Override
    public boolean jump(Wall wall) {
        boolean result = false;

        if (wall.getHeight() < 0)
            throw new IllegalArgumentException("Высота стены должна быть больше нуля");

        if (this.jumpLimit >= wall.getHeight()) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean run(Treadmill treadmill) {
        boolean result = false;
        if (treadmill.getLength() < 0)
            throw new IllegalArgumentException("Длина трассы должна быть больше нуля");

        if (this.runLimit >= treadmill.getLength()) {
            result = true;
        }
        return result;
    }

    @Override
    public String toString() {
        return "Human[" + "jumpLimit = " + jumpLimit +
                ", runLimit = " + runLimit +
                ']';
    }
}
