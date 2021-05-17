package pl.sdacademy.hibernate.hello.workshop2;

import pl.sdacademy.hibernate.hello.common.Country;

import java.util.List;
import java.util.stream.Collectors;

public class Workshop2 {
    public static void main(String[] args) {
        final List<Country> country = getCountries();
        final String countriesString = country.stream().map(Country::toString).collect(Collectors.joining("\n"));
        System.out.println(countriesString);
    }

    public static List<Country> getCountries() {
        throw new UnsupportedOperationException("TODO");
    }
}
