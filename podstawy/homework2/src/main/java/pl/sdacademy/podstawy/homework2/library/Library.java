package pl.sdacademy.podstawy.homework2.library;

import java.util.Arrays;

public class Library {
    private final Book[] books;

    public Library(Book[] books) {
        this.books = Arrays.copyOf(books, books.length);
    }

    public Book[] findByYear(int from, int to) {
        final Book[] results = new Book[books.length]; //wstępnie - tablica wielkości oryginalnej

        int resultIndex = 0;
        for (Book book : books) {
            if (book.getYear() >= from && book.getYear() <= to) { //czy book.year jest w przedziale [from,to]
                results[resultIndex] = book;
                resultIndex++;

                //books[resultIndex++] = book; //niezbyt czytelna alternatywa
            }
        }

        return Arrays.copyOf(results, resultIndex); //resultIndex po ostatniej inkrementacji jest równy liczbie elementów
    }

    public Book[] findByTitle(String query) {
        final Book[] results = new Book[books.length]; //wstępnie - tablica wielkości oryginalnej

        int resultIndex = 0;
        for (Book book : books) {

            //Uwaga! W rzeczywistych zastosowaniach toLowerCase() należy używać z Locale
            if (book.getTitle().toLowerCase().contains(query.toLowerCase())) { //czy tytuł (lowercase) zawiera zapytanie (lowercase)
                results[resultIndex] = book;
                resultIndex++;

                //books[resultIndex++] = book; //niezbyt czytelna alternatywa
            }
        }

        return Arrays.copyOf(results, resultIndex); //resultIndex po ostatniej inkrementacji jest równy liczbie elementów
    }
}
