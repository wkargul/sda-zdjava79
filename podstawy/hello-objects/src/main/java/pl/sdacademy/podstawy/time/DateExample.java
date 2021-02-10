package pl.sdacademy.podstawy.time;

import java.util.Date;

public class DateExample {
    public static void main(String[] args) {
        final Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());
        System.out.println(System.currentTimeMillis());

        date.setTime(1612898553427L);
        System.out.println(date);
        System.out.println(date.getTime());
    }
}
