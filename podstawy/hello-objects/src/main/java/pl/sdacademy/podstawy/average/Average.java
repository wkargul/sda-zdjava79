package pl.sdacademy.podstawy.average;

public class Average {
    private double sum;
    private int count;

    public void putValue(double value) {
        sum = sum + value;
        count++;
    }

    public double getResult() {
        return sum/count;
    }
}
