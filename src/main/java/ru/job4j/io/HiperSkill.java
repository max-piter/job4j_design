package ru.job4j.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HiperSkill {

    public static void printRangeToFile(File file, boolean append, int fromIncl, int toExcl) {
        try (FileWriter writer = new FileWriter(file, append)) {
            for (int i = fromIncl; i < toExcl; i++) {
                writer.write(i + " ");
            }
        } catch (IOException e) {
            System.out.printf("An exception occurred %s", e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        File file = new File("HiperSkill.txt");
       try (FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(file)) {
           printWriter.print("Lorem ipsum ");
           printWriter.print("dolor sit amet");
       }

    }
}
