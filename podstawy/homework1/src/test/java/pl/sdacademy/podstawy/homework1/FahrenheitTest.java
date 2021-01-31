package pl.sdacademy.podstawy.homework1;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FahrenheitTest {
    private static final Offset<Double> OFFSET = Offset.offset(0.0001);

    @Test
    @DisplayName("Should be valid for Absolute Zero")
    void shouldBeValidForAbsoluteZero() {
        //WHEN
        final double fahrenheit = Fahrenheit.celsiusToFahrenheit(-273.15);

        //THEN
        assertThat(fahrenheit).isCloseTo(-459.67, OFFSET);
    }

    @Test
    @DisplayName("Should be same at -40\u2103 (parity)")
    void shouldBeSameAtMinus40() {
        //WHEN
        final double fahrenheit = Fahrenheit.celsiusToFahrenheit(-40.0);

        //THEN
        assertThat(fahrenheit).isCloseTo(-40.0, OFFSET);
    }

    @Test
    @DisplayName("Should be valid for Freezing Point")
    void shouldBeValidForFreezingPoint() {
        //WHEN
        final double fahrenheit = Fahrenheit.celsiusToFahrenheit(0);

        //THEN
        assertThat(fahrenheit).isCloseTo(32, OFFSET);
    }

    @Test
    @DisplayName("Should be valid for Boiling Point")
    void shouldBeValidForBoilingPoint() {
        //WHEN
        final double fahrenheit = Fahrenheit.celsiusToFahrenheit(100);

        //THEN
        assertThat(fahrenheit).isCloseTo(212, OFFSET);
    }
}