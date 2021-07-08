package pl.sdacademy.java.spring.hellorest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.sdacademy.java.spring.hellorest.employee.Employee;
import pl.sdacademy.java.spring.hellorest.employee.EmployeeService;

import java.util.stream.Stream;

@Component
public class DataInitializer implements CommandLineRunner {

    private final EmployeeService employeeService;

    public DataInitializer(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) {
        Employee employee1 = new Employee();
        employee1.setCode("KOJA");
        employee1.setFirstName("Jan");
        employee1.setLastName("Kowalski");

        Employee employee2 = new Employee();
        employee2.setCode("KOAN");
        employee2.setFirstName("Anna");
        employee2.setLastName("Kowalska");

        Employee employee3 = new Employee();
        employee3.setCode("NOAD");
        employee3.setFirstName("Adam");
        employee3.setLastName("Nowak");

        Employee employee4 = new Employee();
        employee4.setCode("NOZY");
        employee4.setFirstName("Zygmunt");
        employee4.setLastName("Nowak");

        Employee employee5 = new Employee();
        employee5.setCode("NKBE");
        employee5.setFirstName("Beata");
        employee5.setLastName("Nowak-Kowalska");

        Stream.of(employee1, employee2, employee3, employee4, employee5)
                .forEach(employeeService::addEmployee);
    }
}
