package pl.mateuszgorski.streams;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FileProcessor {
    private ClassLoader classLoader = getClass().getClassLoader();
    private Pattern pattern = Pattern.compile("[\\s\\d]+");

    public List<String> readLinesFromFile(String filename) {
        try {
            return Files.lines(new File(classLoader.getResource(filename).getFile()).toPath())
                    .filter(line -> pattern.matcher(line).matches())
                    .filter(line -> !"".equals(line.trim()))
                    .filter(line -> !"\r".equals(line.trim()))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeLinesToFile(List<String> resultLines, String resultFileName) {
        try {
            Files.write(Paths.get(resultFileName), resultLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String s = "   ";
        System.out.println(new FileProcessor().pattern.matcher(s).matches());
    }
}