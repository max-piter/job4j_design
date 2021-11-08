package ru.job4j.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream inputFile = new FileInputStream("even.txt")) {
            StringBuilder text =  new StringBuilder();
            int read;
            while ((read = inputFile.read()) != -1) {
                text.append((char) read);
            }
            int[] array = Arrays.stream(text.toString().split(System.lineSeparator()))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (Integer i: array) {
                if (i % 2 == 0) {
                    System.out.println("Even number: " + i);
                } else {
                    System.out.println("Odd number: " + i);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class WriteFile {
    public static void main(String[] args) {
            try {
                FileOutputStream fileOut = new FileOutputStream("even.txt");
                String s = "1\n"
                       + "5\n"
                       + "15\n"
                       + "17";
                fileOut.write(s.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

}
