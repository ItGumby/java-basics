package io.itgumby.basics;

public class CyclicRefB {
    private int valB;
    private CyclicRefA instanceA = null;

    public CyclicRefB() {
        valB = 10;
        instanceA = new CyclicRefA();
    }
    public CyclicRefB(int b, CyclicRefA refA) {
        valB = b;
        instanceA = refA;
    }
}
