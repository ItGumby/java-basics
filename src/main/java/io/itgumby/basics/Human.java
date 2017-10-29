package io.itgumby.basics;

import lombok.Data;

@Data
public class Human {
    private String name;
    private int age;

    public Human() {}
    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Human dummy = new Human("Gus", 6);
        System.out.println(dummy);
    }
}
