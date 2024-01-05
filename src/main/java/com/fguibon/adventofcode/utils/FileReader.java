package com.fguibon.adventofcode.utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {

    public static List<String> readLines(String fileName) {
        Path path = Paths.get("src/main/resources/" + fileName + ".txt");

        try {
            return Files.readAllLines(path);
        } catch (Exception e) {
            throw new RuntimeException("Cant read file");
        }
    }
}
