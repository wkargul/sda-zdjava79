package pl.sdacademy.podstawy.homework1;

import java.util.Scanner;

public class Fuel {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj poprzedni przebieg (km)");
        final int previousMileage = scanner.nextInt();
        if (previousMileage <= 0) {
            System.out.println("Przebieg nie może być mniejszy od 0");
            return;
        }

        System.out.println("Podaj przebieg (km)");
        final int mileage = scanner.nextInt();

        if (mileage <= previousMileage) {
            System.out.printf("Przebieg nie może być mniejszy lub równy %d\n", previousMileage);
            return;
        }

        System.out.println("Podaj ilość zatankowanych litrów");
        final double liters = scanner.nextDouble();
        if (liters <= 0) {
            System.out.println("Niepoprawna ilość litrów");
            return;
        }

        System.out.println("Podaj cenę za litr");
        final double price = scanner.nextDouble();
        if (liters <= 0) {
            System.out.println("Niepoprawna cena");
            return;
        }

        final int kilometers = mileage - previousMileage;

        System.out.printf(
                "Spalanie: %.2f l/100km; Koszty: %.2f PLN/km\n",
                calculateUsage(kilometers, liters),
                calculatePricePerKm(kilometers, liters, price)
        );
    }

    public static double calculateUsage(int kilometers, double liters) {
        return liters/kilometers * 100.0;
    }

    public static double calculatePricePerKm(int kilometers, double liters, double price) {
        return liters/kilometers * price;
    }
}
