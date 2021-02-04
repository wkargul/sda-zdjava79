package pl.sdacademy.podstawy.average;

public class AvgArray {
    public static void main(String[] args) {
        double[] input = new double[] {
            4.5, 4, 4
        };

        double sum = 0;

        for (double value : input) {
            sum = sum + value;
        }

        final double result = sum/input.length;
        System.out.printf("Wynik: %.2f\n", result);
    }
}
