package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Log filter - class for taking information from file.
 * then filter it and save in another file
 */
public final class LogFilter {

    private LogFilter() { }

    /**
     * Filter list - method takes String information from file & filters it.
     *
     * @param file the file - the path to file
     * @return the list - filtered list
     */
    public static List<String> filter(final String file) {
        List<String> listFromFile = new ArrayList<>();
        try (BufferedReader inputFile = new BufferedReader(
                new FileReader(file))) {

            String line;
            while ((line = inputFile.readLine()) != null) {
                String[] lineFromFile = line.split(" ");
                if ("404".equals(lineFromFile[lineFromFile.length - 2])) {
                    listFromFile.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listFromFile;
    }

    /**
     * Save - method for saving info in the given file.
     *
     * @param log  the log - list of Strings,  we need to save
     * @param file the file - the path to file, where we need to save our list
     */
    public static void save(final List<String> log, final String file) {
        try (PrintWriter fileOut = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            fileOut.println(log);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments - args
     */
    public static void main(final String[] args) {
        List<String> log = filter("log.txt");
        for (String line: log) {
            System.out.println(line);
        }
       save(log, "404.txt");
    }
}
