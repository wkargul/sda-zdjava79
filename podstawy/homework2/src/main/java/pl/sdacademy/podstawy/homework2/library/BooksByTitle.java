package pl.sdacademy.podstawy.homework2.library;

import java.util.Arrays;
import java.util.Scanner;

public class BooksByTitle {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj fragment tytułu:");
        final String query = scanner.next();

        final Library library = new Library(LibraryData.getBooks());
        final Book[] result = library.findByTitle(query);

        System.out.println(Arrays.toString(result));
    }
}
