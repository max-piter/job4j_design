package ru.job4j.io.testio;


import ru.job4j.io.ArgsName;
import ru.job4j.io.Search;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class Searcher {
    private static List<Path> searchResult = new ArrayList<>();
    private static final Pattern DIRECTORY =
            Pattern.compile("[/a-zA-Z0-9\\w]+");
    private static final Pattern NAME = Pattern.compile("[a-z]+");
    private static final Pattern TYPE = Pattern.compile("[a-z]+");
    private static final Pattern FILE = Pattern.compile("[/a-zA-Z0-9\\w .?a-z+]+");

    public static void handle(ArgsName argsName) throws IOException {
        validation(argsName);
        Path startFolder = Paths.get(argsName.get("d"));
        if ((Objects.equals(argsName.get("t"), "name"))) {
            searchResult = Search.search(startFolder, p -> p.toFile().getName().endsWith(argsName.get("n")));
        }
        if ((Objects.equals(argsName.get("t"), "mask"))) {
            searchResult = Search.search(startFolder, p -> p.toFile().getName().endsWith(argsName.get("n").substring(1)));
        }
        try (BufferedWriter out = new BufferedWriter(new FileWriter(argsName.get("o")))) {
            for (Path file : searchResult) {
                out.write(file.toString());
                out.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void validation(ArgsName argsName) throws IllegalArgumentException {

        File fileFolder = new File(argsName.get("d"));
        if (!fileFolder.isDirectory() && !argsName.get("d").matches(String.valueOf(DIRECTORY))) {
            throw  new IllegalArgumentException("Директория для поиска указана неверно");
        }

        if (!argsName.get("n").matches(String.valueOf(NAME))) {
            throw new IllegalArgumentException("Параметры для поиска указаны не верно");
        }

        if (!argsName.get("t").matches(String.valueOf(TYPE))) {
            throw  new IllegalArgumentException("Тип поиска указан не верно");
        }

        File fileSearchResult = new File(argsName.get("o"));
        if (!fileSearchResult.exists() && !argsName.get("o").matches(String.valueOf(FILE))) {
            throw new IllegalArgumentException("Файл указан не верно");
        }
    }
    public static void main(String[] args) throws IOException {
        handle(ArgsName.of(args));
    }
}