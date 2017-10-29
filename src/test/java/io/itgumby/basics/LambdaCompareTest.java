package io.itgumby.basics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;

public class LambdaCompareTest {

    List<Human> humans;

    @Ignore
    @Test
    public void canary() {
        assertTrue(false);
    }

    @Test
    public void lombokWorks() {
        Human human = new Human("Gus", 6);
        assertEquals("Human(name=Gus, age=6)", human.toString());
        assertEquals("Gus", human.getName());
        assertEquals(6, human.getAge());
    }

    @Test
    public void legacyAnonymousComparator() {
        Collections.sort(humans, new Comparator<Human>() {
            @Override
            public int compare(Human a, Human b) {
                return a.getName().compareTo(b.getName());
            }
        });
        Assert.assertThat(humans.get(0), equalTo(new Human("Gus", 6)));
        Assert.assertThat(humans.get(2), equalTo(new Human("Max", 13)));
    }

    @Test
    public void typedLambdaSort() {
        // intentionally reverse sort
        humans.sort((Human a, Human b) -> b.getName().compareTo(a.getName()));
        Assert.assertThat(humans.get(0), equalTo(new Human("Max", 13)));
        Assert.assertThat(humans.get(2), equalTo(new Human("Gus", 6)));
    }

    @Test
    public void inferredTypeLambdaSort() {
        humans.sort((a, b) -> a.getName().compareTo(b.getName()));
        Assert.assertThat(humans.get(0), equalTo(new Human("Gus", 6)));
        Assert.assertThat(humans.get(2), equalTo(new Human("Max", 13)));
    }

    @Test
    public void sortWithStaticMethod() {
        humans.add(new Human("Gus", 4));
        humans.sort(Human::compareByNameThenAge);
        Assert.assertThat(humans.get(0), equalTo(new Human("Gus", 4)));
        Assert.assertThat(humans.get(3), equalTo(new Human("Max", 13)));
    }

    @Test
    public void sortWithExtractedComparator() {
        Collections.sort(humans, Comparator.comparing(Human::getName) );
        Assert.assertThat(humans.get(0), equalTo(new Human("Gus", 6)));
        Assert.assertThat(humans.get(2), equalTo(new Human("Max", 13)));
    }

    @Test
    public void reverseSort() {
        Comparator<Human> nameComparator = (a, b) -> a.getName().compareTo(b.getName());

        humans.sort(nameComparator.reversed());
        Assert.assertThat(humans.get(0), equalTo(new Human("Max", 13)));
        Assert.assertThat(humans.get(2), equalTo(new Human("Gus", 6)));
    }

    @Test
    public void sortWithMultipleConditions() {
        humans.sort(
                Comparator.comparing(Human::getAge)
                        .thenComparing(Human::getName)
        );
        Assert.assertThat(humans.get(0), equalTo(new Human("Gus", 6)));
        Assert.assertThat(humans.get(2), equalTo(new Human("Max", 13)));
    }

    @Before
    public void buildHumans() {
        humans = new ArrayList<>();
        humans.add(new Human("Gus", 6));
        humans.add(new Human("Isabel", 11));
        humans.add(new Human("Max", 13));
    }

}
