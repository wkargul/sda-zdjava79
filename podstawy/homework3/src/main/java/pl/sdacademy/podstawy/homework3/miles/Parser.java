package pl.sdacademy.podstawy.homework3.miles;

public class Parser {

    private Parser() {}

    /**
     * Returns parsed value if input is valid, {@code null} otherwise.
     */
    public static Double safeParse(String input) {
        if (input != null && input.matches("^-?\\d+(\\.\\d+)?$")) {
            return Double.parseDouble(input);
        }

        return null;
    }
}
