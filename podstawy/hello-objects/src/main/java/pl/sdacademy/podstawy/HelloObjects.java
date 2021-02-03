package pl.sdacademy.podstawy;

public class HelloObjects {
    public static void main(String[] args) {
        Person janKowalski = new Person();
        janKowalski.firstName = "Jan";
        janKowalski.lastName = "Kowalski";

        Person adamNowak = new Person();
        adamNowak.firstName = "Adam";
        adamNowak.lastName = "Nowak";

        Person[] people = new Person[] { janKowalski, adamNowak };

        for (Person person : people) {
            System.out.println(person);
        }
    }
}
