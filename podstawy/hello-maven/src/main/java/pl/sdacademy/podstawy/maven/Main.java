package pl.sdacademy.podstawy.maven;

import java.util.Arrays;

public class Main {
    public static void main(String... args) {
        System.out.println("Hello maven!");
        for (String arg : args) {
            System.out.println(arg);
        }

        final int[] values = new int[args.length];
        for (int i = 0;  i < args.length; i++){
            int value = Integer.parseInt(args[i]);
            values[i] = value;
        }

        System.out.println(Arrays.toString(values));
        Arrays.sort(values);
        System.out.println(Arrays.toString(values));
        Arrays.sort(args);
        System.out.println(Arrays.toString(args));
    }
}
