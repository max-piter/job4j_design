package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/**
 * The type Duplicates visitor.
 * class - logic to search for duplicates
 */
public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    /**
     * The Files.
     * Set conteiner to store non duplicates
     */
    Set<FileProperty> files =  new HashSet<>();

    /**
     * FileVisitResult.
     * method to be performed while visiting the current file
     * find duplicates
     * @param file - current file
     * @param attrs - file attributes
     * @return file
     * @throws IOException
     */
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
        throws IOException {
        FileProperty fP = new FileProperty(attrs.size(), file.toFile().getName());
        if (files.contains(fP)) {
            System.out.println("Duplicate: " + file.toAbsolutePath());
        } else {
            files.add(fP);
        }

        return FileVisitResult.CONTINUE;
    }
}