package pl.sdacademy.podstawy.homework3.miles;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final String result;

        if (args.length == 0) {
            result = handleUserInput();
        }
        else {
            result = handleArgs(args);
        }

        System.out.println(result);
    }

    private static String handleUserInput() {
        final Scanner scanner = new Scanner(System.in);
        Double input;

        System.out.println("Podaj wartość w milach:");

        do {
            input = Parser.safeParse(scanner.next());
        }
        while(!isMilesValid(input));

        return prepareOutputString(input);
    }

    private static String handleArgs(String... args) {
        final StringBuilder sb = new StringBuilder();

        for (String arg : args) {
            final Double miles = Parser.safeParse(arg);
            if (isMilesValid(miles)) {
                sb.append(prepareOutputString(miles)).append("\n");
            }
        }

        return sb.toString();
    }

    private static boolean isMilesValid(Double miles) {
        return miles != null && miles > 0;
    }

    private static String prepareOutputString(double miles) {
        return String.format("%.2f mi \u2248 %.2f km", miles, Converter.milesToKilometers(miles));
    }
}
