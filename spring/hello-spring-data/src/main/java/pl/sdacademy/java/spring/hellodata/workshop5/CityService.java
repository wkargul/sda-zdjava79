package pl.sdacademy.java.spring.hellodata.workshop5;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getCities(String query) {
        if (query != null) {
            //return cityRepository.findAllByNameContainingIgnoreCaseOrderByName(query);
            return cityRepository.findAllByNameContainingIgnoreCaseOrderByName(query);
        }
        else {
            return cityRepository.findAllByOrderByName();
        }
    }

    public Optional<City> getCity(long id) {
        return cityRepository.findById(id);
    }

    public City addCity(City city) {
        return cityRepository.save(city);
    }


    @Transactional
    public Optional<City> updateCity(City city) {
        final Optional<City> managedCity = cityRepository.findById(city.getId());

        if (managedCity.isEmpty()) {
            return Optional.empty();
        }

        managedCity.ifPresent(mc -> mc.setName(city.getName()));

        if (!city.getName().matches("^[A-Z].*$")) {
            throw new IllegalArgumentException("Niepoprawna nazwa miasta: " + city.getName());
        }

        return managedCity;
    }
}
