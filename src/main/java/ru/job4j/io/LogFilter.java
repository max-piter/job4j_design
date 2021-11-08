package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> listFromFile = new ArrayList<>();
        try (BufferedReader inputFile = new BufferedReader(new FileReader(file))) {
          listFromFile =  inputFile.lines()
                  .filter(line -> line.split(" ")[line.split(" ").length - 2].equals("404"))
                  .map(line -> line + "\n")
                  .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return listFromFile;
    }

    public static void main(String[] args) {
        try {
            FileOutputStream   fileOut = new FileOutputStream("log.txt");
            String s = "0:0:0:0:0:0:0:1 - - [19/Feb/2020:15:21:18 +0300] \"GET /items/ajax.html HTTP/1.1\" 404 1113\n"
                    + "0:0:0:0:0:0:0:1 - - [19/Feb/2020:15:21:23 +0300] \"GET /job4j.ru/profile HTTP/1.1\" 302 -\n"
                    + "0:0:0:0:0:0:0:1 - - [19/Feb/2020:15:21:23 +0300] \"GET /job4j.ru/profile/ HTTP/1.1\" 404 1110\n"
                    + "0:0:0:0:0:0:0:1 - - [19/Feb/2020:15:21:34 +0300] \"GET /job4j.ru/profileNew/ HTTP/1.1\" 404 -\n"
                    + "0:0:0:0:0:0:0:1 - - [19/Feb/2020:15:21:48 +0300] \"GET / HTTP/1.1\" 200 11488\n"
                    + "0:0:0:0:0:0:0:1 - - [19/Feb/2020:15:21:49 +0300] \"GET /tomcat.png HTTP/1.1\" 200 5103\n"
                    + "0:0:0:0:0:0:0:1 - - [19/Feb/2020:15:21:49 +0300] \"GET /tomcat.css HTTP/1.1\" 200 5931\n"
                    + "0:0:0:0:0:0:0:1 - - [19/Feb/2020:15:21:49 +0300] \"GET /bg-nav.png HTTP/1.1\" 200 1401\n"
                    + "0:0:0:0:0:0:0:1 - - [19/Feb/2020:15:21:49 +0300] \"GET /bg-button.png HTTP/1.1\" 200 713\n"
                    + "0:0:0:0:0:0:0:1 - - [19/Feb/2020:15:21:49 +0300] \"GET /bg-middle.png HTTP/1.1\" 200 1918";
            fileOut.write(s.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> log = filter("log.txt");
        System.out.println(log);
    }
}
