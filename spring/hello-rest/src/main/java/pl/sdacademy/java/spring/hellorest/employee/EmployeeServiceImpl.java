package pl.sdacademy.java.spring.hellorest.employee;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> map = new ConcurrentHashMap<>();

    @Override
    public List<Employee> getEmployees() {
        //w pierwszym kroku sortujemy (po nazwisku, po imieniu)
        //w drugim kroku przepakowujemy do listy
        return map.values().stream()
                .sorted(Comparator.comparing(Employee::getLastName)
                        .thenComparing(Employee::getFirstName)
                )
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Optional<Employee> getEmployee(String code) {
        //Map.get może zwrócić null - trzeba przepakować w Optional
        return Optional.ofNullable(map.get(code));
    }

    @Override
    public boolean addEmployee(Employee employee) {
        //Nie dodajemy jeśli klucz już istnieje
        if (map.containsKey(employee.getCode())) {
            return false;
        }

        map.put(employee.getCode(), employee);
        return true;
    }

    @Override
    public boolean addOrReplaceEmployee(Employee employee) {
        //put zwraca wartość, która była w mapie PRZED wywołaniem metody
        Employee previous = map.put(employee.getCode(), employee);

        //zwracamy true jeśli wcześniej pod danym kluczem w mapie NIC NIE BYŁO
        return previous == null;
    }

    @Override
    public boolean deleteEmployee(String code) {
        //remove zwraca wartość, która była w mapie PRZED wywołaniem metody
        Employee deleted = map.remove(code);

        //zwracamy true jeśli wcześniej pod danym kluczem w mapie COŚ BYŁO
        return deleted != null;
    }
}
