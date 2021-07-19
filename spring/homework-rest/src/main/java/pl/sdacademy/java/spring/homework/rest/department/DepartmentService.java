package pl.sdacademy.java.spring.homework.rest.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdacademy.java.spring.homework.rest.employee.Employee;
import pl.sdacademy.java.spring.homework.rest.employee.EmployeeService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private EmployeeService employeeService;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartment(int id) {
        return departmentRepository.findById(id);
    }

    public Department addDepartment(Department department) {
        //Zapisanie oddziału w repozytorium (nie wiemy czy repozytorium zwróci ten sam obiekt, czy inny!)
        final Department savedDepartment = departmentRepository.save(department);

        //Aktualizacja listy pracowników o zapisany oddział i dodanie każdego z nich
        department.getEmployees().stream()
                .peek(e -> e.setDepartment(savedDepartment))
                .forEach(employeeService::addEmployee);

        return savedDepartment;
    }

    public void updateDepartmentByEmployee(Employee employee) {
        final Optional<Department> existingDepartment = Optional.ofNullable(employee.getDepartment())
                .map(Department::getId)
                .flatMap(departmentRepository::findById);

        if (existingDepartment.isPresent()) {
            existingDepartment.get().getEmployees().add(employee);
        }
        else {
            final Department newDepartment = Objects.requireNonNull(employee.getDepartment());

            //Oddział tworzony na podstawie obiektu pracownika ma pustą listę pracowników
            newDepartment.getEmployees().add(employee);
            departmentRepository.save(newDepartment);
        }
    }
}
