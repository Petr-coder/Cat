package part4.HM_4_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
Выбрать по 15 мужских и женских имен и фамилий.  Сгенерировать все возможные комбинации: имя, фамилия пол,
возраст (рандомно от 3 до 90).
Используя генератор создать список из объектов класса Person.
Используя stream api определить:
Общее количество людей
Общее количество мужчин
Сколько женщин несовершеннолетних
Сколько мужчин и женщин пенсионного возраста (учитывая последнюю пенсионную реформу) */
public class PersonGenerator {

    private static final String[] MALE_NAMES = {"John", "David", "Michael", "William", "James", "Robert",
            "Joseph", "Daniel", "Andrew", "Matthew", "Anthony", "Christopher", "Mark", "Thomas", "Richard"};
    private static final String[] FEMALE_NAMES = {"Mary", "Elizabeth", "Sarah", "Margaret", "Emma", "Megan",
            "Rachel", "Jennifer", "Jessica", "Linda", "Susan", "Karen", "Nancy", "Betty", "Dorothy"};
    private static final String[] SURNAMES = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis",
            "Miller", "Wilson", "Moore", "Taylor", "Anderson", "Jackson", "Martin", "Lee", "Harris"};
    private static final Random RANDOM = new Random();

    private static final int LEGAL_AGE = 18;
    private static final int RETIREMENT_AGE_FOR_WOMEN = 60;
    private static final int RETIREMENT_AGE_FOR_MEN = 65;

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        for (String name : MALE_NAMES) {
            for (String surname : SURNAMES) {
                people.add(new Person(Sex.MALE, name, surname, RANDOM.nextInt(88) + 3));
            }
        }
        for (String name : FEMALE_NAMES) {
            for (String surname : SURNAMES) {
                people.add(new Person(Sex.FEMALE, name, surname, RANDOM.nextInt(88) + 3));
            }
        }

        long totalPeople = people.size();
        long totalMen = people.stream()
                .filter(person -> person.getGender() == Sex.MALE)
                .count();
        long totalWomen = people.stream()
                .filter(person -> person.getGender() == Sex.FEMALE)
                .count();
        long underageWomen = people.stream()
                .filter(person -> person.getGender() == Sex.FEMALE && person.getAge() < LEGAL_AGE)
                .count();
        long retiredMen = people.stream()
                .filter(person -> person.getGender() == Sex.MALE && person.getAge() >= RETIREMENT_AGE_FOR_MEN)
                .count();
        long retiredWomen = people.stream()
                .filter(person -> person.getGender() == Sex.FEMALE && person.getAge() >= RETIREMENT_AGE_FOR_WOMEN)
                .count();

        long totalMaleAndFemaleRetirees = people.stream()
                .filter(p -> (p.getGender() == Sex.MALE && p.getAge() >= RETIREMENT_AGE_FOR_MEN)
                        || (p.getGender() == Sex.FEMALE && p.getAge() >= RETIREMENT_AGE_FOR_WOMEN))
                .count();

        System.out.println("Total number of people: " + totalPeople);
        System.out.println("Total number of men: " + totalMen);
        System.out.println("Total number of women: " + totalWomen);
        System.out.println("Number of underage women: " + underageWomen);
        System.out.println("Number of men of retirement age: " + retiredMen);
        System.out.println("Number of women of retirement age: " + retiredWomen);
        System.out.println("Number of men and women of retirement age: " + totalMaleAndFemaleRetirees);
    }
}


