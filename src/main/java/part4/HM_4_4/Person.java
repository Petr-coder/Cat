package part4.HM_4_4;

public class Person {

    private final Sex gender;
    private final String firstName;
    private final String lastName;
    private final int age;

    public Person(Sex gender, String firstName, String lastName, int age) {
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Sex getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}
