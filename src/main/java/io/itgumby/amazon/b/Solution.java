package io.itgumby.amazon.b;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {

    public int bstDistance(int[] values, int n,
                           int min, int max) {
        if (!IntStream.of(values).anyMatch(x -> x == min) || !IntStream.of(values).anyMatch(x -> x == max)) {
            return -1;
        }
        if (min == max) return 0;
        if (min > max) return bstDistance(values, n, max, min);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            int val = values[i];
            if (list.isEmpty() && (val > max || val < min)) {
                continue;
            }

            if (!list.contains(max) && val >= min)
                list.add(val);
            else if (!list.contains(min) && val <= max)
                list.add(val);

            if (list.contains(min) && list.contains(max))
                break;
        }
        //System.out.println(String.format("(%d, %d) => %s", min, max, list));
        return list.size() - 1;
    }

}
