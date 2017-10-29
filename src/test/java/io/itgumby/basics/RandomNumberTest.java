package io.itgumby.basics;

import org.junit.Test;

import java.nio.charset.Charset;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class RandomNumberTest {

    @Test
    public void randomLong() {
        long generated = new Random().nextLong();
        System.out.println(String.format("java util random long = %o", generated));
        assert(generated >= Long.MIN_VALUE);
    }

    @Test
    public void randomInt() {
        int generated = new Random().nextInt();
        System.out.println(String.format("java util random int = %o", generated));
        assert(generated >= Integer.MIN_VALUE);
    }

    @Test
    public void randomFloat() {
        float generated = new Random().nextFloat();
        System.out.println(String.format("java util random float = %f", generated));
        assert(generated >= Float.MIN_VALUE);
    }

    @Test
    public void randomDouble() {
        double generated = Math.random();
        System.out.println(String.format("java util random double = %f", generated));
        assert(generated >= Double.MIN_VALUE);
    }

    @Test
    public void boundedLong() {
        long min = 1l;
        long max = 10l;
        long generated = min + (long) (Math.random() * (max - min));
        System.out.println(String.format("java util bounded long = %o", generated));
        assertTrue(generated >= min);
        assertTrue(generated <= max);
    }

    @Test
    public void boundedInt() {
        int min = 1;
        int max = 10;
        int generated = min + (int) (new Random().nextFloat() * (max-min));
        System.out.println(String.format("java util bounded int = %o", generated));
        assertTrue(generated >= min);
        assertTrue(generated <= max);
    }

    @Test
    public void boundedFloat() {
        float min = 1F;
        float max = 10F;
        float generated = min + (long) (Math.random() * (max - min));
        System.out.println(String.format("java util bounded float = %f", generated));
        assertTrue(generated >= min);
        assertTrue(generated <= max);
    }

    @Test
    public void boundedDouble() {
        double min = 1F;
        double max = 10F;
        double generated = min + (long) (Math.random() * (max - min));
        System.out.println(String.format("java util bounded double = %f", generated));
        assertTrue(generated >= min);
        assertTrue(generated <= max);
    }

    // TODO: Commons Math examples (RandomDataGenerator)

    @Test
    public void randomString() {
        byte[] bytes = new byte[10];  // length is bounded
        new Random().nextBytes(bytes);
        String generated = new String(bytes, Charset.forName("UTF-8"));
        System.out.println(String.format("random string (any characters): %s", generated));
        assertTrue(generated.length() <= 10 );
    }

    @Test
    public void randomStringLettersOnly() {
        int min = (int)'a';
        int max = (int)'z';
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            int boundedInt = min + (int) (random.nextFloat() * (max - min +1));
            buffer.append((char)boundedInt);
        }
        String generated = buffer.toString();
        System.out.println(String.format("random string (lc letters only): %s", generated));
        assertTrue(generated.length() == 10 );
    }

    // TODO: Commons Lang alpha strings (RandomStringUtils)
}
