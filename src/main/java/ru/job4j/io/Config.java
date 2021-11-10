package ru.job4j.io;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;


/**
 * The type Config. - класс для чтения из  файла и записи в карту.
 */
public class Config {

    /**
     * path - переменная адрес файла.
     */
    private final String path;

    /**
     * values - final переменная, карта для хранения инфомации из файла.
     */
    private final Map<String, String> values = new HashMap<>();

    /**
     * Instantiates a new Config - конструктор.
     *
     * @param p the path - адрес файла, из которого необходимо прочитать инфо
     */
    public Config(final String p) {
        this.path = p;
    }

    /**
     * Load. класс для чтения из файла и заполнения карты values.
     * используем метод putAll(), а внеутри -
     * Stream API  c методами filter(), peek(), collect(Collectors.toMap))
     */
    public void load() {
        try (BufferedReader readInputFile =
                     new BufferedReader(
                             new FileReader(this.path))) {
            values.putAll(readInputFile.lines()
                    .filter(line -> !line.equals("") && !line.startsWith("#"))
                    .peek(line -> {
                        if (line.indexOf('=') == -1 || line.charAt(0) == '='
                                || line.charAt(line.length() - 1) == '=') {
                            throw new IllegalArgumentException();
                        }
                    })
                    .collect(Collectors.toMap(k -> k.split("=")[0],
                            v -> v.split("=")[1])));

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String el : values.keySet()) {
            System.out.println(values.get(el));
        }
    }


    /**
     * Value string - метод, чтобы получить Значение по Ключу.
     *
     * @param key the key - ключ
     * @return the string - значение
     */
    public String value(final String key) {
        return values.get(key);
    }

    /**
     * класс toString() - переопределён для чтения всего файла посточно.
     * @return  строки
     */
    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read =
                     new BufferedReader(
                             new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

}
