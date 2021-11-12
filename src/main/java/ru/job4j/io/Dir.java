package ru.job4j.io;

import java.io.File;
import java.util.Objects;

/**
 * The type Dir - class for checking directory.
 */
public final class Dir {

    private Dir() { }


    /**
     * The entry point of application - entry point.
     *
     * @param args the input arguments -  args
     */
    public static void main(final String[] args) {

        File file = new File("/Users/a123/projects");
        if (!file.exists()) {
            throw new IllegalArgumentException(String
                    .format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String
                    .format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.printf("size : %s%n", file.getTotalSpace());


        for (File subfile : Objects.requireNonNull(file.listFiles())) {
            System.out.println(subfile.getName() + " : " + subfile.length());
        }
    }
}
