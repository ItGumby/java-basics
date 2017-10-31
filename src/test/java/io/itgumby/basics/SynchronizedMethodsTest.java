package io.itgumby.basics;

import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class SynchronizedMethodsTest {

    @Ignore
    @Test
    public void unsyncronizedFails() throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        SynchronizedMethods underTest = new SynchronizedMethods();

        IntStream.range(0, 1000).forEach(count -> threadPool.submit(underTest::simpleIncrement));
        threadPool.awaitTermination(2000, TimeUnit.MILLISECONDS);
        assertEquals(1000, underTest.getSum());
    }

    @Test
    public void synchronizedInstanceMethodPasses() throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        SynchronizedMethods underTest = new SynchronizedMethods();

        IntStream.range(0, 1000).forEach(count -> threadPool.submit(underTest::synchronizedIncrement));
        threadPool.awaitTermination(1000, TimeUnit.MILLISECONDS);
        assertEquals(1000, underTest.getSum());
    }

    @Test
    public void synchronizedStaticMethodPasses() throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        SynchronizedMethods underTest = new SynchronizedMethods();

        IntStream.range(0, 1000).forEach(count -> threadPool.submit(SynchronizedMethods::syncStaticIncrement));
        threadPool.awaitTermination(1000, TimeUnit.MILLISECONDS);
        assertEquals(1000, underTest.getStaticSum());
    }

    @Test
    public void synchronizedBlockPasses() throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        SynchronizedMethods underTest = new SynchronizedMethods();

        IntStream.range(0, 1000).forEach(count -> threadPool.submit(underTest::syncBlockIncrement));
        threadPool.awaitTermination(1000, TimeUnit.MILLISECONDS);
        assertEquals(1000, underTest.getCount());
    }

    @Test
    public void synchronizedStaticBlockPasses() throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        SynchronizedMethods underTest = new SynchronizedMethods();

        IntStream.range(0, 1000).forEach(count -> threadPool.submit(SynchronizedMethods::staticSyncIncrement));
        threadPool.awaitTermination(1000, TimeUnit.MILLISECONDS);
        assertEquals(1000, underTest.getStaticCount());
    }


}
