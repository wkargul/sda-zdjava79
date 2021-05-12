package pl.sdacademy.jdbc.hello.workshop1;

import java.util.List;

public class Workshop1 {
    public static void main(String[] args) {
        List<String> countries = getCountries();
        final String countriesString = String.join("\n", countries);
        System.out.println(countriesString);
    }

    private static List<String> getCountries() {
        throw new UnsupportedOperationException("TODO");
    }
}
