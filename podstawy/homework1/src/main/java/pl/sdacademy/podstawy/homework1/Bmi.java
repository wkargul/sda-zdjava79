package pl.sdacademy.podstawy.homework1;

import java.util.Scanner;

public class Bmi {
    static final int BMI_UNDERWEIGHT = -1;
    static final int BMI_NORMAL = 0;
    static final int BMI_OVERWEIGHT = 1;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj wzrost (m)");
        final double bodyHeight = scanner.nextDouble();
        if (bodyHeight <= 1.0) {
            System.out.println("Wzrost nie może być mniejszy od 1m");
            return;
        }

        System.out.println("Podaj masę ciała (kg)");
        final double bodyMass = scanner.nextDouble();
        if (bodyMass <= 1.0) {
            System.out.println("Masa ciała nie może być mniejsza od 1m");
            return;
        }

        final double bmi = bmi(bodyHeight, bodyMass);
        final int estimatedBmi = estimateBmi(bmi);

        if (estimatedBmi == BMI_UNDERWEIGHT) {
            System.out.println("Niedowaga");
        }
        else if (estimatedBmi == BMI_NORMAL) {
            System.out.println("Waga normalna");
        }
        else if (estimatedBmi == BMI_OVERWEIGHT) {
            System.out.println("Nadwaga");
        }
    }

    public static double bmi(double bodyHeight, double bodyMass) {
        return bodyMass / (bodyHeight * bodyHeight);
    }

    public static int estimateBmi(double bmi) {
        if (bmi < 18.5) {
            return BMI_UNDERWEIGHT;
        }
        else if (bmi < 25) {
            return BMI_NORMAL;
        }
        else {
            return BMI_OVERWEIGHT;
        }
    }
}
