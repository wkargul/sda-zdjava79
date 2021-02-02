package pl.sdacademy.podstawy.arrays;

import java.util.Arrays;

public class HelloArray {
    public static void main(String[] args) {
        //pusta tablica
        final int[] emptyArray = new int[5];
        final Integer[] emptyIntegerArray = new Integer[5];

        //wstępnie zdefiniowane wartości
        final int[] predefinedArray = new int[] { 1, 2, 3, 4, 5 };
        final Integer[] predefinedIntegerArray = new Integer[] { 1, 2, 3, 4, 5 };

        System.out.println("emptyArray: " + Arrays.toString(emptyArray));
        System.out.println("emptyIntegerArray: " + Arrays.toString(emptyIntegerArray));
        System.out.println("predefinedArray: " + Arrays.toString(predefinedArray));
        System.out.println("predefinedIntegerArray: " + Arrays.toString(predefinedIntegerArray));

        String[] strings = new String[] { "a", "b", "c" };
        System.out.println("strings: " + Arrays.toString(strings));

        //Zmiana wartości tablicy wg indeksu i dostęp wg indeksu
        emptyArray[0] = 10;
        System.out.println("emptyArray: " + Arrays.toString(emptyArray));
        System.out.println("emptyArray[0]: " + emptyArray[0]);

        //Dozwolony zakres: od 0 do ROZMIAR-1
        //emptyArray[-5] = 10;

        //Tradycyjny for (length to rozmiar tablicy)
        for (int i = 0; i < predefinedArray.length ; i++) {
            System.out.printf("predefinedArray[%d]: %d\n", i, predefinedArray[i]);
        }

        //foreach
        for (int value : predefinedArray) {
            System.out.println("foreach: " + value);
        }
    }
}
