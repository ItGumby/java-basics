package io.itgumby.basics;

import com.google.common.base.Splitter;
import org.apache.commons.lang3.StringUtils;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class StringManipulationTest {

    @Test
    public void legacySubstr() {
        assertEquals(null, StringManipulation.removeLastChar(null));
        assertEquals(null, StringManipulation.removeLastChar(""));
            // NOTE: returns NULL on empty string
        assertEquals("", StringManipulation.removeLastChar("a"));
        assertEquals("ab", StringManipulation.removeLastChar("abc"));
    }

    @Test
    public void optionalSubstr() {
        // not null-safe
        // assertEquals(null, StringManipulation.removeLastCharOptional(null));
        assertEquals("", StringManipulation.removeLastCharOptional(""));
        assertEquals("", StringManipulation.removeLastCharOptional("a"));
        assertEquals("ab", StringManipulation.removeLastCharOptional("abc"));
    }

    @Test
    public void utilsSubString() {
        // not null-safe
        // assertEquals(null, StringManipulation.removeLastCharUtils(null));
        assertEquals("", StringManipulation.removeLastCharUtils(""));
        assertEquals("", StringManipulation.removeLastCharUtils("a"));
        assertEquals("ab", StringManipulation.removeLastCharUtils("abc"));
    }

    @Test
    public void utilsChop() {
        assertEquals(null, StringManipulation.removeLastCharUtilsChop(null));
        assertEquals("", StringManipulation.removeLastCharUtilsChop(""));
        assertEquals("", StringManipulation.removeLastCharUtilsChop("a"));
        assertEquals("ab", StringManipulation.removeLastCharUtilsChop("abc"));
    }

    @Test
    public void legacyRegex() {
        assertEquals(null, StringManipulation.removeLastCharRegex(null));
        assertEquals("", StringManipulation.removeLastCharRegex(""));
        assertEquals("", StringManipulation.removeLastCharRegex("a"));
        assertEquals("ab", StringManipulation.removeLastCharRegex("abc"));
    }

    @Test
    public void optionalRegex() {
        assertEquals(null, StringManipulation.removeLastCharRegexOptional(null));
        assertEquals("", StringManipulation.removeLastCharRegexOptional(""));
        assertEquals("", StringManipulation.removeLastCharRegexOptional("a"));
        assertEquals("ab", StringManipulation.removeLastCharRegexOptional("abc"));
    }

    @Test
    public void stringSplitDelimiters() {
        String[] expected = {"max", "isabel", "gus"};
        assertArrayEquals(expected, "max,isabel,gus".split(","));
        assertArrayEquals(expected, "max isabel gus".split(" "));
    }

    @Test
    public void stringSplitRegex() {
        String[] expected = { "192", "168", "0", "1" };
        assertArrayEquals(expected, "192.168.0.1".split("\\."));

        expected = "itgumby".split(""); // each letter
        Arrays.stream(expected).forEach(l -> System.out.print(l + ","));
        System.out.println("");
        assertArrayEquals(expected, "i t,g.u|m b y".split("\\s+|,\\s*|\\.|\\|"));
    }

    @Test
    public void stringUtilsSplit() {
        String[] expected = {"planes", "trains", "automobiles"};
        assertArrayEquals(expected, StringUtils.split("planes trains automobiles"));
        assertArrayEquals(expected, StringUtils.split("planes    trains  automobiles"));
        String[] empty = {};
        assertArrayEquals(empty, StringUtils.split(""));
        assertArrayEquals(null, StringUtils.split(null));
    }

    @Test
    public void splitter() {
        String[] expected = { "planes", "trains", "automobiles" };
        List<String> actual = Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .splitToList("planes,trains ,, automobiles");
        assertThat(actual, IsIterableContainingInOrder.contains(expected));

    }

    @Test
    public void imperativeCountChars() {
        assertEquals(2, StringManipulation.imperativeCountChars("elephant", 'e'));
        assertEquals(2, StringManipulation.recursiveCountChars("elephant", 'e', 0));
        assertEquals(2, StringManipulation.regexCountChar("elephant", 'e'));
        assertEquals(2, StringManipulation.lambdaCountChar("elephant", 'e'));
        assertEquals(2, StringManipulation.stringUtilsCountChar("elephant", 'e'));
        assertEquals(2, StringManipulation.guavaCountChar("elephant", 'e'));
    }

}
