package HM_3_1_3_introduction_to_OOP;

abstract class Animal {
    static int count;
    double maximumDistanceRun;
    double maximumDistanceSwim;

    abstract void run(double distance);

    abstract void swim(double distance);

}
