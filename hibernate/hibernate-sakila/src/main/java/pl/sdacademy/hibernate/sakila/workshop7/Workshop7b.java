package pl.sdacademy.hibernate.sakila.workshop7;

import java.util.List;
import java.util.Scanner;

/**
 * Warsztat 7b – wyszukiwanie aktorów według opisu
 * • Zmodyfikuj funkcję i zapytanie JPQL z poprzedniego zadania tak, by
 * wyszukiwać aktorów według opisów filmów w których grali
 * • Posortuj wyniki według:
 *   • Nazwiska,
 *   • Imienia,
 *   • Tytułu filmu
 */
public class Workshop7b {
    public static void main(String[] args) {
        System.out.println("Podaj fragment opisu:");
        final String descriptionPart = new Scanner(System.in).nextLine();

        final List<Actor> actors = findActorsByFilmDescription(descriptionPart);
        final StringBuilder sb = new StringBuilder();
        for (Actor actor : actors) {
            sb.append(actor.getFirstName()).append(" ").append(actor.getLastName()).append("\n");
            for (Film film : actor.getFilms()) {
                sb.append("\t").append(film.getTitle()).append(" (").append(film.getDescription()).append(")").append("\n");
            }
        }

        System.out.println(sb);
    }

    public static List<Actor> findActorsByFilmDescription(String descriptionPart) {
        throw new UnsupportedOperationException("TODO");
    }
}
