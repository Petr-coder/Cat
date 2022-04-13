package HM_3_1_3_introduction_to_OOP;

public class DomesticCat extends Animal {
    private static int domesticCatCount;
    private String name;

    public DomesticCat(String name) {
        setMaximumDistanceRun(200);
        setMaximumDistanceSwim(0);
        setCount(getCount() + 1);
        domesticCatCount++;
        this.name = name;
    }

    public static int getDomesticCatCount() {
        return domesticCatCount;
    }

    public static void setDomesticCatCount(int domesticCatCount) {
        DomesticCat.domesticCatCount = domesticCatCount;
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
        System.out.println(name + " не плавает");
    }
}
