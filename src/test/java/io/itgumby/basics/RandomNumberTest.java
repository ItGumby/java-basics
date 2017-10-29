package io.itgumby.basics;

import org.junit.Test;

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

    // TODO: Commons Math examples
    // (from http://www.baeldung.com/java-generate-random-long-float-integer-double)
}
