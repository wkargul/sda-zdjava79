package pl.sdacademy.podstawy.homework2.fibonacci;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj oczekiwaną liczbę wyrazów ciągu Fibonacciego:");
        final int count = scanner.nextInt();

        final Fibonacci fibonacci = new Fibonacci();

        final long[] result = new long[count];
        for (int i = 0; i < result.length; i++) {
            result[i] = fibonacci.next();
        }

        System.out.println(Arrays.toString(result));
    }
}
