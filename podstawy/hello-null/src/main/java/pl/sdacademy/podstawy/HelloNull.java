package pl.sdacademy.podstawy;

import java.util.Scanner;

public class HelloNull {
    public static void main(String[] args) {
        //Typy proste nie mogą być null
        //int intValue = null;
        //double doubleValue = null;
        //byte byteValue = null;

        //Zawsze spowoduje błąd (wyjątek) NullPointerException
        //Scanner scanner = null;
        //System.out.println("Podaj wartość");
        //double doubleValue = scanner.nextDouble();

        String stringValue = null;
        System.out.println(stringValue);
    }
}
