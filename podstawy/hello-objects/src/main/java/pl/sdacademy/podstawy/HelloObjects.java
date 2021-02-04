package pl.sdacademy.podstawy;

public class HelloObjects {
    private HelloObjects() {
    }

    public static void main(String[] args) {
        Person janKowalski = new Person();
        janKowalski.setFirstName("Jan");
        janKowalski.setLastName("Kowalski");

        Person adamNowak = new Person();
        adamNowak.setFirstName("Adam");
        adamNowak.setLastName("Nowak");

        Person janinaNowak = new Person("Janina", "Nowak");

        Person[] people = new Person[] {janKowalski, adamNowak, janinaNowak };

        for (Person person : people) {
            System.out.println(person);
        }

        //---

        Book pustynia = new Book("W pustyni i w puszczy", "Henryk Sienkiewicz", 1911);
        Book krzyzacy = new Book("Krzyżacy", "Henryk Sienkiewicz", 1897);

        Book[] books = new Book[] { pustynia, krzyzacy };

        for (Book book : books) {
            System.out.println(book);
        }
    }
}
