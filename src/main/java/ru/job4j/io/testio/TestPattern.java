package ru.job4j.io.testio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPattern {
    public static void main(String[] args) {

        String text = "000111010001110001011000001110";
        Pattern textPattern = Pattern.compile(".110");
        Matcher textMatcher = textPattern.matcher(text);
        int count = 0;

       Pattern name = Pattern.compile("[\\w|*]+.[a-z]+");
       System.out.println("log.txt".matches(String.valueOf(name)));
        Pattern absolutePath;
        absolutePath = Pattern.compile("[/a-zA-Z0-9\\w .?a-z+]+");
        System.out.println("/Users/a123/projects/job4j_design/testIO4.txt"
                .matches(String.valueOf(absolutePath)));

       while (textMatcher.find()) {
           count++;
       }
        System.out.println(count);
    }
}
