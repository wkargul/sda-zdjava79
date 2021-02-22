package pl.sdacademy.podstawy.homework3.numerology;

import java.util.Arrays;

public class Numerology {
    private Numerology() {}

    public static int sumDigits(long number) {
        if (number < 0) {
            number = number * -1;
        }

        int sum = 0;

        while (number > 0) {
            int result = (int) number % 10;
            sum = sum + result;
            number = number / 10;
        }

        return sum;
    }

    public static int sumAllDigits(long number) {
        while (number > 10) {
            number = sumDigits(number);
        }

        return  (int) number;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString("123456".split("")));
    }
}
