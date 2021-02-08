package pl.sdacademy.podstawy.homework2.library;

public class LibraryData {
    private LibraryData() {}

    public static Book[] getBooks() {
        return new Book[] {
                new Book("Duma i uprzedzenie", "Jane Austen", 1813),
                new Book("Pan Tadeusz", "Adam Mickiewicz", 1834),
                new Book("Zbrodnia i kara", "Fiodor Dostojewski", 1867),
                new Book("W pustyni i w puszczy", "Henryk Sienkiewicz", 1911)
        };
    }
}
