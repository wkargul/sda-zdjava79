package pl.sdacademy.podstawy.homework3.miles;

public class Converter {
    private static final double MILE_LENGTH_KM = 1.609344;

    private Converter() {}

    public static double milesToKilometers(double miles) {
        return miles * MILE_LENGTH_KM;
    }
}
