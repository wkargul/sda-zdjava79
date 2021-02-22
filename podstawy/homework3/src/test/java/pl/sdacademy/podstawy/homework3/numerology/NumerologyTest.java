package pl.sdacademy.podstawy.homework3.numerology;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumerologyTest {

    @Test
    @DisplayName("Should handle big value (return 21 for input 123456)")
    void shouldHandleBigValue() {
        //WHEN
        int result = Numerology.sumDigits(123456);

        //THEN
        assertThat(result).isEqualTo(21);
    }

    @Test
    @DisplayName("Should handle small value (return 5 for input 5)")
    void shouldHandleSmallValue() {
        //WHEN
        int result = Numerology.sumDigits(5);

        //THEN
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("Should handle zero (return 0 for input 0)")
    void shouldHandleZero() {
        //WHEN
        int result = Numerology.sumDigits(0);

        //THEN
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("Should handle negative (return 21 for input -123456")
    void shouldHandleNegative() {
        //WHEN
        int result = Numerology.sumDigits(-123456);

        //THEN
        assertThat(result).isEqualTo(21);
    }

    @Test
    @DisplayName("Should sum all digits (return 3 for input 123456)")
    void shouldSumAllDigits() {
        //WHEN
        int result = Numerology.sumAllDigits(123456);

        //THEN
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("Should not sum all digits (return 5 for input 5)")
    void shouldNotSumAllDigits() {
        //WHEN
        int result = Numerology.sumAllDigits(5);

        //THEN
        assertThat(result).isEqualTo(5);
    }

}
