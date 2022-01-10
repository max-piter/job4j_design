package ru.job4j.io.testio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPattern {
    public static void main(String[] args) {
//        String text = "Егор Алла Александр";
//        Pattern pattern = Pattern.compile("[А-Я|а-я]");
//        Matcher matcher = pattern.matcher(text);
//        while (matcher.find()) {
//            System.out.print(text.substring(matcher.start(), matcher.end()));
//        }

        String text = "000111010001110001011000001110";
        Pattern textPattern = Pattern.compile(".110");
        Matcher textMatcher = textPattern.matcher(text);
        int count = 0;

//        String digit = "1123+1=2";
//        String str = "drink";
//        Pattern directory = Pattern.compile("[\\/a-zA-Z0-9]+");
//        System.out.println("/Users/a123".matches(String.valueOf(directory)));
//        Pattern optional = Pattern.compile("Nov(ember)?");
//        System.out.println("November".matches(String.valueOf(optional)));
//        Pattern beginOfLine =  Pattern.compile("^\\d+$");
//        System.out.println("23456".matches(String.valueOf(beginOfLine)));
//        Pattern date = Pattern.compile("\\d\\d[- / .]\\d\\d[- / .]\\d\\d");
//        System.out.println("29-12-22".matches(String.valueOf(date)));
       Pattern name = Pattern.compile("[\\w|*]+.[a-z]+");
       System.out.println("log.txt".matches(String.valueOf(name)));
//       Pattern path =  Pattern.compile("\\/[A-Za-z]+\\.[a-z]+");
//        System.out.println("*.java".matches(String.valueOf(path)));
//        Pattern pattern = Pattern.compile("\\d+\\+\\d=\\d");
//        Pattern p = Pattern.compile("dr[a-z]nk");
//        System.out.println(Pattern.matches("\\D+", "asdfr"));
//        Matcher m = pattern.matcher(digit);
//        Matcher m1 = p.matcher("drink");
//        System.out.println(str.matches(String.valueOf(p)));
//        System.out.println(digit.matches(String.valueOf(pattern)));
        Pattern absolutePath;
        absolutePath = Pattern.compile("[/a-zA-Z0-9\\w .?a-z+]+");
        System.out.println("/Users/a123/projects/job4j_design/testIO4.txt"
                .matches(String.valueOf(absolutePath)));

       while (textMatcher.find()) {
           //System.out.println(textMatcher.start() + " " + textMatcher.group());
           count++;
       }
        System.out.println(count);
//       while (m1.find()) {
//           System.out.print(m1.start() + " " + m1.group());
//       }
    }
}
