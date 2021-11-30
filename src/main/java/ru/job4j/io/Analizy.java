package ru.job4j.io;

import java.io.*;

/**
 * The type Analizy - class for reading , processing & writing info.
 */
public class Analizy {


    /**
     * Unavailable - метод выявления недоступности сервера.
     *
     * @param source the source - файл, источник информации
     * @param target the target - файл, куда записывать полученную инфо
     */
    public void unavailable(final String source,  final String target) {
        try (BufferedReader inputFile = new BufferedReader(
                new FileReader(source));
             PrintWriter fileOut = new PrintWriter(
                     new BufferedOutputStream(
                             new FileOutputStream(target)))) {
            StringBuilder builder = new StringBuilder();
            String tmp = null;
            String line;
            while ((line = inputFile.readLine()) != null) {
                String[] arrayFromFile = line.split(" ");
                    if ("400".equals(arrayFromFile[0])
                            || "500".equals(arrayFromFile[0])) {
                        if (!"400".equals(tmp) && !"500".equals(tmp)) {
                            tmp = arrayFromFile[0];
                            builder.append(arrayFromFile[1]).append(";");
                        }
                    } else if (("400".equals(tmp)) || "500".equals(tmp)) {
                        tmp = null;
                        builder.append(arrayFromFile[1]).append(";");
                        fileOut.println(builder);
                        builder.delete(0, builder.length());
                    }
                }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * The entry point of application - точка доступа в программу.
     *
     * @param args the input arguments - args
     */
    public static void main(final String[] args) {

        Analizy firstTest = new Analizy();
        firstTest.unavailable("source.csv", "unavailable.csv");



    }
}
