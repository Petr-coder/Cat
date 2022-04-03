package HM_3_1_3_introduction_to_OOP;

public class Tiger extends Animal {

    static int tigerCount;
    private String name;

    Tiger(String name) {
        super.maximumDistanceRun = 500;
        super.maximumDistanceSwim = 300;
        count++;
        tigerCount++;
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
