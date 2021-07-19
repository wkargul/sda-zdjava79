package pl.sdacademy.java.spring.homework.rest.employee;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    /**
     * Zwraca listę wszystkich pracowników posortowanych według nazwy, urodzonych w danym zakresie dat.
     * @param dateFrom początek zakresu dat
     * @param dateTo koniec zakresu dat
     * @return Lista pracowników.
     */
    List<Employee> getEmployees(LocalDate dateFrom, LocalDate dateTo);

    /**
     * Zwraca pojedynczego pracownika według podanego kodu.
     * @param code kod pracownika
     * @return Opcjonalnie obiekt pracownika - jeśli istnieje.
     */
    Optional<Employee> getEmployee(String code);

    /**
     * Dodaje pracownika jeśli nie istnieje osoba o podanym kodzie.
     * @param employee obiekt pracownika
     * @return {@code true} jeśli pracownik nie istniał i został dodany, {@code false} jeśli nie.
     */
    boolean addEmployee(Employee employee);

    /**
     * Dodaje pracownika (jeśli osoba o podanym kodzie nie istnieje) lub zastępuje (jeśli istnieje).
     * @param employee obiekt pracownika
     * @return {@code true} jeśli pracownik nie istniał i został dodany, {@code false} jeśli został zastąpiony.
     */
    boolean addOrReplaceEmployee(Employee employee);

    /**
     * Usuwa pojedynczego pracownika według wskazanego kodu.
     * @param code kod pracownika
     * @return {@code true} jeśli pracownik istniał i został usunięty, {@code false} jeśli nie.
     */
    boolean deleteEmployee(String code);
}
