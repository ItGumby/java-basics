package io.itgumby.amazon.b;

import io.itgumby.amazon.b.Solution;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void example() {
        int[] values = {5, 6, 3, 1, 2, 4};
        Solution solution = new Solution();

        assertEquals(3, solution.bstDistance(values, 6, 2, 4));
    }

    @Test
    public void missing() {
        int[] values = {5, 6, 3, 1, 2, 4};
        Solution solution = new Solution();

        assertEquals(-1, solution.bstDistance(values, 6, 7, 4));
        assertEquals(-1, solution.bstDistance(values, 6, 2, 7));
    }

}
