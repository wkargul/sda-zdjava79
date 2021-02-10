package pl.sdacademy.podstawy.patterns;

public class ReplaceExample {
    public static void main(String[] args) {
        String txt = "W latach 1914-1939 Polska była niepodległa.";
        String censored = txt.replaceAll("\\d{4}", "XXXX");
        System.out.println(txt);
        System.out.println(censored);
    }
}
