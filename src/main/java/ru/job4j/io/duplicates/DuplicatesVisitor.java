package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/**
 * The type Duplicates visitor.
 * class - logic to search for duplicates
 * using Map & List
 */
public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    /**
     * The Files.
     * Map conteiner to store  duplicates
     */
    Map<FileProperty, List<Path>> files = new HashMap<>();

    /**
     * FileVisitResult.
     * method to be performed while visiting the current file
     * find duplicates, storing them in arrayList
     * @param file - current file
     * @param attrs - file attributes
     * @return file - fole
     * @throws IOException - excetption
     */
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
        throws IOException {

        FileProperty fP = new FileProperty(attrs.size(), file.getFileName().toString());
        if (files.containsKey(fP)) {
            List<Path> duplicats = new ArrayList<>(files.get(fP));
            duplicats.add(file);
            files.put(fP, duplicats);

        } else {
            List<Path> lst = new ArrayList<>();
            lst.add(file);
            files.put(fP, lst);
        }
        return super.visitFile(file, attrs);
    }

    /**
     * Gets duplicates.
     * method for getting duplicates.
     *
     * @return the duplicates - list of duplicates
     */
    public List<Path> getDuplicates() {
        List<Path> dup = new ArrayList<>();
        files.values()
                .stream()
                .filter(el -> el.size() > 1)
                .forEach(dup::addAll);
        return dup;
    }
}