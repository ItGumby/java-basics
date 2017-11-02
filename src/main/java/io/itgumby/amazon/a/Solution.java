package io.itgumby.amazon.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    List<List<Integer>> closestLocations(int totalCrates,
                                         List<List<Integer>> allLocations,
                                         int truckCapacity) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> remaining = allLocations;
        while (result.size() < truckCapacity) {
            final List<Integer> currentPos = result.isEmpty() ? Arrays.asList(0, 0) : result.get(result.size() - 1);
            remaining = remaining.stream()
                    .filter(a -> !result.contains(a))
                    .sorted((a, b) -> computeDistance(currentPos, a).compareTo(computeDistance(currentPos, b)))
                    .collect(Collectors.toList());
            System.out.println(String.format("(%d, %d) sorted %d", currentPos.get(0), currentPos.get(1), remaining.size()));
            result.add(remaining.get(0));
        }
        return result;
    }

    Double computeDistance(final List<Integer> currentPos, final List<Integer> location) {
        Integer x = currentPos.get(0) - location.get(0);
        Integer y = currentPos.get(1) - location.get(1);
        // does it need to include trip back home?
        double distance = Math.hypot(x, y);
        //double distance = Math.hypot(x, y) + Math.hypot(location.get(0), location.get(1));
        System.out.println(String.format("\t(%d, %d) - (%d, %d) = %f", currentPos.get(0), currentPos.get(1), location.get(0), location.get(1), distance));
        return new Double(distance);
    }

}
