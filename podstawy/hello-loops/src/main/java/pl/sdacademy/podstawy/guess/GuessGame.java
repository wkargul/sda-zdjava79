package pl.sdacademy.podstawy.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    public static final int TRIES = 5;
    public static final int BOUNDARY = 100;

    public static void main(String[] args) {
        final Random random = new Random();
        final Scanner scanner = new Scanner(System.in);

        //+1 żeby wartości były 1-100 zamiast 0-99
        final int secret = random.nextInt(BOUNDARY) + 1;

        System.out.println("*** Z-G-A-D-Y-W-A-N-K-A ***");
        System.out.println("Podpowiedź: " + secret);

        int guess;
        int count = 0;
        do {
            System.out.printf("Podaj wartość. Pozostało %d prób:\n", TRIES-count);
            guess = scanner.nextInt();
            count++;

            if (guess > secret) {
                System.out.println("Za duża liczba!");
            }
            else if (guess < secret) {
                System.out.println("Za mała liczba!");
            }
        }
        while (guess != secret && count < TRIES);

        if (guess != secret) {
            System.out.println("Przegrana! Za dużo prób.");
        }
        else {
            System.out.printf("Brawo! Wygrana w %d próbach.\n", count);
        }
    }
}
