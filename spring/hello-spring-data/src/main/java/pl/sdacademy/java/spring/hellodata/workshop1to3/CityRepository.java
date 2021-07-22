package pl.sdacademy.java.spring.hellodata.workshop1to3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<City,Long> {
    List<City> findAllByNameContainingIgnoreCaseOrderByName(String query);

    //Workshop 4a
    @Query("select c from City c where upper(c.name) like upper(concat('%',:query,'%')) order by c.name")
    List<City> findByCustomQuery(String query);

    List<City> findAllByOrderByName();
}
