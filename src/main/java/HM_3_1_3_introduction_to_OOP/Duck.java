package HM_3_1_3_introduction_to_OOP;

public class Duck extends Animal {
    private String name;
    static int duckCount;

    Duck(String name) {
        super.maximumDistanceRun = 100;
        super.maximumDistanceSwim = 10000;
        count++;
        duckCount++;
        this.name = name;
    }

    @Override
    void run(double distance) {
        if (distance < maximumDistanceRun) {
            System.out.println(name + " пробежал " + distance + " метров");
        } else {
            System.out.println(name + " столько не пробежит");
        }

    }

    @Override
    void swim(double distance) {
        if (distance < maximumDistanceSwim) {
            System.out.println(name + " проплыл " + distance + " метров");
        } else {
            System.out.println(name + " столько не проплывет");
        }
    }
}
