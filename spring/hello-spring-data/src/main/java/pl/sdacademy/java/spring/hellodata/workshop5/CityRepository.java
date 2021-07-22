package pl.sdacademy.java.spring.hellodata.workshop5;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<pl.sdacademy.java.spring.hellodata.workshop5.City,Long> {
    List<City> findAllByNameContainingIgnoreCaseOrderByName(String query);

    List<City> findAllByOrderByName();
}
