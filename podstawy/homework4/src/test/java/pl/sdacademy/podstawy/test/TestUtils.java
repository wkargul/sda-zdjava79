package pl.sdacademy.podstawy.test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public class TestUtils {
    private TestUtils() {}
    
    public static Clock clockFixture(Instant instant) {
        return Clock.fixed(instant, ZoneId.of("UTC"));
    }
}
