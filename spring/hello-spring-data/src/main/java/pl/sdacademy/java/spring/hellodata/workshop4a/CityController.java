package pl.sdacademy.java.spring.hellodata.workshop4a;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public Page<City> getCities(@RequestParam(required = false) String query, Pageable pageable) {
        return cityService.getCities(query, pageable);
    }

    @GetMapping("/{id}")
    public City getCity(@PathVariable long id) {
        return cityService.getCity(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public City addCity(@RequestBody City city) {
        return cityService.addCity(city);
    }
}
