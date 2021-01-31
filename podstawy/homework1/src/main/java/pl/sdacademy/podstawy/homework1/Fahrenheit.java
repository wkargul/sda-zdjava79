package pl.sdacademy.podstawy.homework1;

import java.util.Scanner;

public class Fahrenheit {
    public static void main(String[] args) {
        System.out.println("Podaj temperaturę w \u2103");

        final Scanner scanner = new Scanner(System.in);
        final double celsius = scanner.nextDouble();
        final double fahrenheit = celsiusToFahrenheit(celsius);

        System.out.printf("Wartość w \u2109: %.2f\n", fahrenheit);
    }

    public static double celsiusToFahrenheit(double celsius) {
        return celsius * 1.8 + 32;
    }
}
