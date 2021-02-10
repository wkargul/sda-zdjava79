package pl.sdacademy.podstawy.patterns;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RegularExpressionExample {
    public static void main(String[] args) {
        String[] dateExamples = new String[] {
            "2020-12-31",
            "Ala ma kota",
            "20-01-201",
            "2020/11/02",
            "12020-12-31",
            "1943-12-05"
        };

        DateTimeFormatter americanFormatter = DateTimeFormatter.ofPattern("MM/dd/yy");

        for (String example : dateExamples) {
            boolean match = example.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}$");
            System.out.printf("%s: %b", example, match);

            if (match) {
                LocalDate date = LocalDate.parse(example);
                System.out.print("; us date: " + americanFormatter.format(date));
            }

            System.out.println();
        }

        System.out.println("----------");


        String[] doubleExamples = new String[] {
            "2.0",
            "-1",
            "22",
            "22.34",
            "3.141592",
            "kot",
            "-0.1",
            "-00.9",
            "214241d3",
            "9 99 00",
            "1999999222",
            "50."
        };

        for (String example : doubleExamples) {
            boolean match = example.matches("^-?\\d+(\\.\\d+)?$");
            System.out.printf("%s: %b", example, match);

            if (match) {
                double value = Double.parseDouble(example);
                System.out.printf("; %.2f", value);
            }

            System.out.println();
        }
    }
}
