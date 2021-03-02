package pl.sdacademy.podstawy.homework4.shop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class ProductTest {

    @Test
    void toStringShouldReturnProductNameAndPrice() {
        //GIVEN
        final Product product = new Product("Test", BigDecimal.valueOf(5));

        //WHEN
        final String productString = product.toString();

        //THEN
        assertThat(productString).isEqualTo("Test (5)");
    }
}
