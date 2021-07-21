package pl.sdacademy.java.spring.hellodata.workshop4;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Long> {
    Page<City> findAllByNameContainingIgnoreCase(String query, Pageable pageable);
}
