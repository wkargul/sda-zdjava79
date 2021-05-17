package pl.sdacademy.hibernate.hello.workshop3;

import pl.sdacademy.hibernate.hello.common.Country;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Workshop3 {
    public static void main(String[] args) {
        System.out.println("Podaj nazwę kontynentu:");
        final String continent = new Scanner(System.in).nextLine();

        final List<Country> country = getCountries(continent);
        final String countriesString = country.stream().map(Country::toString).collect(Collectors.joining("\n"));
        System.out.println(countriesString);
    }

    public static List<Country> getCountries(String continent) {
        throw new UnsupportedOperationException("TODO");
    }
}
