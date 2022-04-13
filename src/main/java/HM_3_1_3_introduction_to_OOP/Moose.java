package HM_3_1_3_introduction_to_OOP;

public class Moose extends Animal {
    private static int mooseCount;
    private String name;

    public Moose(String name) {
        setMaximumDistanceRun(1000);
        setMaximumDistanceSwim(500);
        setCount(getCount() + 1);
        mooseCount++;
        this.name = name;
    }

    public static int getMooseCount() {
        return mooseCount;
    }

    public static void setMooseCount(int mooseCount) {
        Moose.mooseCount = mooseCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run(double distance) {
        if (distance < getMaximumDistanceRun()) {
            System.out.println(name + " пробежал " + distance + " метров");
        } else {
            System.out.println(name + " столько не пробежит");
        }

    }

    @Override
    public void swim(double distance) {
        if (distance < getMaximumDistanceSwim()) {
            System.out.println(name + " проплыл " + distance + " метров");
        } else {
            System.out.println(name + " столько не проплывет");
        }
    }

}
