package pl.sdacademy.hibernate.sakila.workshop16;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

/**
 * Warsztat 16 – użycie modyfikującego JPQL
 * • Zmodyfikuj metodę z warsztatu 12 tak, by zwracała ilość
 * zmienionych rekordów
 * • Użyj JPQL do zmiany nazwy kraju według podanego id
 */
public class Workshop16 {
    public static void main(String[] args) {
        System.out.println("Podaj id kraju:");
        final int countryId = new Scanner(System.in).nextInt();

        System.out.println("Podaj nazwę kraju:");
        final String countryName = new Scanner(System.in).nextLine();

        int changedRows =  updateCountry(countryId, countryName);

        System.out.printf("Zmienione rekordy: %d\n", changedRows);
    }

    public static int updateCountry(int countryId, String countryName) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("SakilaPU");
        final EntityManager em = emf.createEntityManager();

        try {
            throw new UnsupportedOperationException("TODO");
        }
        finally {
            emf.close();
        }
    }
}
