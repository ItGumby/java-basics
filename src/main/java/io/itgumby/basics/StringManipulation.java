package io.itgumby.basics;

import com.google.common.base.CharMatcher;
import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringManipulation {

    public static String removeLastChar(String s) {
        return (s == null || s.length() == 0) ?
                null : s.substring(0, s.length() - 1);
    }

    public static String removeLastCharOptional(@NonNull String s) {
        return Optional.ofNullable(s)
                .filter(str -> str.length() != 0)
                .map(str -> str.substring(0, str.length() - 1))
                .orElse(s);
    }

    public static String removeLastCharUtils(@NonNull String s) {
        return StringUtils.substring(s, 0, s.length() -1);
    }

    public static String removeLastCharUtilsChop(String s) {
        return StringUtils.chop(s);
    }

    public static String removeLastCharRegex(String s) {
        if (s == null) return s;
        return s.replaceAll(".$", "");
    }
    public static String removeLastCharRegexOptional(String s) {
        return Optional.ofNullable(s)
                .map(str -> str.replaceAll(".$", ""))
                .orElse(s);
    }

    public static int imperativeCountChars(String string, char c) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }
    public static int recursiveCountChars(String string, char searchedChar, int index) {
        if (index >= string.length()) return 0;
        int count = string.charAt(index) == searchedChar ? 1 : 0;
        return count + recursiveCountChars(string, searchedChar, index + 1);
    }

    /**
     * technically correct, but overkill & slow to use powerful RegEx
     */
    public static int regexCountChar(String string, char searchChar) {
        int count = 0;
        Pattern pattern = Pattern.compile("[^e]*e");
        Matcher matcher = pattern.matcher(string);
        while(matcher.find()) {
            count++;
        }
        return count;
    }

    public static long lambdaCountChar(String string, char searchChar) {
        return string.chars()
                .filter(ch -> ch == searchChar)
                .count();
    }

    public static int stringUtilsCountChar(String string, char searchChar) {
        return StringUtils.countMatches(string, searchChar);
    }

    public static int guavaCountChar(String string, char searchChar) {
        return CharMatcher.is(searchChar).countIn(string);
    }
}
