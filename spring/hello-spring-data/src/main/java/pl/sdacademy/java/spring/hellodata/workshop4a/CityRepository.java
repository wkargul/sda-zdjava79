package pl.sdacademy.java.spring.hellodata.workshop4a;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CityRepository extends JpaRepository<City,Long> {

    @EntityGraph(attributePaths = "country")
    Page<City> findAllByCountryNameContainingIgnoreCase(String query, Pageable pageable);

    @Query(
        value = "select c from City c join fetch c.country where upper(c.country.name) like upper(concat('%',:query,'%'))",
        countQuery = "select count(c) from City c join c.country where upper(c.country.name) like upper(concat('%',:query,'%'))"
    )
    Page<City> findByWhatever(String query, Pageable pageable);

    @EntityGraph(attributePaths = "country")
    Page<City> findAll(Pageable pageable);
}
