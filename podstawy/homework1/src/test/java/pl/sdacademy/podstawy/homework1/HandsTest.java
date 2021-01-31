package pl.sdacademy.podstawy.homework1;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HandsTest {
    private static final Offset<Double> OFFSET = Offset.offset(0.0001);

    @Test
    @DisplayName("Should be 0 at noon/midnight")
    void shouldBe0AtNoon() {
        //WHEN
        final double angle = Hands.handsAngle(12,0);

        //THEN
        assertThat(angle).isCloseTo(0, OFFSET);
    }

    @Test
    @DisplayName("Should be 180 at 6:00")
    void shouldBe180At6() {
        //WHEN
        final double angle = Hands.handsAngle(6,0);

        //THEN
        assertThat(angle).isCloseTo(180, OFFSET);
    }

    @Test
    @DisplayName("Should be 90 at 9:00")
    void shouldBe90At9() {
        //WHEN
        final double angle = Hands.handsAngle(9,0);

        //THEN
        assertThat(angle).isCloseTo(90, OFFSET);
    }


    @Test
    @DisplayName("Should be 7.5 at 3:15")
    void shouldBeAsExpectedQuarterPast3() {
        //WHEN
        final double angle = Hands.handsAngle(3,15);

        //THEN
        assertThat(angle).isCloseTo(7.5, OFFSET);
    }
}
