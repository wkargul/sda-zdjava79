package pl.sdacademy.java.spring.hellodata.workshop1to3;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City,Long> {
    List<City> findAllByNameContainingIgnoreCaseOrderByName(String query);

    List<City> findAllByOrderByName();
}
