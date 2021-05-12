package pl.sdacademy.jdbc.hello.workshop4;

import pl.sdacademy.jdbc.hello.common.City;

import java.sql.*;
import java.util.List;

public class Workshop4 {
    public static void main(String[] args) throws SQLException {
        List<City> cities = List.of(
            new City("Aaaaaa", "POL", "Mazowieckie", 100),
            new City("Bbbbbb", "POL", "Mazowieckie", 200),
            new City("Cccccc", "XYZ", "Mazowieckie", 200)
        );

        addCities(cities);
    }

    private static void addCities(List<City> cities) throws SQLException {
        throw new UnsupportedOperationException("TODO");
    }
}
