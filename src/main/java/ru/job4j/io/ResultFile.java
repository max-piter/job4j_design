package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class ResultFile {
    public static void main(String[] args) {
        int size = 9;
        int[][] array =  new int[size][size];
        try (FileOutputStream fileOut = new FileOutputStream("Matrix.text")) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    array[i][j] =   ((i + 1) * (j + 1));
                    String s = array[i][j] + "   ";
                    if (array[i][j] > 10) {
                        s = array[i][j] + "  ";
                    }
            fileOut.write(s.getBytes());
                }
            fileOut.write(System.lineSeparator().getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
