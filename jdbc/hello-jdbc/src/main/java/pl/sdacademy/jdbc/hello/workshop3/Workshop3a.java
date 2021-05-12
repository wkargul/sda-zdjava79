package pl.sdacademy.jdbc.hello.workshop3;

import pl.sdacademy.jdbc.hello.common.City;

import java.sql.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Workshop3a {
    public static void main(String[] args) throws SQLException {
        System.out.println("Podaj kod kraju:");
        final String countryCode = new Scanner(System.in).nextLine();

        List<City> cities = getCities(countryCode);
        final String citiesString = cities.stream().map(City::toString).collect(Collectors.joining("\n"));
        System.out.println(citiesString);
    }

    private static List<City> getCities(String countryCode) throws SQLException {
        throw new UnsupportedOperationException("TODO");
    }
}
