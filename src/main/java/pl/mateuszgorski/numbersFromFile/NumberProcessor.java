package pl.mateuszgorski.numbersFromFile;

import java.util.*;

public class NumberProcessor {

    public String constructsResultLine(String line) {
        Scanner scanner = new Scanner(line);
        List<Integer> integersFromLine = new ArrayList<>();
        StringBuilder resultBuilder = new StringBuilder();
        while (scanner.hasNextInt()) {
            int nextNumber = scanner.nextInt();
            integersFromLine.add(nextNumber);
            resultBuilder.append(nextNumber);
            resultBuilder.append("+");
        }
        resultBuilder.deleteCharAt(resultBuilder.length() - 1);
        resultBuilder.append("=" + getSum(integersFromLine));
        return resultBuilder.toString();
    }

    private int getSum(List<Integer> integersFromLine) {
        return integersFromLine.stream().mapToInt(i -> i.intValue()).sum();
    }
}