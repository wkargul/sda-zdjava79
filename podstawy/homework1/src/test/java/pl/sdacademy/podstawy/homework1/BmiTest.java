package pl.sdacademy.podstawy.homework1;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BmiTest {
    private static final Offset<Double> OFFSET = Offset.offset(0.0001);

    @Test
    @DisplayName("Should calculate expected BMI")
    void shouldCalculateExpectedBmi() {
        //WHEN
        final double bmi = Bmi.bmi(1.6,88);

        //THEN
        assertThat(bmi).isCloseTo(34.375, OFFSET);
    }

    @Test
    @DisplayName("Should estimate very low BMI as underweight")
    void shouldEstimateVeryLowBmiAsUnderweight() {
        //WHEN
        final int estimatedBmi = Bmi.estimateBmi(10.0);

        //THEN
        assertThat(estimatedBmi).isEqualTo(Bmi.BMI_UNDERWEIGHT);
    }

    @Test
    @DisplayName("Should estimate slightly low BMI as underweight")
    void shouldEstimateSlightlyLowBmiAsUnderweight() {
        //WHEN
        final int estimatedBmi = Bmi.estimateBmi(18.4999);

        //THEN
        assertThat(estimatedBmi).isEqualTo(Bmi.BMI_UNDERWEIGHT);
    }

    @Test
    @DisplayName("Should estimate low normal BMI as normal")
    void shouldEstimateLowNormalBmiAsNormal() {
        //WHEN
        final int estimatedBmi = Bmi.estimateBmi(18.5);

        //THEN
        assertThat(estimatedBmi).isEqualTo(Bmi.BMI_NORMAL);
    }

    @Test
    @DisplayName("Should estimate high normal BMI as normal")
    void shouldEstimateHighNormalBmiAsNormal() {
        //WHEN
        final int estimatedBmi = Bmi.estimateBmi(24.9999);

        //THEN
        assertThat(estimatedBmi).isEqualTo(Bmi.BMI_NORMAL);
    }

    @Test
    @DisplayName("Should estimate very high BMI as overweight")
    void shouldEstimateVeryHighBmiAsOverweight() {
        //WHEN
        final int estimatedBmi = Bmi.estimateBmi(50.0);

        //THEN
        assertThat(estimatedBmi).isEqualTo(Bmi.BMI_OVERWEIGHT);
    }

    @Test
    @DisplayName("Should estimate slightly high BMI as overweight")
    void shouldEstimateSlightlyHighBmiAsOverweight() {
        //WHEN
        final int estimatedBmi = Bmi.estimateBmi(25.0);

        //THEN
        assertThat(estimatedBmi).isEqualTo(Bmi.BMI_OVERWEIGHT);
    }
}