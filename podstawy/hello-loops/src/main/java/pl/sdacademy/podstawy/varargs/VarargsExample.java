package pl.sdacademy.podstawy.varargs;

public class VarargsExample {
    public static void main(String... args) {
        final String[] alaMaKota = new String[] { "Ala", "ma", "kota" };
        printReversed(alaMaKota);
        printReversedVarargs(alaMaKota);
        printReversedVarargs("Janek", "ma", "psa");
        printReversedVarargs("Zuzia");
        printReversedVarargs();
    }

    public static void printReversed(String[] array) {
        for (int i = (array.length - 1); i >= 0; i--) {
            System.out.println(array[i]);
        }
    }

    public static void printReversedVarargs(String... array) {
        for (int i = (array.length - 1); i >= 0; i--) {
            System.out.println(array[i]);
        }
    }
}
