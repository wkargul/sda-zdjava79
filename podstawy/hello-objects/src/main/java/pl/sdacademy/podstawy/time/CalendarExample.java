package pl.sdacademy.podstawy.time;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarExample {
    public static void main(String[] args) {
        GregorianCalendar calendar = new GregorianCalendar(
            2020, Calendar.DECEMBER, 31
        );

        Date date = calendar.getTime();

        System.out.println(date);

        calendar.add(Calendar.DAY_OF_MONTH, 1);

        date = calendar.getTime();

        System.out.println(date);
    }
}
