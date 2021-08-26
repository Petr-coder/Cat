package ObjectsAndClasses;

public class Lesson2 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        System.out.println("cat status is " + cat.getStatus());
        System.out.println("cat weight is " + cat.getWeight());
        cat.feed(150.00);
        cat.pee();
        cat.pee();
        cat.pee();
        cat.pee();
        System.out.println("Котэ съело " + cat.getAmountOfFoodEaten());


    }

}
