package part1.ObjectsAndClasses;

public class Loader {
    public static void main(String[] args) {
        Cat cat = getKitten();
        System.out.println(cat.getStatus() + " " + cat.getWeight());
        Cat cat2 = getKitten();
        Cat cat3 = getKitten();
    }

    private static Cat getKitten() {
        return new Cat(1100.00);
    }
}