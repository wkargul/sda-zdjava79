package pl.sdacademy.podstawy;

public class HelloFor {
    public static void main(String[] args) {
        final int start = 0;
        final int end = 10;

        //for używamy gdy dokładnie znamy ilość wykonań
        for (int i = start; i <= end; i++)  {
            System.out.println(i);
        }

        //Gdyby zadeklarować i przed pętlą, poniższa instrukcja zadziała
        //System.out.println("nadal mamy i: " + i);
    }
}
