package io.itgumby.basics;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

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
}
