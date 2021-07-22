package pl.sdacademy.java.spring.hellodata.workshop4a;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Long> {

    @EntityGraph(attributePaths = "country")
    Page<City> findAllByCountryNameContainingIgnoreCase(String query, Pageable pageable);

    @EntityGraph(attributePaths = "country")
    Page<City> findAll(Pageable pageable);
}
