package pl.sdacademy.podstawy.time;

import java.time.LocalDate;

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
    }
}
