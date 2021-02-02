package pl.sdacademy.podstawy;

public class AssignmentQuirks {
    public static void main(String[] args) {

        //Operacja przypisania zwraca wartość (tę przypisywaną)
        int a = 5;
        int b = (a = a + 1);

        System.out.printf("a: %d, b: %d\n", a, b);

        //Skrócone przypisanie
        a += 2; //a = a + 2;
        a *= 2; //a = a * 2; ...itd
        System.out.printf("a: %d\n", a);

        int x;

        //Inkrementacja
        x = a++;
        System.out.printf("a++: %d, zwraca: %d\n", a, x);

        x = ++a;
        System.out.printf("++a: %d, zwraca: %d\n", a, x);

        //Dekrementacja
        x = a--;
        System.out.printf("a--: %d, zwraca: %d\n", a, x);

        x = --a;
        System.out.printf("--a: %d, zwraca: %d\n", a, x);
    }
}
