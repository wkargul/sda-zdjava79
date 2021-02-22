package pl.sdacademy.podstawy.homework3.dates;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final LocalDate[] dates = convert(args);

        if (dates.length == 0) {
            return;
        }

        LocalDate earliest = null;
        LocalDate latest = null;

        for (LocalDate date : dates) {
            if (earliest == null || earliest.isAfter(date)) {
                earliest = date;
            }

            if (latest == null || latest.isBefore(date)) {
                latest = date;
            }
        }

        System.out.printf(
                "Najwcześniejsza: %s, odstęp: %s\nNajpóźniejsza: %s, odstęp: %s\n",
                earliest, Period.between(LocalDate.now(), earliest),
                latest, Period.between(LocalDate.now(), latest)
        );
    }

    private static LocalDate[] convert(String... values) {
        final LocalDate[] dates = new LocalDate[values.length];

        int count = 0;

        for (final String value : values) {
            if (isValidDate(value)) {
                dates[count] = LocalDate.parse(value);
                count++;
            }
        }

        return Arrays.copyOf(dates, count);
    }

    private static boolean isValidDate(String value) {
        return value != null && value.matches("^\\d{4}-\\d{2}-\\d{2}$");
    }

    //Wykorzystanie Stream API i elementów programowania funkcyjnego - jako ciekawostka!
    private static LocalDate[] altConvert(String... values) {
        return Arrays.stream(values)
                .filter(Main::isValidDate)
                .map(LocalDate::parse)
                .toArray(LocalDate[]::new);
    }
}
