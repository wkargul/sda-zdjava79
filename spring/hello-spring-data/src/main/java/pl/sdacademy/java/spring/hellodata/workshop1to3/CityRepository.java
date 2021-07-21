package pl.sdacademy.java.spring.hellodata.workshop1to3;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Long> {
}
