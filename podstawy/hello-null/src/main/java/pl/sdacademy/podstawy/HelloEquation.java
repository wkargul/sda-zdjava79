package pl.sdacademy.podstawy;

public class HelloEquation {
    public static void main(String[] args) {
        String string1 = "Hello";
        String string2 = "Hello";
        String string3 = new String("Hello");

        //Weryfikuje tożsamość obiektów (czy to ten sam egzemplarz)
        System.out.println(string1 == string2);
        System.out.println(string1 == string3);

        //Weryfikuje równoznaczność (czy ta sama treść)
        System.out.println(string1.equals(string3));
        System.out.println("Hello".equals(string3)); //bezpieczniejsze
        System.out.println(string3.equals("Hello"));
    }
}
