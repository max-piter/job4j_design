package ru.job4j.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * The type Search.
 * - application searches for files only by a certain predicate.
 */
public class Search  {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        Path start = Paths.get(args[0]);
        String fileExtension = args[1];
        search(start, p -> p.toFile().getName().endsWith(fileExtension))
                .forEach(System.out::println);
    }

    /**
     * Search list - method to search files by a predicate.
     *
     * @param root      the root - starting point of the search
     * @param condition the condition - the predicate
     * @return the list - resulting list of files
     * @throws IOException the io exception - exception
     */
    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}

/**
 * The type Search files. - class to set a condition.
 * implements interface  FileVisitor
 */
class SearchFiles implements FileVisitor<Path> {

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
     * @param file - directory, when we start searching
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
