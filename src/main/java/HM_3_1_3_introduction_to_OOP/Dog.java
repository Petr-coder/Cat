package HM_3_1_3_introduction_to_OOP;

public class Dog extends Animal {
    private static int dogCount;
    private String name;

    public Dog(String name) {
        setMaximumDistanceRun(500);
        setMaximumDistanceSwim(10);
        setCount(getCount() + 1);
        dogCount++;
        this.name = name;
    }

    public static int getDogCount() {
        return dogCount;
    }

    public static void setDogCount(int dogCount) {
        Dog.dogCount = dogCount;
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
