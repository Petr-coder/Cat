package part1.ObjectsAndClasses;

public class Lesson3 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        System.out.println("cat status is " + cat.getStatus());
        System.out.println("cat weight is " + cat.getWeight());
        System.out.println("После создания первого кота. Count is " + Cat.getCount());
        cat.feed(150.00);
        cat.pee();
        cat.pee();
        cat.pee();
        cat.pee();
        System.out.println("Котэ съело " + cat.getAmountOfFoodEaten());
        Lesson1.meowCatTillDeath(cat);
        cat.feed(111.0);
        cat.feed(111.0);
        cat.meow();
        System.out.println("");
        Cat cat3 = new Cat();
        Cat cat2 = new Cat();
        System.out.println("После создания смерти 1 кота и создания 2. Count is " + Cat.getCount());


        Cat cat4 = new Cat();
        System.out.println("После создания смерти 1 кота и создания 3. Count is " + Cat.getCount());

        Lesson1.feedCatTillExplode(cat2);
        cat2.feed(111.0);
        cat2.meow();
        cat2.drink(13.3);
        System.out.println("Count is " + Cat.getCount());
    }
}
