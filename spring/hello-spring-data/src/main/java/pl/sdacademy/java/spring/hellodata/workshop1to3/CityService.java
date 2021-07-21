package pl.sdacademy.java.spring.hellodata.workshop1to3;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getCities() {
        return cityRepository.findAll();
    }

    public Optional<City> getCity(long id) {
        return cityRepository.findById(id);
    }

    public City addCity(City city) {
        return cityRepository.save(city);
    }
}
