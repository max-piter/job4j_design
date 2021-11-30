package ru.job4j.io;

import java.io.*;
import java.util.*;

import static java.lang.String.*;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        try (BufferedReader inputFile = new BufferedReader(
                new FileReader(valueOf(argsName.get("path"))));
             PrintWriter fileOut = new PrintWriter(
                     new BufferedOutputStream(
                             new FileOutputStream(argsName.get("out"))))) {
            String[] filter = argsName.get("filter").split(",");
            Scanner scanner = new Scanner(inputFile);
            int[] indexAfterFilter = new int[filter.length];

            while (scanner.hasNext()) {
                String[] columnsHead = scanner.nextLine().split(argsName.get("delimiter"));
                for (int i = 0; i < columnsHead.length; i++) {
                    String a = columnsHead[i];
                    for (int j = 0; j < filter.length; j++) {
                        if (a.equals(filter[j])) {
                            indexAfterFilter[j] = i;
                        }
                    }
                }

                for (int j : indexAfterFilter) {
                    if (j < indexAfterFilter.length - 1) {
                        fileOut.write(columnsHead[j] + ";");
                    } else {
                        fileOut.write(columnsHead[j]);
                    }
                }
                fileOut.println();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 4) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        ArgsName argsName = ArgsName.of(args);
        CSVReader.handle(argsName);

    }
}

