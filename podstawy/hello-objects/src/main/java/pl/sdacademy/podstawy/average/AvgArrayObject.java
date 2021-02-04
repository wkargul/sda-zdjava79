package pl.sdacademy.podstawy.average;

public class AvgArrayObject {
    public static void main(String[] args) {
        double[] input = new double[] {
            4.5, 4, 4
        };

        Average average = new Average();

        for (double value : input) {
            average.putValue(value);
        }

        final double result = average.getResult();
        System.out.printf("Wynik: %.2f\n", result);
    }
}
