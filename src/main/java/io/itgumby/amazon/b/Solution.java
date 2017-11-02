package io.itgumby.amazon.b;

import java.util.stream.IntStream;

public class Solution {

    public int bstDistance(int[] values, int n,
                           int min, int max) {
        if (!IntStream.of(values).anyMatch(x -> x == min) || !IntStream.of(values).anyMatch(x -> x == max)) {
            return -1;
        }
        int distance = 0;
        if (min == max) return distance;
        if (min > max) return bstDistance(values, n, max, min);

        boolean hasMin = false;
        boolean hasMax = false;
        for (int i = 0; i < values.length; i++) {
            int val = values[i];
            if ((distance == 0) && (val > max || val < min)) {
                continue; // skip out of range values at front of list
            }

            if ((!hasMax && val >= min) || (!hasMin && val <= max)) {
                distance++;
            }

            if (val == min) hasMin = true;
            else if (val == max) hasMax = true;

            if (hasMin && hasMax) break;
        }
        return distance - 1;
    }

}
