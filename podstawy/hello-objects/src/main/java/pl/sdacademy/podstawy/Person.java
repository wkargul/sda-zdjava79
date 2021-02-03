package pl.sdacademy.podstawy;

public class Person {
    public static final int RETIREMENT_AGE = 65;

    String firstName;
    String lastName;

    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }
}
