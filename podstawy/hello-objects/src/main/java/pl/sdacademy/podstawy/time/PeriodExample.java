package pl.sdacademy.podstawy.time;

import java.time.LocalDate;
import java.time.Period;

public class PeriodExample {
    public static void main(String[] args) {
        Period period = Period.of(5, 2, 3);
        System.out.println(period);

        LocalDate date = LocalDate.of(1963, 8, 7);
        System.out.println(date);

        LocalDate dateAfterPeriod = date.plus(period);
        System.out.println("after period: " + dateAfterPeriod);

        LocalDate dateBeforePeriod = date.minus(period);
        System.out.println("before period: " + dateBeforePeriod);

        Period otherPeriod = Period.between(dateBeforePeriod, dateAfterPeriod);
        System.out.println(otherPeriod);
        Period inversedPeriod = Period.between(dateAfterPeriod, dateBeforePeriod);
        System.out.println(inversedPeriod);
    }
}
