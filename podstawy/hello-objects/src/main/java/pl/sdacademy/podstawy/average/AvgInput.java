package pl.sdacademy.podstawy.average;

import java.util.Scanner;

public class AvgInput {
    public static void main(String[] args) {
        Scanner scanner  =  new Scanner(System.in);
        double sum = 0;
        int count=0;
        boolean run;
        do{
            String value;
            System.out.print("Podaj wartość: ");
            value = scanner.next();
            run = !value.equalsIgnoreCase("X");
            if(run){
                sum = sum+Double.parseDouble(value);
                count++;
            }
        } while(run);

        double result = sum/count;
        System.out.println(
                String.format(
                        "średnia wprowadzonych wartości wynosi: %.2f",result
                )
        );
    }
}
