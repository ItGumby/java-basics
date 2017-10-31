package io.itgumby.basics;

public class CyclicRefA {
    private int valA;
    private CyclicRefB instanceB = null;

    public CyclicRefA() {
        valA = 0;
        instanceB = new CyclicRefB();
    }

    public CyclicRefA(int a, CyclicRefB refB) {
        valA = a;
        instanceB = refB;
    }
}
