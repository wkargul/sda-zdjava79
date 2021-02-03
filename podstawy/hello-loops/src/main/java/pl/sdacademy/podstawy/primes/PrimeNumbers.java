package pl.sdacademy.podstawy.primes;

public class PrimeNumbers {
    public static void main(String[] args) {
        long[] someNumbers = new long[] {
                3, 4, 5, 9, 12, 13, 14, 15, 21, 22, 23,
                1471, 1472, 981_123_456_789L
        };

        boolean[] results = new boolean[someNumbers.length];

        for (int i = 0; i < someNumbers.length; i++) {
            results[i] = isPrime(someNumbers[i]);
        }

        for (int i = 0; i < someNumbers.length; i++) {
            System.out.printf("%d : %b\n", someNumbers[i], results[i]);
        }
    }

    public static boolean isPrime(long number) {
        for (long divisor = 2; divisor < number/2; divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }

        return true;
    }
}
