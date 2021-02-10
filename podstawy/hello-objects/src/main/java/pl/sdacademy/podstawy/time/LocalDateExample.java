package pl.sdacademy.podstawy.time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateExample {
    public static void main(String[] args) {
        LocalDate newYearEve = LocalDate.of(
                2020, 12, 31
        );

        System.out.println(newYearEve);

        LocalDate currentDate = LocalDate.now();

        System.out.println(currentDate);

        newYearEve = LocalDate.parse("2020-12-31");

        System.out.println(newYearEve);

        System.out.println(currentDate.isAfter(newYearEve));

        LocalDate newYear = newYearEve.plusDays(1);
        System.out.println("Niezmieniona: " + newYearEve);
        System.out.println("Nowa wartość: " + newYear);

        System.out.println(LocalDate.MIN);
        System.out.println(LocalDate.MAX);

        DateTimeFormatter americanFormatter = DateTimeFormatter.ofPattern("MM/dd/yy");
        System.out.println(americanFormatter.format(newYearEve));
        LocalDate parsedAllSaints = LocalDate.parse( "11/01/20", americanFormatter);
        System.out.println(parsedAllSaints);
        System.out.println(americanFormatter.format(parsedAllSaints));
    }
}
