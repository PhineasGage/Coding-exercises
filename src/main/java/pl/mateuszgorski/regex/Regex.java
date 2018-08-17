package pl.mateuszgorski.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    private static String partialPatternString = "25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?";
    private static Pattern wholePattern = Pattern.compile("((" + partialPatternString + ")\\.){3}(" + partialPatternString + ")$");

    static public boolean isIpAddress(String input) {
        Matcher matcher = Regex.wholePattern.matcher(input);
        return matcher.matches();
    }
}