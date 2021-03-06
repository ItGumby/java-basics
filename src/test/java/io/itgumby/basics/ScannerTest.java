package io.itgumby.basics;

import org.junit.After;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ScannerTest {

    static final String FILE_PATH = "src/test/resources/test.in";
    static final String MULTI_LINE = "src/test/resources/multi-line.txt";
    static final Double DELTA = 0.00000001;

    Scanner scanner;

    @After
    public void close() {
        if (scanner != null) scanner.close();
    }

    @Test
    public void readFileWithScanner() throws IOException {
        scanner = new Scanner(new File(FILE_PATH));
        assertTrue(scanner.hasNext());
        assertEquals("Hello", scanner.next());
        assertEquals("world", scanner.next());
    }

    @Test
    public void scanInputStream() throws IOException {
        FileInputStream inputStream = new FileInputStream(FILE_PATH);
        scanner = new Scanner(inputStream);
        scanner.useDelimiter("A");

        String result = scanner.next();
        assertEquals("Hello world\n", result);
        assertFalse(scanner.hasNext());
    }

    @Test
    public void readLinesWithBufferedReader() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(MULTI_LINE));
        assertEquals("Hello world", reader.readLine());
        assertEquals("Hi, John", reader.readLine());
        reader.close();
    }

    @Test
    public void readTokensWithScanner() throws IOException {
        FileInputStream inputStream = new FileInputStream(MULTI_LINE);
        scanner = new Scanner(inputStream);
        assertEquals("Hello world", scanner.nextLine());

        scanner.useDelimiter(", ");
        assertEquals("Hi", scanner.next());
        assertEquals("John\n", scanner.next());
        // TODO: why new line, even when file doens't?
    }

    @Test
    public void scanFromConsole() {
        String input = "Hello";
        InputStream stdin = System.in;

        System.setIn(new ByteArrayInputStream(input.getBytes()));
        scanner = new Scanner(System.in);
        assertEquals(input, scanner.next());

        System.setIn(stdin);
    }

    @Test
    public void scanInt() {
        InputStream stdin = System.in;

        System.setIn(new ByteArrayInputStream("2000".getBytes()));
        scanner = new Scanner(System.in);
        assertTrue(scanner.hasNextInt());

        System.setIn(stdin);
    }

    @Test
    public void scanStringWithTypes() {
        String input = "Hello 1 F 3.5";

        scanner = new Scanner(input);
        assertEquals("Hello", scanner.next());
        assertEquals(1, scanner.nextInt());
        assertEquals(15, scanner.nextInt(16));
        assertEquals(3.5, scanner.nextDouble(), DELTA);
    }

    @Test
    public void findPatternWithScanner() throws IOException {
        FileInputStream inputStream = new FileInputStream(FILE_PATH);
        scanner = new Scanner(inputStream);
        assertEquals("world", scanner.findInLine("wo..d"));
    }

    @Test
    public void findWithScannerInHorizon() throws IOException {
        FileInputStream inputStream = new FileInputStream(FILE_PATH);
        scanner = new Scanner(inputStream);
        assertNull(scanner.findWithinHorizon("wo..d", 5));
        assertEquals("world", scanner.findWithinHorizon("wo..d", 100));
    }

    @Test
    public void scannerSkipPattern() throws IOException {
        FileInputStream inputStream = new FileInputStream(FILE_PATH);
        scanner = new Scanner(inputStream);
        scanner.skip(".e.lo");
        assertEquals("world", scanner.next());
    }

    // skipped scanner.useDelimiter(); already leveraged it

    @Test
    public void scannerWithMultiDelim() {
        String input = "John,Adam-Tom";
        scanner = new Scanner(input);
        scanner.useDelimiter(",|-"); // pipe separates delimiters
        assertEquals("John", scanner.next());
        assertEquals("Adam", scanner.next());
        assertEquals("Tom", scanner.next());
    }

    @Test
    public void tryWithMultipleResources() throws IOException {
        final String dest = "out/test/resources/copy.txt";
        try(
            Scanner myScanner = new Scanner(new File(MULTI_LINE));
            PrintWriter writer = new PrintWriter(new File(dest))
        ) {
            while (myScanner.hasNext()) {
                writer.print(myScanner.nextLine());
            }
        }
        assertTrue(new File(dest).exists());
    }

    public class MyResource implements AutoCloseable {
        @Override
        public void close() throws Exception {
            System.out.println("close called");
        }
        public void doIt() { System.out.println("done..."); }
    }

    @Test
    public void autoCloseable() throws Exception {
        try(MyResource rsc = new MyResource()) {
            rsc.doIt();
        }
        // TODO: could actually implement a test, ie capture STDOUT...
    }

    public List<String> getTokensImperative(String str, String delim) {
        List<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(str, delim);
        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken());
        }
        return tokens;
    }

    public List<String> getTokensStream(String str, String delim) {
        return Collections.list(new StringTokenizer(str, delim)).stream()
                .map(t -> (String) t)
                .collect(Collectors.toList());
    }

    @Test
    public void tokenizeString() {
        String input = "Hello,baeldung.com";
        String delim = "e";
        List<String> expected = Arrays.asList("H", "llo,ba", "ldung.com");
        assertEquals(expected.size(), getTokensImperative(input, delim).size());
        assertEquals(getTokensImperative(input, delim), getTokensStream(input, delim));
    }
}
