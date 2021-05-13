package pl.sdacademy.jdbc.hello.workshop3;

import pl.sdacademy.jdbc.hello.common.City;

import java.sql.*;
import java.util.LinkedList;
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
        List<City> result = new LinkedList<>();
        try (Connection connection
                     = DriverManager.getConnection("jdbc:mysql://localhost:6306/world", "root", "example")) {
            try (PreparedStatement preparedStatement
                         = connection.prepareStatement("SELECT * FROM city WHERE CountryCode = ? ORDER BY name;")) {
                preparedStatement.setString(1, countryCode);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    City city = new City(
                            resultSet.getString("Name"),
                            resultSet.getString("CountryCode"),
                            resultSet.getString("District"),
                            resultSet.getInt("Population")
                            );
                    result.add(city);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
