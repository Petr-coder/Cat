package HM_3_1_6_advancedOop;

public class Cat implements Activity {

    private int jumpLimit;
    private int runLimit;

    public Cat(int jumpLimit, int runLimit) {
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
            throw new IllegalArgumentException();

        if (this.jumpLimit >= wall.getHeight()) {
            System.out.println("Кот прыгнул на " + wall.getHeight());
            result = true;
        } else if (this.jumpLimit < wall.getHeight()) {
            System.out.println("Кот не смог перепрыгнуть");
        }
        return result;
    }

    @Override
    public boolean run(Treadmill treadmill) {
        boolean result = false;
        if (treadmill.getLength() < 0)
            throw new IllegalArgumentException();

        if (this.runLimit >= treadmill.getLength()) {
            System.out.println("Кот пробежал " + treadmill.getLength());
            result = true;
        } else if (this.runLimit < treadmill.getLength()) {
            System.out.println("Кот не смог пробежать");
        }
        return result;
    }

}
