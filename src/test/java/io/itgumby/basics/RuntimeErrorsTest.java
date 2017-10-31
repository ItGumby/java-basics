package io.itgumby.basics;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class RuntimeErrorsTest {

    //@Test
    @Test(expected = StackOverflowError.class)
    public void missingTerminationRecursion_alwaysBarfs() {
        RuntimeErrors underTest = new RuntimeErrors();
        assertEquals(1, underTest.factorialRecursionInfinite(1));
    }

    @Test(expected = StackOverflowError.class)
    public void missingTerminationRecursion_sometimesBarfs() {
        RuntimeErrors underTest = new RuntimeErrors();
        try {
            assertEquals(1, underTest.factorialAccidentalRecursion(2));
        } catch (Exception ignore) {
            fail("should not have thrown " + ignore);
        }
        assertEquals(1, underTest.factorialAccidentalRecursion(0));
    }

    @Test
    public void properRecursionTermination() {
        RuntimeErrors underTest = new RuntimeErrors();
        assertEquals(1, underTest.calcFactorial(1));
        assertEquals(2, underTest.calcFactorial(2));
        assertEquals(6, underTest.calcFactorial(3));
        assertEquals(1, underTest.calcFactorial(0));
        assertEquals(1, underTest.calcFactorial(-1));
    }

    //@Test
    @Test(expected = StackOverflowError.class)
    public void exceptionWhenCreatingCyclicReferences() {
        CyclicRefA a = new CyclicRefA();
    }

    //@Test
    @Test(expected = StackOverflowError.class)
    public void exceptionWhenCreatingSelfRefCycle() {
        SelfReferenceCycle cyclic = new SelfReferenceCycle();
    }
}
