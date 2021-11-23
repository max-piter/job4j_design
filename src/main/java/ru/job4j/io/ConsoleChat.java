package ru.job4j.io;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {

    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswer;



    public ConsoleChat(String path, String botAnswer) {
        this.path = path;
        this.botAnswer = botAnswer;
    }

    public void run() {
        List<String> log = new ArrayList<>();
        Scanner scanner =  new Scanner(System.in);
        Random random = new Random();
        String userQuestion;
        String botAnswer;
        boolean rsl = true;
        while (rsl) {
            userQuestion = scanner.nextLine();
            switch (userQuestion) {
                case ("закончить") ->  {
                    rsl = false;
                }

                case ("стоп") -> {
                    while ("продолжить".equals(userQuestion)) {
                        log.add("User: " + userQuestion);
                        userQuestion = scanner.nextLine();
                    }
                    log.add("User: " + userQuestion);
                }
                default -> {
                    botAnswer = readPhrases().get(random.nextInt(readPhrases().size()));
                    log.add("User: " + userQuestion);
                    log.add("Bot: " + botAnswer);
                    System.out.println(botAnswer);
                }
            }
       }
        saveLog(log);
    }

    private List<String> readPhrases() {
        List<String> phrase = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new FileReader(this.botAnswer, Charset.forName("WINDOWS-1251")))) {
            br.lines().forEach(phrase::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phrase;

    }

    private void saveLog(List<String> log) {
        try (PrintWriter out = new PrintWriter(
                new FileWriter(this.path, StandardCharsets.UTF_8, true))) {
            log.forEach(out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("dialog.txt",
                "/Users/a123/Downloads/russian_nouns");
        cc.run();
    }
}
