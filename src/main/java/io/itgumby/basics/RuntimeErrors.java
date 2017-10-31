package io.itgumby.basics;

public class RuntimeErrors {
    public int factorialRecursionInfinite(int n) {
        return n * factorialRecursionInfinite(n-1);
    }

    public int factorialAccidentalRecursion(int n) {
        return n == 1 ? 1 : factorialAccidentalRecursion(n-1);
    }

    public int calcFactorial(int n) {
        return n <= 1 ? 1 : n * calcFactorial(n-1);
    }
}
