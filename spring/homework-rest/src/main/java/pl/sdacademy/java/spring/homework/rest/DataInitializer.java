package pl.sdacademy.java.spring.homework.rest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.sdacademy.java.spring.homework.rest.department.Department;
import pl.sdacademy.java.spring.homework.rest.department.DepartmentService;
import pl.sdacademy.java.spring.homework.rest.employee.Employee;
import pl.sdacademy.java.spring.homework.rest.employee.EmployeeService;

import java.time.LocalDate;
import java.util.stream.Stream;

@Component
public class DataInitializer implements CommandLineRunner {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    public DataInitializer(EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @Override
    public void run(String... args) {
        Department department1 = new Department();
        department1.setName("HR");

        Department department2 = new Department();
        department2.setName("Accounting");

        Stream.of(department1, department2).forEach(departmentService::addDepartment);

        Employee employee1 = new Employee();
        employee1.setCode("KOJA");
        employee1.setFirstName("Jan");
        employee1.setLastName("Kowalski");
        employee1.setBirthDate(LocalDate.of(1980, 5, 1));
        employee1.setDepartment(department1);

        Employee employee2 = new Employee();
        employee2.setCode("KOAN");
        employee2.setFirstName("Anna");
        employee2.setLastName("Kowalska");
        employee2.setDepartment(department2);

        Employee employee3 = new Employee();
        employee3.setCode("NOAD");
        employee3.setFirstName("Adam");
        employee3.setLastName("Nowak");
        employee3.setBirthDate(LocalDate.of(1990, 6, 2));
        employee3.setDepartment(department1);

        Employee employee4 = new Employee();
        employee4.setCode("NOZY");
        employee4.setFirstName("Zygmunt");
        employee4.setLastName("Nowak");
        employee4.setBirthDate(LocalDate.of(2000, 7, 3));
        employee4.setDepartment(department2);

        Employee employee5 = new Employee();
        employee5.setCode("NKBE");
        employee5.setFirstName("Beata");
        employee5.setLastName("Nowak-Kowalska");
        employee5.setDepartment(department1);

        Stream.of(employee1, employee2, employee3, employee4, employee5)
                .forEach(employeeService::addEmployee);
    }
}
