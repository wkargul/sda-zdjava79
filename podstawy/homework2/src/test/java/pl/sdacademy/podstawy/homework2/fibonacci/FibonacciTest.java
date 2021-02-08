package pl.sdacademy.podstawy.homework2.fibonacci;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FibonacciTest {

    @Test
    @DisplayName("next() should return first 10 of Fibonacci sequence")
    void shouldReturnFirst10Values() {
        //WHEN
        long[] result = new long[10];

        final Fibonacci fibonacci = new Fibonacci();
        for (int i = 0; i < result.length; i++) {
            result[i] = fibonacci.next();
        }

        //THEN
        assertThat(result).containsExactly(0, 1, 1, 2, 3, 5, 8, 13, 21, 34);
    }

}