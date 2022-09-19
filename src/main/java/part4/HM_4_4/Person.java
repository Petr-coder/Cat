package part4.HM_4_4;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Person {
    private static final List<String> lastNames = Arrays.asList("Smirnov", "Ivanov", "Kuznetsov", "Sokolov", "Popov", "Lebedev", "Kozlov", "Novikov", "Morozov", "Petrov", "Volkov", "Solovyev", "Vasilyev", "Zaytsev", "Pavlov");
    private static final List<String> maleName = Arrays.asList("Kirill", "Viktor", "Fedor", "Bogdan", "Konstantin", "Adam", "Leonid", "Roman", "Pavel", "Artemiy", "Petr", "Alex", "Miron", "Vladimir", "John");
    private static final List<String> femaleName = Arrays.asList("Alice", "Alina", "Anna", "Veronika", "Kira", "Kristina", "Larisa", "Maria", "Marina", "Olga", "Polina", "Sophia", "Taisia", "Vera", "Viktoria");

    private final Sex gender;
    private final String firstName;
    private final String lastName;
    private final int age;

    public Person() {
        this.firstName = generateFirstName();
        this.lastName = generateLastName();
        this.gender = generateSex();
        this.age = generateYear();
    }

    public Sex getGender() {
        return gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    private int generateYear() {
        return (int) Math.floor(Math.random() * (90 - 3 + 1) + 3);
    }

    private Sex generateSex() {

        if (new Random().nextInt() == 1) {
            return Sex.MALE;
        }
        return Sex.FEMALE;
    }

    private int generateNumber() {
        return (int) Math.floor(Math.random() * (14 + 1));
    }

    private String generateFirstName() {

        String name = femaleName.get(generateNumber());

        if (gender == Sex.MALE) {
            name = maleName.get(generateNumber());
        }

        return name;
    }

    private String generateLastName() {
        return lastNames.get(generateNumber());
    }

    @Override
    public String toString() {
        return "Person{" +
                "gender=" + gender.getGender() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
