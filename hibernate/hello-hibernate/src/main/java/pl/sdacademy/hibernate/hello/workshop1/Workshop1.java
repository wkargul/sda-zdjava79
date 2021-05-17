package pl.sdacademy.hibernate.hello.workshop1;

import pl.sdacademy.hibernate.hello.common.Country;

import java.util.Scanner;

public class Workshop1 {
    public static void main(String[] args) {
        System.out.println("Podaj kod kraju:");
        final String code = new Scanner(System.in).nextLine();

        final Country country = loadCountryByCode(code);
        System.out.println(country);
    }

    public static Country loadCountryByCode(String code) {
        throw new UnsupportedOperationException("TODO");
    }
}
