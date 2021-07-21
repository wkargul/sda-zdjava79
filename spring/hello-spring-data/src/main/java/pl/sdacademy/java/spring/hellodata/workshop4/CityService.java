package pl.sdacademy.java.spring.hellodata.workshop4;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Page<City> getCities(String query, Pageable pageable) {
        if (query != null) {
            return cityRepository.findAllByNameContainingIgnoreCase(query, pageable);
        }
        else {
            return cityRepository.findAll(pageable);
        }
    }

    public Optional<City> getCity(long id) {
        return cityRepository.findById(id);
    }

    public City addCity(City city) {
        return cityRepository.save(city);
    }
}
