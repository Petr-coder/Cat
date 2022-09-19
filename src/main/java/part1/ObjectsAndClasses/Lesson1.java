package part1.ObjectsAndClasses;


public class Lesson1 {
    public static void main(String[] args) {

        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        System.out.println("cat1 status is " + cat1.getStatus());
        System.out.println("cat1 weight is " + cat1.getWeight());
        System.out.println("cat2 status is " + cat2.getStatus());
        System.out.println("cat1 weight is " + cat2.getWeight());

        cat1.feed(2.3);
        cat2.feed(23.3);

        feedCatTillExplode(cat1);
        meowCatTillDeath(cat2);

        System.out.println("\n" + "cat1 status after is " + cat1.getStatus());
        System.out.println("cat1 weight after is " + cat1.getWeight());
        System.out.println("cat2 status after is " + cat2.getStatus());
        System.out.println("cat1 weight after is " + cat2.getWeight());


        Cat cat3 = new Cat();
        Cat cat4 = new Cat();
        Cat cat5 = new Cat();
        Cat cat6 = new Cat();
    }

    static void feedCatTillExplode(Cat cat) {
        while (!cat.getStatus().equals("Exploded")) {
            cat.feed(100.0);
        }
    }

    static void meowCatTillDeath(Cat cat) {
        while (!cat.getStatus().equals("Dead")) {
            cat.meow();
        }
    }

}
