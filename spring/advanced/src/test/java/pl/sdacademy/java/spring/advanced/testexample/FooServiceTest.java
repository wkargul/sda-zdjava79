package pl.sdacademy.java.spring.advanced.testexample;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FooServiceTest {

    @Mock
    private FooRepository fooRepository;

    private FooService fooService;

    @BeforeEach
    void setUp() {
        fooService = new FooService(fooRepository);
    }

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
