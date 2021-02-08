package pl.sdacademy.podstawy.homework2.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LibraryTest {
    private Library library;

    @BeforeEach
    void setUp() {
        final Book[] allBooks = LibraryData.getBooks();
        library = new Library(allBooks);
    }

    @Test
    @DisplayName("findByTitle(\"usz\") should return an array of two books")
    void shouldReturnValuesFilteredByTitle() {
        //WHEN
        final Book[] result = library.findByTitle("usz");

        //THEN
        assertThat(result)
                .hasSize(2)
                .extracting("title")
                .containsExactlyInAnyOrder("Pan Tadeusz", "W pustyni i w puszczy");
    }

    @Test
    @DisplayName("findByTitle(\"xyz\") should return an empty array")
    void shouldNotReturnValuesFilteredByTitle() {
        //WHEN
        final Book[] result = library.findByTitle("xyz");

        //THEN
        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("findByYear(1830,1900) should return an array of two books")
    void shouldReturnValuesFilteredByYear() {
        //WHEN
        final Book[] result = library.findByYear(1830,1900);

        //THEN
        assertThat(result)
                .hasSize(2)
                .extracting("title")
                .containsExactlyInAnyOrder("Pan Tadeusz", "Zbrodnia i kara");
    }



    @Test
    @DisplayName("findByYear(1950,2000) should return an empty array")
    void shouldNotReturnValuesFilteredByYear() {
        //WHEN
        final Book[] result = library.findByYear(1950, 2000);

        //THEN
        assertThat(result).isEmpty();
    }
}
