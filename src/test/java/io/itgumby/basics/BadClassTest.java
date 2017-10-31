package io.itgumby.basics;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.fail;

public class BadClassTest {

    @Ignore
    @Test
    public void canary() {
        fail("canary");
    }

    @Test(expected = ClassNotFoundException.class)
    public void classNotFoundWhenNoDrivers() throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
    }

    @Test(expected = NoClassDefFoundError.class)
    public void noClassDefFoundErrorWhenRuntime() {
        NoClassDefExample example = new NoClassDefExample();
        example.getProblem();
    }

}
