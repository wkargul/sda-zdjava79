package pl.sdacademy.java.spring.hellodata.workshop5;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public List<City> getCities(@RequestParam(required = false) String query) {
        return cityService.getCities(query);
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

    @PatchMapping("/{id}")
    public City updateCity(@PathVariable long id, @RequestBody City city) {
        city.setId(id);
        return cityService.updateCity(city)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
