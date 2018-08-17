package pl.mateuszgorski.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberProcessor {

    public String constructsResultLine(String line) {
        String[] lineToStringArray = convertToformattedArray(line);
        return Stream.concat(Arrays.stream(lineToStringArray)
                        .limit(lineToStringArray.length - 1)
                        .map(string -> string + "+"),
                Stream.of(makeLastElementOfLine(lineToStringArray, line)))
                .collect(Collectors.joining());
    }

    private String makeLastElementOfLine(String[] lineToStringArray, String line) {
        return lineToStringArray[lineToStringArray.length - 1] + "=" + getSum(line);
    }

    private int getSum(String line) {
        return Arrays.stream(convertToformattedArray(line))
                .mapToInt(i -> Integer.parseInt(i))
                .sum();
    }

    private static String[] convertToformattedArray(String line) {
        return line.trim().split("[\\s]+");
    }

}