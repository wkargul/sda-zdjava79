package pl.sdacademy.jdbc.hello.workshop3;

import pl.sdacademy.jdbc.hello.common.City;

import java.sql.*;
import java.util.Scanner;

public class Workshop3b {
    public static void main(String[] args) throws SQLException {
        System.out.println("Podaj nazwę miasta:");
        final String name = new Scanner(System.in).nextLine();

        System.out.println("Podaj kod kraju:");
        final String countryCode = new Scanner(System.in).nextLine();

        System.out.println("Podaj jednostkę administracyjną:");
        final String district = new Scanner(System.in).nextLine();

        System.out.println("Podaj liczbę mieszkańców:");
        final int population = new Scanner(System.in).nextInt();

        final City city = new City(name, countryCode, district, population);
        boolean result = addCity(city);
        System.out.println(result);
    }

    private static boolean addCity(City city) throws SQLException {
        throw new UnsupportedOperationException("TODO");
    }
}
