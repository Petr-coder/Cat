package part3.HM_3_1_3_introduction_to_OOP;

public class Tiger extends Animal {

    private String name;
    private static int tigerCount;

    public Tiger(String name) {
        setMaximumDistanceRun(500);
        setMaximumDistanceSwim(300);
        setCount(getCount() + 1);
        tigerCount++;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getTigerCount() {
        return tigerCount;
    }

    public static void setTigerCount(int tigerCount) {
        Tiger.tigerCount = tigerCount;
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
