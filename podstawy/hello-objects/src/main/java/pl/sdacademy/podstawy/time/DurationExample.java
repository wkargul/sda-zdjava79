package pl.sdacademy.podstawy.time;

import java.time.Duration;
import java.time.LocalTime;

public class DurationExample {
    public static void main(String[] args) {
        Duration duration = Duration.ofMillis(7200000);
        System.out.println(duration);

        LocalTime localTime = LocalTime.of(14, 15);
        LocalTime timeAfterDuration = localTime.plus(duration);

        System.out.println(localTime);
        System.out.println(timeAfterDuration);
    }
}
