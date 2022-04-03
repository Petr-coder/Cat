package HM_3_1_3_introduction_to_OOP;

public class DomesticCat extends Animal {
    static int domesticCatCount;
    private String name;

    DomesticCat(String name) {
        super.maximumDistanceRun = 200;
        super.maximumDistanceSwim = 0;
        count++;
        domesticCatCount++;
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
        System.out.println(name + " не плавает");
    }
}
