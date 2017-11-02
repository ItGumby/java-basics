package io.itgumby.amazon.b;

import java.util.stream.IntStream;

public class Solution {

    public int bstDistance(int[] values, int n,
                           int node1, int node2)
    {
        if (!IntStream.of(values).anyMatch(x -> x == node1) ||  !IntStream.of(values).anyMatch(x -> x == node2)) {
            return -1;
        }
        if (node1 == node2) return 0;
        int pos1 = -1;
        int pos2 = -1;
        for (int i = 0; i < n; i++) {
            if (values[i] == node1) pos1 = i;
            if (values[i] == node2) pos2 = i;
        }
        return 1;
    }

}
