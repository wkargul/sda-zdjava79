package pl.sdacademy.podstawy;

public class HelloWrappers {
    public static void main(String[] args) {
        int intValue = 5;
        Integer integerValue = 5;
        integerValue = (int) 5.0;
        integerValue = null;
        integerValue = Integer.parseInt("6");
        intValue = integerValue;

        //true
        boolean equityPrimitiveAndWrapper = (intValue == integerValue);

        //tzw. null-check
        if (integerValue != null) {
            System.out.println(integerValue.doubleValue());
        }

        System.out.println(integerValue);
    }
}
