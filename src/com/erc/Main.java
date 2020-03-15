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
                .flatMap(w -> Arrays.stream(w))
                .collect(Collectors.groupingBy(String::toString))
                .forEach((k, v) -> {
                    System.out.printf("%s %d%n", k, v.size());
                });
    }
}
