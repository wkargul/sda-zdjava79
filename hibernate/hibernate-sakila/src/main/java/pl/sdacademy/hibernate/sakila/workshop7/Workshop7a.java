package pl.sdacademy.hibernate.sakila.workshop7;

import java.util.List;
import java.util.Scanner;


/**
 * Warsztat 7a – wyszukiwanie filmów według opisu
 * • Wiedząc, że w JPQL dostępne są:
 *   • Instrukcja LIKE
 *   • Funkcja concat() łącząca teksty (np. concat('%', :param, '%'))
 * • Napisz funkcję wyszukującą filmy według fragmentu opisu
 * • Co się stanie w momencie pobrania informacji o aktorach?
 * • Czy @ManyToMany(fetch=FetchType.EAGER) poprawi sytuację?
 * • Czy JOIN FETCH poprawi sytuację?
 * • Jakie inne rozwiązania są możliwe?
 */
public class Workshop7a {
    public static void main(String[] args) {
        System.out.println("Podaj fragment opisu:");
        final String descriptionPart = new Scanner(System.in).nextLine();

        final List<Film> films = findFilmsByDescription(descriptionPart);
        final StringBuilder sb = new StringBuilder();
        for (Film film : films) {
            sb.append(film.getTitle()).append(" (").append(film.getDescription()).append(")").append("\n");
            for (Actor actor : film.getActors()) {
                sb.append("\t").append(actor.getFirstName()).append(" ").append(actor.getLastName()).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static List<Film> findFilmsByDescription(String descriptionPart) {
        throw new UnsupportedOperationException("TODO");
    }
}
