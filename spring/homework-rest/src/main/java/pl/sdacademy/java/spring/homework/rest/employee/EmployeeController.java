package pl.sdacademy.java.spring.homework.rest.employee;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.List;

@Validated //Wymagane by działały adnotacje walidujące parametry metod!
@RequestMapping("/employees") //Ścieżkę bazową wszystkich metod kontrolera można ustawić w ten sposób
@RestController //@Controller + @ResponseBody
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //Jeśli nie ma żadnej dodatkowej informacji o statusie odpowiedzi, będzie to OK (200)
    @JsonView(Employee.class)
    @GetMapping //HTTP GET, ścieżka /employees
    public List<Employee> getEmployees(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) //Konieczne wskazanie formatu daty aby możliwa była deserializacja; można ustawić globalnie: https://www.baeldung.com/spring-date-parameters
            @RequestParam(name = "date-from", required = false) //Nazwa parametru możne być inna od pola; required=false oznacza, że może tego nie być, wtedy będzie null
            @PastOrPresent //Data w przeszłości lub bieżąca. Null DOZWOLONY (gdyby nie był, trzeba dodatkowo @NotNull)
            LocalDate dateFrom,

            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @RequestParam(name = "date-to", required = false)
            @PastOrPresent
            LocalDate dateTo
    ) {
        return employeeService.getEmployees(dateFrom, dateTo);
    }

    @JsonView(Employee.class)
    @GetMapping("/{code}") //HTTP GET, ścieżka /employees/{code} gdzie {code} to identyfikator pracownika
    public Employee getEmployee(@PathVariable @NotBlank String code) {
        return employeeService.getEmployee(code)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    //Najprostsze podejście: adnotacja @ResponseStatus na własny status odpowiedzi, wyjątek w przypadku błędu
    @JsonView(Employee.class)
    @ResponseStatus(HttpStatus.CREATED) //Przy poprawnym wykonaniu, status CREATED (201)
    @PostMapping //HTTP POST, ścieżka jak z @RequestMapping
    public Employee addEmployee(@RequestBody @Validated Employee employee) { //@RequestBody - obiekt przesłany w ciele żądania; @Validated - wymaga walidacji
        if (employeeService.addEmployee(employee)) { //Zakładamy, że zwraca false gdy już istnieje taki pracownik; innym sposobem mógłby być własny wyjątek
            return employee;
        }
        else {
            throw new ResponseStatusException(HttpStatus.CONFLICT); //CONFLICT (409)
        }

    }

    //Status odpowiedzi wg ResponseEntity
    @JsonView(Employee.class)
    @PutMapping("/{code}") //HTTP PUT, ścieżka /employees/{code} gdzie {code} to identyfikator pracownika
    public ResponseEntity<Employee> addEmployee(
            @PathVariable @NotBlank String code, //@PathVariable - zmienna pobrana ze ścieżki; @NotBlank - nie może być null, puste, ani same białe znaki - tutaj nadmiarowe
            @RequestBody @Validated Employee employee //@RequestBody - obiekt przesłany w ciele żądania; @Validated - wymaga walidacji
    ) {
        employee.setCode(code);

        //Zwracanie różnego statusu odpowiedzi zależnie od przebiegu operacji.
        if (employeeService.addOrReplaceEmployee(employee)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(employee);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(employee);
        }
    }

    //Zwyczajowo DELETE nie zwraca odpowiedzi, prawidłowy status w takiej sytuacji to NO CONTENT (204), ale trzeba ustawić bezpośrednio
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{code}") //HTTP DELETE ścieżka /employees/{code} gdzie {code} to identyfikator pracownika
    public void deleteEmployee(@PathVariable @NotBlank String code) {
        if(!employeeService.deleteEmployee(code)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
