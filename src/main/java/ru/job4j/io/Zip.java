package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public static void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream oZip = new ZipOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(target)))) {
            for (Path fileInput : sources) {
                oZip.putNextEntry(new ZipEntry(fileInput.toFile().getAbsolutePath()));
                try (BufferedInputStream iZip = new BufferedInputStream(new FileInputStream(String.valueOf(fileInput)))) {
                    oZip.write(iZip.readAllBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            throw new IllegalArgumentException("Указаны не все аргументы");
        }
        ArgsName argsName = ArgsName.of(args);
        Path start = Paths.get(argsName.get("d"));
        String exclude = argsName.get("e");
        File output = new File(argsName.get("o"));

        List<Path> filesWithoutExcluded = new ArrayList<>();

        try {
            filesWithoutExcluded = Search.search(start, f -> !f.toFile().getName().endsWith(exclude));
        } catch (IOException e) {
            e.printStackTrace();
        }
        packFiles(filesWithoutExcluded, output);

    }
}
