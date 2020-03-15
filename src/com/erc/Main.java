package com.erc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        String wordsPath = args.length > 0 ? args[0] : "words.txt";
        String words = "";
        try {
            words = new String(Files.readAllBytes(Paths.get(wordsPath)));
        } catch (IOException e) {
            e.printStackTrace();
        }


        Arrays.stream(words.split("\n"))
                .map(l -> l.split(" "))
                .flatMap(Arrays::stream)
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(String::toString))
                .values().stream()
                .sorted((value1, value2) -> value2.size() - value1.size())
                .forEach((v) -> {
                    System.out.printf("%s %d%n", v.get(0), v.size());
                });
        ;
    }
}
