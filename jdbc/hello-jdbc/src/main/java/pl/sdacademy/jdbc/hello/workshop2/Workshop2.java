package pl.sdacademy.jdbc.hello.workshop2;

import java.util.List;
import java.util.Scanner;

public class Workshop2 {
    public static void main(String[] args) {
        System.out.println("Podaj nazwę kontynentu:");
        final String continent = new Scanner(System.in).nextLine();

        List<String> countries = getCountries(continent);
        final String countriesString = String.join("\n", countries);
        System.out.println(countriesString);
    }

    private static List<String> getCountries(String continent) {
        throw new UnsupportedOperationException("TODO");
    }
}
