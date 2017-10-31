package io.itgumby.basics;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TimeTest {

    // Period is difference in Years/Months/Days between 2 times
    // Duration is difference in Days/Hours/Seconds/Milliseconds

    @Test
    public void canCalcDifferenceInYMD() {
        LocalDate end = LocalDate.of(2017, 1, 1);
        LocalDate start = LocalDate.of(1976, 7, 4);
        Period diff = Period.between(start, end);
        System.out.println("Period (YMD) units: " + diff.getUnits());
        assertFalse(diff.isNegative());
        assertTrue(Period.between(end, start).isNegative());
    }

    @Test
    public void canCreatePeriods() {
        Period period = Period.of(1, 2, 3);
        // or ofYears(), ofMonths(), ofWeeks(), ofDays()...
        assertEquals(1, period.getYears());
        assertEquals(2, period.getMonths());
        assertEquals(3, period.getDays());

        assertEquals(280, Period.ofWeeks(40).getDays());
    }

    @Test
    public void canParsePeriodStrings() {
        Period period = Period.parse("P2Y3M4D");
        assertEquals(2, period.getYears());
        assertEquals(3, period.getMonths());
        assertEquals(4, period.getDays());
    }

    @Test
    public void canCalcDifferenceInHMS() {
        Instant start = Instant.parse("2017-10-31T08:30:15.12Z");
        Instant end = Instant.parse("2017-10-31T15:05:21.34Z");
        Duration diff = Duration.between(start, end);
        assertEquals(23706, diff.getSeconds());
        assertEquals(220000000, diff.getNano());
        System.out.println("Duration (sec/nano) units: " + diff.getUnits()); // Seconds, Nanos only
        assertEquals(23706, diff.get(ChronoUnit.SECONDS));
    }

    @Test
    public void canParseDurationStrings() {
        Duration duration = Duration.parse("P1DT1H10M10.5S");
        Duration mins = Duration.parse("PT10M");
        assertEquals(10, mins.toMinutes());
        assertEquals(1, duration.toDays());
    }
}
