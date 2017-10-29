package io.itgumby.basics;

import lombok.Data;

import java.util.Comparator;

@Data
public class Human {
    private String name;
    private int age;

    public Human() {}
    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static int compareByNameThenAge(Human a, Human b) {
        if (a.getName().equals(b.getName())) {
            return a.age - b.age;
        }
        return a.getName().compareTo(b.getName());
    }

    public static void main(String[] args) {
        Human dummy = new Human("Gus", 6);
        System.out.println(dummy);
    }
}
