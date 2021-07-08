package pl.sdacademy.java.spring.hellorest.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Validated
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    // /employees/{code}
    @GetMapping("/{code}")
    public Employee getEmployee(@PathVariable String code) {
        return employeeService.getEmployee(code)
            .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Employee addEmployee(@RequestBody @Validated Employee employee) {
        if (employeeService.addEmployee(employee)) {
            return employee;
        }
        else {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{code}")
    public ResponseEntity<Employee> addOrReplaceEmployee(
            @PathVariable String code,
            @RequestBody @Validated Employee employee
    ) {
        employee.setCode(code);
        if (employeeService.addOrReplaceEmployee(employee)) {
           return ResponseEntity.status(HttpStatus.CREATED).body(employee);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(employee);
        }
    }

    @DeleteMapping("/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable String code) {
        if (!employeeService.deleteEmployee(code)) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
