package pl.sdacademy.podstawy.average;

import java.util.Scanner;

public class AvgInputObject {
    public static void main(String[] args) {
        Scanner scanner  =  new Scanner(System.in);
        Average average = new Average();
        boolean run;
        do{
            String value;
            System.out.print("Podaj wartość: ");
            value = scanner.next();
            run = !value.equalsIgnoreCase("X");
            if(run){
                average.putValue(Double.parseDouble(value));
            }
        } while(run);

        System.out.println(
                String.format(
                        "średnia wprowadzonych wartości wynosi: %.2f",
                        average.getResult()
                )
        );
    }
}
