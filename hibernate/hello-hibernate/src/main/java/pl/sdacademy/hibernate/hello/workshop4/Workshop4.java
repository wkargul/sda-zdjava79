package pl.sdacademy.hibernate.hello.workshop4;

import pl.sdacademy.hibernate.hello.common.City;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Workshop4 {
    public static void main(String[] args) {
        System.out.println("Podaj kod kraju:");
        final String countryCode = new Scanner(System.in).nextLine();

        List<City> cities = getCities(countryCode);
        final String citiesString = cities.stream().map(City::toString).collect(Collectors.joining("\n"));
        System.out.println(citiesString);
    }

    public static List<City> getCities(String countryCode) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("HelloHibernatePU");
        final EntityManager em = emf.createEntityManager();
        try {
            final TypedQuery<City> query = em.createQuery(
                    //"SELECT c FROM City c WHERE c.country.code = :countryCode ORDER by c.name", //generuje dodatkowe zapytania
                    "SELECT c FROM City c JOIN FETCH c.country WHERE c.country.code = :countryCode ORDER by c.name",
                    City.class
            );
            query.setParameter("countryCode", countryCode);

            return query.getResultList();
        }
        finally {
            emf.close();
        }
    }
}
