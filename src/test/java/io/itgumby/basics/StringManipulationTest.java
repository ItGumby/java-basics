package io.itgumby.basics;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}
