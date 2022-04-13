package HM_3_1_3_introduction_to_OOP;

public class Duck extends Animal {
    private String name;
    private static int duckCount;

    public Duck(String name) {
        setMaximumDistanceRun(100);
        setMaximumDistanceSwim(10000);
        setCount(getCount() + 1);
        duckCount++;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getDuckCount() {
        return duckCount;
    }

    public static void setDuckCount(int duckCount) {
        Duck.duckCount = duckCount;
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
