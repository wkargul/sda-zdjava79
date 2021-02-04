package pl.sdacademy.podstawy;

public class Person {
    public static final int RETIREMENT_AGE = 65;

    private String firstName;
    private String lastName;

    //Opcjonalny, chyba że istnieje konstruktor argumentowy
    //Wtedy, jeżeli chcemy nadal go mieć, musi być zadeklarowany
    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }
}
