package pl.sdacademy.podstawy.homework2.library;

import java.util.Arrays;
import java.util.Scanner;

public class BooksByYear {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj rok początkowy:");
        final int from = scanner.nextInt();
        System.out.println("Podaj rok końcowy:");
        final int to = scanner.nextInt();

        if (from > to) {
            System.out.println("Niepoprawny zakres dat");
            return;
        }

        final Library library = new Library(LibraryData.getBooks());
        final Book[] result = library.findByYear(from, to);

        System.out.println(Arrays.toString(result));
    }
}
