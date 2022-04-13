package HM_3_1_3_introduction_to_OOP;

abstract class Animal {
    private static int count;

    private double maximumDistanceRun;
    private double maximumDistanceSwim;

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Animal.count = count;
    }

    public double getMaximumDistanceRun() {
        return maximumDistanceRun;
    }

    public void setMaximumDistanceRun(double maximumDistanceRun) {
        this.maximumDistanceRun = maximumDistanceRun;
    }

    public double getMaximumDistanceSwim() {
        return maximumDistanceSwim;
    }

    public void setMaximumDistanceSwim(double maximumDistanceSwim) {
        this.maximumDistanceSwim = maximumDistanceSwim;
    }

    abstract void run(double distance);

    abstract void swim(double distance);

}
