package io.itgumby.basics;

public class SelfReferenceCycle {
    private String firstName;
    private String lastName;
    SelfReferenceCycle other = new SelfReferenceCycle();
}
