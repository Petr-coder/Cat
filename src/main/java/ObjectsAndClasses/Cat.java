package ObjectsAndClasses;

public class Cat {
    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;

    private double eatenFoodAmount;
    private boolean isAlive;

    private static String stateOfDeath = "It's not getting to the land of the dead that's the problem. It's getting back.";
    static int count = 0;

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
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
        if (weight < minWeight) {
            return "Dead";
        } else if (weight > maxWeight) {
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
            if (weight < minWeight || weight > maxWeight) {
                isAlive = false;
                count--;
            }
        }
    }
}