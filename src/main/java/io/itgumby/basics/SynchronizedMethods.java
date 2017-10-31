package io.itgumby.basics;

import lombok.Data;
import lombok.Getter;

@Data
public class SynchronizedMethods {
    private int sum = 0;
    private int count = 0;

    @Getter
    private static int staticSum = 0;
    @Getter
    private static int staticCount = 0;

    public void simpleIncrement() {
        setSum(getSum() + 1);
    }

    public synchronized void synchronizedIncrement() {
        setSum(getSum() + 1);
    }

    public static synchronized void syncStaticIncrement() {
        staticSum += 1;
    }

    public void syncBlockIncrement() {
        synchronized (this) {
            setCount(getCount() + 1);
        }
    }

    public static void staticSyncIncrement() {
        synchronized (SynchronizedMethods.class) {
            staticCount += 1;
        }
    }
}
