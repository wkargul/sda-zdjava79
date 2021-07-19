package pl.sdacademy.java.spring.homework.rest.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdacademy.java.spring.homework.rest.department.DepartmentService;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> map = new LinkedHashMap<>();

    private DepartmentService departmentService;

    @Autowired
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public List<Employee> getEmployees(LocalDate dateFrom, LocalDate dateTo) {
        if (dateFrom != null && dateTo != null && dateFrom.isAfter(dateTo)) {
            throw new IllegalArgumentException("dateFrom MUST NOT be after dateTo");
        }

        //w pierwszym kroku filtrujemy wg predykatu
        //w drugim kroku sortujemy (po nazwisku, po imieniu)
        //w trzecim kroku przepakowujemy do listy
        return map.values().stream()
                .filter(e -> employeeFilter(e, dateFrom, dateTo))
                .sorted(Comparator.comparing(Employee::getLastName).thenComparing(Employee::getFirstName))
                .collect(Collectors.toUnmodifiableList());
    }

    private boolean employeeFilter(Employee employee, LocalDate dateFrom, LocalDate dateTo) {
        final LocalDate birthDate = employee.getBirthDate();

        //jeśli birthDate jest null, true gdy nie podano żadnej z dat, false gdy podano którąkolwiek (brak dopasowania)
        if (birthDate == null) {
            return dateFrom == null && dateTo == null;
        }

        //!isBefore() równoznaczne z (isAfter() || isEqual()), analogicznie dla !isAfter
        //gdy dateFrom nie podano lub pasuje do przedziału -> true, analogicznie dla dateTo
        return (dateFrom == null || !dateFrom.isAfter(birthDate)) && (dateTo == null || !dateTo.isBefore(birthDate));
    }

    @Override
    public Optional<Employee> getEmployee(String code) {
        return Optional.ofNullable(map.get(code));
    }

    @Override
    public boolean addEmployee(Employee employee) {
        //Nie dodajemy jeśli klucz już istnieje
        if (map.containsKey(employee.getCode())) {
            return false;
        }

        //Obsługa oddziału
        departmentService.updateDepartmentByEmployee(employee);

        map.put(employee.getCode(), employee);
        return true;
    }

    @Override
    public boolean addOrReplaceEmployee(Employee employee) {
        //put zwraca wartość, która była w mapie PRZED wywołaniem metody
        Employee previous = map.put(employee.getCode(), employee);

        //Obsługa oddziału
        departmentService.updateDepartmentByEmployee(employee);

        //zwracamy true jeśli wcześniej pod danym kluczem w mapie NIC NIE BYŁO
        return previous == null;
    }

    @Override
    public boolean deleteEmployee(String code) {
        //remove zwraca wartość, która była w mapie PRZED wywołaniem metody
        Employee deleted = map.remove(code);

        //Obsługa oddziału
        if (deleted != null) {
            deleted.getDepartment().getEmployees().remove(deleted);
        }

        //zwracamy true jeśli wcześniej pod danym kluczem w mapie COŚ BYŁO
        return deleted != null;
    }
}
