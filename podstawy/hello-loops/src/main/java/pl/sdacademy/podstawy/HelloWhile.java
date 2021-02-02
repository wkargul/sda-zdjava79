package pl.sdacademy.podstawy;

public class HelloWhile {
    public static void main(String[] args) {
        int a = 5;

        //if wykonuje blok JEŻELI warunek jest spełniony
        if (a > 1) {
            System.out.println("if a > 1");
        }

        //while wykonuje blok DOPÓKI warunek jest spełniony
        while (a > 1) {
            System.out.println("while a > 1; a: " + a);
            a--;
            //break; //natychmiastowo kończy pętlę
        }

        System.out.println("za pętlą");
    }
}
