package pl.sdacademy.podstawy.homework1;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FuelTest {
    private static final Offset<Double> OFFSET = Offset.offset(0.0001);

    @Test
    @DisplayName("Should calculate expected usage")
    void shouldCalculateExpectedUsage() {
        //WHEN
        final double usage = Fuel.calculateUsage(200, 12);

        //THEN
        assertThat(usage).isCloseTo(6, OFFSET);
    }

    @Test
    @DisplayName("Should calculate expected price per km")
    void shouldCalculateExpectedPricePerKm() {
        //WHEN
        final double price = Fuel.calculatePricePerKm(200, 12, 6.0);

        //THEN
        assertThat(price).isCloseTo(0.36, OFFSET);
    }
}
