package ru.job4j.io.duplicates;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


/**
 * The type Duplicates finder.
 * class - duplicateFinder
 */
public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        DuplicatesVisitor visitor = new DuplicatesVisitor();
        Path start = Paths.get("/Users/a123/music/");
        Files.walkFileTree(start, visitor);
        List<Path> duplicates = visitor.getDuplicates();
        duplicates.forEach(System.out::println);
    }
}

