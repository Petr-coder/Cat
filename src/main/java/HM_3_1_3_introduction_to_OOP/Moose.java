package HM_3_1_3_introduction_to_OOP;

public class Moose extends Animal {
    static int mooseCount;
    private String name;
    public Moose(String name) {
        count++;
        super.maximumDistanceRun = 1000;
        super.maximumDistanceSwim = 500;
        mooseCount++;
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
