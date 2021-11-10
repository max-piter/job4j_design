package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> listFromFile = new ArrayList<>();
        try (BufferedReader inputFile = new BufferedReader(new FileReader(file))) {

            /*
             * listFromFile =  inputFile.lines()
             *                   .filter(line -> line.split(" ")[line.split(" ").length - 2].equals("404"))
             *                   .map(line -> line + "\n")
             *                   .collect(Collectors.toList());
             */
            String line;
            while ((line = inputFile.readLine()) != null) {
                String[] lineFromFile = line.split(" ");
                if (lineFromFile[lineFromFile.length - 2].equals("404")) {
                    listFromFile.add(line + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listFromFile;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter fileOut = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            fileOut.println(log);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
       save(log, "404.txt");
    }
}
