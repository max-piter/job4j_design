package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * The type Search files. - class to set a condition.
 * implements interface  FileVisitor
 */
public class SearchFiles implements FileVisitor<Path> {

    /**
     * The List. - stores the files.
     */
    List<Path> list = new ArrayList<>();

    /**
     * The Predicate - condition.
     */
    Predicate<Path> predicate;

    public SearchFiles(Predicate<Path> condition) {
        this.predicate = condition;
    }

    /**
     * Gets paths - getter.
     *
     * @return the paths - returns list with files
     */
    public List<Path> getPaths() {
        return list;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }


    /**
     * visitFile - method, we have to do  while visiting file.
     *
     * @param file  - directory, when we start searching
     * @param attrs - condition
     * @return - the next file
     * @throws IOException - exception
     */
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
            throws IOException {
        if (predicate.test(file)) {
            list.add(file);
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }
}
