package pl.sdacademy.java.spring.hellodata.workshop5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@TestPropertySource(
    properties = { "spring.datasource.url=jdbc:h2:mem:~/footest" }
)
@Transactional
class CityRepositoryTest {

    @Autowired
    private CityRepository cityRepository;

    @Sql(statements = "insert into city (id, name) values (5,'Warszawa');")
    @Test
    void findById() {
        //WHEN
        Optional<City> cityOptional = cityRepository.findById(5L);

        //THEN
        assertThat(cityOptional).isNotEmpty();
        assertThat(cityOptional.get().getName()).isEqualTo("Warszawa");
    }
}
