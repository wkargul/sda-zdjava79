package pl.sdacademy.hibernate.sakila.workshop8;

import pl.sdacademy.hibernate.sakila.workhop6.Staff;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Warsztat 8a – ładowanie personelu razem z adresem
 * • Przygotuj zapytanie ładujące cały personel
 * • Jakie zapytania się wykonują i dlaczego?
 * • Przebuduj zapytanie JPQL tak, by ładować komplet danych jednym
 * zapytaniem SQL
 */
public class Workshop8a {
    public static void main(String[] args) {
        final List<Staff> staff = findAllStaff();
        System.out.println(staffToString(staff));
    }

    public static String staffToString(List<Staff> staff) {
        return staff.stream().map(Staff::toString).collect(Collectors.joining("\n"));
    }

    public static List<Staff> findAllStaff() {
        throw new UnsupportedOperationException("TODO");
    }
}
