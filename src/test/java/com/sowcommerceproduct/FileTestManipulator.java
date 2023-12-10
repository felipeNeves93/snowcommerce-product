package com.sowcommerceproduct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;


public class FileTestManipulator {

    public String readFileAsString(String path) throws IOException {
        var classLoader = getClass().getClassLoader();
        var inputStream = classLoader.getResourceAsStream(path);

        if (inputStream == null) {
            throw new IOException("File not found: " + path);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }
}
