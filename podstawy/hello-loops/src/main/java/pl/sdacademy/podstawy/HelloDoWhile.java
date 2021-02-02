package pl.sdacademy.podstawy;

import java.util.Scanner;

public class HelloDoWhile {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int x;

        //do-while wykonuje blok ZAWSZE, a potem dopóki warunek spełniony
        //przydatne gdy warunek zależy od wartości w bloku
        do {
            System.out.println("Podaj wartość mniejszą od 10");
            x = scanner.nextInt();
        }
        while(x >= 10);

        System.out.println("Poprawna wartość: " + x);
    }
}
