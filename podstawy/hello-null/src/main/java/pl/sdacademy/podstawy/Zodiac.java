package pl.sdacademy.podstawy;

import java.util.Scanner;

public class Zodiac {
    public static void main(String[] args) {
        System.out.println("Podaj dzień: ");
        int day = readValue();
        if (day < 1 || day > 31) {
            System.out.println("Niepoprawny dzień!");
            return;
        }

        System.out.println("Podaj miesiąc: ");
        int month = readValue();
        if (month < 1 || month > 12) {
            System.out.println("Niepoprawny miesiąc!");
            return;
        }

        String sign;

        //Nie można przekazać null!
        //Można użyć liczb całkowitych, String, enum
        switch (month) {
            case 1: {
                if (day < 20) {
                    sign = "Koziorożec";
                } else {
                    sign = "Wodnik";
                }
                break;
            }

            case 2: {
                if (day < 19) {
                    sign = "Wodnik";
                } else {
                    sign = "Ryby";
                }
                break;
            }

            case 3: {
                if (day < 21) {
                    sign = "Ryby";
                } else {
                    sign = "Baran";
                }
                break;
            }

            default: {
                sign = "Inny";
            }
        }

        System.out.println(sign);
    }

    public static int readValue() {
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
