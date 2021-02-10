package pl.sdacademy.podstawy.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalTimeExample {
    public static void main(String[] args) {
        LocalTime time = LocalTime.of(16, 15, 45);
        System.out.println(time);

        LocalDate xmasEve = LocalDate.of(2020,12,24);

        LocalDateTime firstStar = LocalDateTime.of(xmasEve, time);
        System.out.println(firstStar);

        System.out.println(LocalTime.MIN);
        System.out.println(LocalTime.MAX);
    }
}
