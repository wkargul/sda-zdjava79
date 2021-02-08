package pl.sdacademy.podstawy.homework2.fibonacci;

public class Fibonacci {
    private long value1 = 0; //wyraz ciągu zwracany przy kolejnym wywołaniu next()
    private long value2 = 1; //jeszcze następny wyraz

    public long next() {
        final long next = value1; //szykujemy zawczasu następny wyraz ciągu, bo value1 i value2 się zmienią
        value1 = value2; //pierwszy wyraz ciągu przepada zastąpione przez kolejny
        value2 = value2 + next; //next to poprzednie value1, więc zaktualizowane value2 to suma starych value1 i value2
        return next;
    }
}
