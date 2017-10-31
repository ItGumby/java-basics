package io.itgumby.basics;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class DaysOfWeekEnumTest {

    @Test
    public void iterateUsing_EnumSet() {
        Collection<DaysOfWeekEnum> daysSet = EnumSet.allOf(DaysOfWeekEnum.class);
        daysSet.forEach(day -> System.out.println("set: " + day));
        assertEquals(7, daysSet.size());
    }

    @Test
    public void iterateUsing_Arrays() {
        // documented DaysOfWeekEnum.class fails - only single value
        Collection<DaysOfWeekEnum> daysList = Arrays.asList(DaysOfWeekEnum.values());
        daysList.forEach(day -> System.out.println("list: "+ day));
        assertEquals(7, daysList.size());
    }

    @Test
    public void iterateUsing_stream() {
        List<DaysOfWeekEnum> fromStream = Stream.of(DaysOfWeekEnum.values())
                .filter(day -> day.getTypeOfDay().equals("off"))
                .collect(Collectors.toList());
        System.out.println(fromStream);
        assertEquals(2, fromStream.size());
    }

    @Test
    public void iterateUsing_for_loop() {
        for(DaysOfWeekEnum d : DaysOfWeekEnum.values()) {
            System.out.println("for loop: " + d);
        }
    }
}

