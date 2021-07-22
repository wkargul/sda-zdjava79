package pl.sdacademy.java.spring.homework.data.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.Set;

/**
 * Warstwa serwisowa obsługująca pracowników.
 *
 * UWAGA: w razie potrzeby można rozszerzyć interfejs o dodatkowe metody.
 */
public interface EmployeeService {

    /**
     * Utrwala podanego pracownika i zwraca zapisany obiekt encyjny, z nadanym identyfikatorem.
     * @param employee obiekt do utrwalenia
     * @throws SkillsNotFoundException jeśli przekazany obiekt zawiera nieistniejące umiejętności
     */
    Employee createEmployee(Employee employee) throws SkillsNotFoundException;

    /**
     * Zwraca pracownika wg id
     * @param id id pracownika
     * @return optional opakowujący pracownika lub pusty jeśli nie znaleziono
     */
    Optional<Employee> getEmployee(long id);

    /**
     * Generuje pojedynczą stronę wyników znalezionych pracowników.
     *
     * <p>
     * UWAGA: do filtrowania po umiejętnościach można podejść dwojako:
     * <ol>
     *     <li>powinna się zgadzać choć jedna umiejętność</li>
     *     <li>powinny się zgadzać wszystkie</li>
     * </ol>
     * Podejście 2. jest znacznie trudniejsze w realizacji i w związku z tym - całkowicie opcjonalne.
     * </p>
     *
     * Podpowiedź: w przypadku filtrowania wg retired dobrym punktem wyjścia może być wyszukiwanie wg zakresu dat.
     *
     * @param retired określa czy szukać pracowników emerytowanych lub nieemerytowanych. Jeśli nie podane, należy zwrócić wszystkich.
     * @param skills określa pożądany zbiór umiejętności. Jeśli nie podane, należy zwrócić wszystkich.
     * @param pageable informacje o stronicowaniu
     * @return strona wyników
     */
    Page<Employee> getEmployees(Boolean retired, Set<String> skills, Pageable pageable);
}
