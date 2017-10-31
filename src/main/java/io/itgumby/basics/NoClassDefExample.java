package io.itgumby.basics;

public class NoClassDefExample {
    public ClassWithInitErrors getProblem() {
        ClassWithInitErrors problem;
        try {
            problem = new ClassWithInitErrors();
        } catch (Throwable t) { // first time ExceptionInInitializerError
            System.out.println("first call: " + t);
        }
        // 2nd time, throws NoClassDefFoundError
        problem = new ClassWithInitErrors();
        return problem;
    }

    /*
    * resolving ClassNotFoundException, NoClassDefFoundError:
    * 1. ensure class can be found on classpath
    * 2. if on classpath, then classpath is probably getting overridden
    * 3. if multi class loaders, not all libs are on all loaders.
    *    study how they work: https://en.wikipedia.org/wiki/Java_Classloader
    */
}
