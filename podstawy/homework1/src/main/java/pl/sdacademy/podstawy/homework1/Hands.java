package pl.sdacademy.podstawy.homework1;

import java.util.Scanner;

public class Hands {
    private static final int MINUTE_HAND_STEP = 6;
    private static final int HOUR_HAND_HOUR_STEP = 30;
    private static final double HOUR_HAND_MINUTE_STEP = 0.5;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj godzinę");
        final int h = scanner.nextInt();
        if (h < 1 || h > 12) {
            System.out.println("Niepoprawna godzina");
        }

        System.out.println("Podaj minuty");
        final int m = scanner.nextInt();
        if (m < 0 || h > 59) {
            System.out.println("Niepoprawne minuty");
        }

        System.out.printf("Kąt między wskazówkami: %.2f\n", handsAngle(h, m));
    }

    public static double handsAngle(int h, int m) {
        int minuteHandAngle = m * MINUTE_HAND_STEP;
        double hourHandAngle = h * HOUR_HAND_HOUR_STEP + m * HOUR_HAND_MINUTE_STEP;

        double difference = minuteHandAngle - hourHandAngle;
        if (difference < 0) {
            difference = difference * -1;
        }

        if (difference > 180) {
            difference = 360 - difference;
        }

        return difference;
    }
}
