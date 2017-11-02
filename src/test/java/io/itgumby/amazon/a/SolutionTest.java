package io.itgumby.amazon.a;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    static Solution solution;

    @BeforeClass
    static public void setupClass() {
        solution = new Solution();
    }

    @Test
    public void example() {
        List<List<Integer>> allLocations = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(1, -1)
        );
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, -1),
                Arrays.asList(1, 2)
        );

        assertEquals(expected, solution.closestLocations(3, allLocations, 2));
    }

    @Test
    public void testcase1() {
        List<List<Integer>> allLocations = Arrays.asList(
                Arrays.asList(1, -3),
                Arrays.asList(1, 2),
                Arrays.asList(3, 4)
        );
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 2)
        );
        assertEquals(expected, solution.closestLocations(3, allLocations, 1));
    }

    @Test
    public void testcase2() {
        List<List<Integer>> allLocations = Arrays.asList(
                Arrays.asList(3, 6),
                Arrays.asList(2, 4),
                Arrays.asList(5, 3),
                Arrays.asList(2, 7),
                Arrays.asList(1, 8),
                Arrays.asList(7, 9)
        );
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(2, 4),
                Arrays.asList(3, 6),
                Arrays.asList(5, 3)    // what they get
                //Arrays.asList(2, 7)  // what I get
        );
        assertEquals(expected, solution.closestLocations(6, allLocations, 3));
    }

}
