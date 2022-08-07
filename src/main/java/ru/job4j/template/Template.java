package ru.job4j.template;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Template implements Generator {

    public static String outChars(String str, String c) {
        List<String> charsLiterral = List.of(",", "!", "?", ":", ";");
        String word = str;
        for (String ch: charsLiterral) {
            if (str.contains(ch)) {
                c = ch;
                word = str.replace(ch, "");
            }
        }
        System.out.println(c);

        return word;

    }


    @Override
    public String produce(String template, Map<String, String> args) {
        List<String> chars = List.of(new String[]{"{", "}", "$"});
        List<String> charsLiterral = List.of(",", "!", "?", ":", ";");
        String c = "";

        String[] array = template.split(" ");
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (array[i].startsWith("$")) {
                String word = array[i];
                System.out.println(word + " - word");

                String newWord = null;
                for (String str : chars) {
                    if (word.contains(str)) {
                     newWord = word.replace(str, "");
                     word = newWord;
                    }
                }


                System.out.println(word + " - changed word");

                for (String ch: charsLiterral) {
                    if (word.contains(ch)) {
                        c = ch;
                        word = word.replace(ch, "");
                    }
                }
                System.out.println(word + " - new word");
                System.out.println(c + " - what was deleted");


                    for (String string : args.keySet()) {
                         if (string.equals(word)) {
                            System.out.println(args.get(string));
                            array[i] = args.get(string) + c;
                        }
                    }
                }
        }

        return Arrays.stream(array)
                .map(el -> new StringBuilder().append(el).append(" "))
                .collect(Collectors.joining(""));
    }


            public static void main(String[] args) {
                Template template = new Template();
                String phrase = "I am a ${name}, Who are ${subject}? ";
                String phraseWithMaultipleKeys = "Hello, ${sex}, I am a ${name}, Who are ${subject}? ";

                Map<String, String> keysValues = new HashMap<>();
                keysValues.put("name", "Petr Arsentev");
                keysValues.put("subject", "you");
                System.out.println(template.produce(phrase, keysValues));
        }
    }

