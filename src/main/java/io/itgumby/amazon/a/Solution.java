package io.itgumby.amazon.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    List<List<Integer>> closestLocations(int totalCrates,
                                         List<List<Integer>> allLocations,
                                         int truckCapacity) {
        final List<Integer> STARTING_POS = Arrays.asList(0, 0);
        return allLocations.stream()
                .sorted((a, b) -> distanceFromStart(a).compareTo(distanceFromStart(b)))
                .limit(truckCapacity)
                .sorted((a, b) -> a.get(0).compareTo(b.get(0))) // sort by X?
                .collect(Collectors.toList());
    }

    Double distanceFromStart(final List<Integer> location) {
        // assume list =[x, y]
        return new Double(Math.hypot(location.get(0), location.get(1)));
    }

    List<List<Integer>> travelingSalesperson(int totalCrates,
                                         List<List<Integer>> allLocations,
                                         int truckCapacity) {
        final List<Integer> STARTING_POS = Arrays.asList(0, 0);
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> remaining = allLocations;
        while (result.size() < truckCapacity) {
            final List<Integer> currentPos = result.isEmpty() ? STARTING_POS : result.get(result.size() - 1);
            remaining = remaining.stream()
                    .filter(a -> !result.contains(a))
                    .sorted((a, b) -> distanceBetween(currentPos, a).compareTo(distanceBetween(currentPos, b)))
                    .collect(Collectors.toList());
            System.out.println(String.format("(%d, %d) sorted %d", currentPos.get(0), currentPos.get(1), remaining.size()));
            result.add(remaining.get(0));
        }
        return result;
    }

    Double distanceBetween(final List<Integer> currentPos, final List<Integer> location) {
        // assume each location list is ]x,y]
        Integer x = currentPos.get(0) - location.get(0);
        Integer y = currentPos.get(1) - location.get(1);
        // does it need to include trip back home?
        double distance = Math.hypot(x, y);
        //double distance = Math.hypot(x, y) + Math.hypot(location.get(0), location.get(1));
        System.out.println(String.format("\t(%d, %d) - (%d, %d) = %f", currentPos.get(0), currentPos.get(1), location.get(0), location.get(1), distance));
        return new Double(distance);
    }

}
