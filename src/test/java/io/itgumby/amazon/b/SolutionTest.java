package io.itgumby.amazon.b;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void missing() {
        int[] values = {5, 6, 3, 1, 2, 4};
        Solution solution = new Solution();

        assertEquals(-1, solution.bstDistance(values, 6, 7, 4));
        assertEquals(-1, solution.bstDistance(values, 6, 2, 7));
        assertEquals(-1, solution.bstDistance(values, 6, 0, 0));
    }

    @Test
    public void equals() {
        int[] values = {5, 6, 3, 1, 2, 4};
        Solution solution = new Solution();
        assertEquals(0, solution.bstDistance(values, 6, 2, 2));
        assertEquals(0, solution.bstDistance(values, 6, 5, 5));
        assertEquals(0, solution.bstDistance(values, 6, 4, 4));
    }

    @Test
    public void adjacentRight() {
        int[] values = {5, 6, 3, 1, 2, 4};
        Solution solution = new Solution();
        assertEquals(1, solution.bstDistance(values, 6, 5, 6));
        assertEquals(1, solution.bstDistance(values, 6, 3, 4));
    }

    @Test
    public void adjacentLeft() {
        int[] values = {5, 6, 3, 1, 2, 4};
        Solution solution = new Solution();
        assertEquals(1, solution.bstDistance(values, 6, 3, 5));
        assertEquals(1, solution.bstDistance(values, 6, 1, 3));
    }

    @Test
    public void example() {
        int[] values = {5, 6, 3, 1, 2, 4};
        Solution solution = new Solution();
        assertEquals(3, solution.bstDistance(values, 6, 2, 4));
        assertEquals(3, solution.bstDistance(values, 6, 4, 2));
    }


}
