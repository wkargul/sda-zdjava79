package pl.sdacademy.java.spring.advanced.testexample;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class FooServiceSpringTest {

    @MockBean
    private FooRepository fooRepository;

    @Autowired
    private FooService fooService;

    @Test
    void shouldAddXyzPostfix() {
        //GIVEN
        Mockito.when(fooRepository.getValue(5)).thenReturn("aaaa");

        //WHEN
        String result = fooService.getValue(5);

        //THEN
        Assertions.assertThat(result).isEqualTo("aaaaxyz");
    }
}
