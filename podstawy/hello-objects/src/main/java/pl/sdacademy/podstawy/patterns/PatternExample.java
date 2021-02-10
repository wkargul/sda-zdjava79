package pl.sdacademy.podstawy.patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternExample {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\d{4}");
        String txt = "W latach 1914-1939 Polska była niepodległa.";

        //Tworzy matcher według podanego wzorca dla wskazanego tekstu
        Matcher matcher = pattern.matcher(txt);

        //Dopóki coś znajduje, find() zwraca true
        while (matcher.find()) {
            String match = matcher.group();
            System.out.println(match);
        }
    }
}
