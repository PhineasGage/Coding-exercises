package pl.mateuszgorski.numbersFromFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileProcessor {

    private Pattern pattern = Pattern.compile("[\\s\\d]+");

    public List<String> readLinesFromFile(String filename) {
        List<String> linesFromFile = new ArrayList<>();
        try (Scanner scanner = new Scanner(Paths.get("src/main/resources/", filename))) {
            while (scanner.hasNextLine()) {
                String lineFromFile = scanner.nextLine();
                if (verifyLine(lineFromFile)) {
                    linesFromFile.add(lineFromFile);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linesFromFile;
    }

    private boolean verifyLine(String line) {
        if ("".equals(line.trim()) || "\r".equals(line.trim())) {
            return false;
        }
        Matcher m = pattern.matcher(line);
        return m.matches();
    }

    public void writeLinesToFile(List<String> resultLines, String resultFileName) {
        File resultFile = new File("src/main/resources/" + resultFileName);
        try (Formatter output = new Formatter(resultFile)) {
            for (String resultLine : resultLines) {
                output.format("%s%n", resultLine);
            }
        } catch (SecurityException | FileNotFoundException | FormatterClosedException e) {
            e.printStackTrace();
        }
    }
}