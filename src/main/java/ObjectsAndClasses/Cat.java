package ObjectsAndClasses;

public class Cat {
    private double originWeight;
    private double weight;

    private double eatenFoodAmount;
    private boolean isAlive;

    private Color color;


    private static String stateOfDeath = "It's not getting to the land of the dead that's the problem. It's getting back.";
    static int count = 0;

    static final int NUMBER_OF_EYES = 2;
    static final int MINIMUM_WEIGHT = 1_000;
    static final int MAXIMUM_WEIGHT = 9_000;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        eatenFoodAmount = 0;
        count++;
        isAlive = true;
    }

    public Cat(double weight) {
        this.weight = weight;
        originWeight = weight;
        eatenFoodAmount = 0;
        count++;
        isAlive = true;
    }

    public void meow() {
        if (isAlive) {
            weight = weight - 1;
            System.out.println("Meow");
            checkIfCatIsAlive();
        } else {
            System.out.println(stateOfDeath);
        }
    }

    public void feed(Double amount) {
        if (isAlive) {
            weight = weight + amount;
            eatenFoodAmount += amount;
            checkIfCatIsAlive();
        } else {
            System.out.println(stateOfDeath);
        }
    }

    public void drink(Double amount) {
        if (isAlive) {
            weight = weight + amount;
            checkIfCatIsAlive();
        } else {
            System.out.println(stateOfDeath);
        }
    }

    public Double getWeight() {
        return weight;
    }

    public String getStatus() {
        if (weight < MINIMUM_WEIGHT) {
            return "Dead";
        } else if (weight > MAXIMUM_WEIGHT) {
            return "Exploded";
        } else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }

    public double getAmountOfFoodEaten() {
        return eatenFoodAmount;
    }

    public void pee() {
        if (isAlive) {
            weight = weight - 1;
            System.out.println("Ps ps");
            checkIfCatIsAlive();
        } else {
            System.out.println(stateOfDeath);
        }
    }

    static int getCount() {
        return count;
    }

    private void checkIfCatIsAlive() {
        if (isAlive) {
            if (weight < MINIMUM_WEIGHT || weight > MAXIMUM_WEIGHT) {
                isAlive = false;
                count--;
            }
        }
    }
}