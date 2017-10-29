package io.itgumby.basics;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * plain jUnit test
 * potential annotations:
 * @Test public void {testName}  // optional timeout=ms, expected=Exception params
 * @Before, @After public void {method} // run before/after EACH test
 * @BeforeClass, @AfterClass  // run ONCE
 * @Ignore  // skip the test
 * @RunWith(Parameterized.class), @Parameterized.Parameters // data driven over entire class
 */
public class LambdaCompareTest {

    List<Human> humans;

    @Ignore
    @Test
    public void canary() {
        fail("canary");
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
        assertThat(humans.get(0), equalTo(new Human("Gus", 6)));
        assertThat(humans.get(2), equalTo(new Human("Max", 13)));
    }

    @Test
    public void typedLambdaSort() {
        // intentionally reverse sort
        humans.sort((Human a, Human b) -> b.getName().compareTo(a.getName()));
        assertThat(humans.get(0), equalTo(new Human("Max", 13)));
        assertThat(humans.get(2), equalTo(new Human("Gus", 6)));
    }

    @Test
    public void inferredTypeLambdaSort() {
        humans.sort((a, b) -> a.getName().compareTo(b.getName()));
        assertThat(humans.get(0), equalTo(new Human("Gus", 6)));
        assertThat(humans.get(2), equalTo(new Human("Max", 13)));
    }

    @Test
    public void sortWithStaticMethod() {
        humans.add(new Human("Gus", 4));
        humans.sort(Human::compareByNameThenAge);
        assertThat(humans.get(0), equalTo(new Human("Gus", 4)));
        assertThat(humans.get(3), equalTo(new Human("Max", 13)));
    }

    @Test
    public void sortWithExtractedComparator() {
        Collections.sort(humans, Comparator.comparing(Human::getName) );
        assertThat(humans.get(0), equalTo(new Human("Gus", 6)));
        assertThat(humans.get(2), equalTo(new Human("Max", 13)));
    }

    @Test
    public void reverseSort() {
        Comparator<Human> nameComparator = (a, b) -> a.getName().compareTo(b.getName());

        humans.sort(nameComparator.reversed());
        assertThat(humans.get(0), equalTo(new Human("Max", 13)));
        assertThat(humans.get(2), equalTo(new Human("Gus", 6)));
    }

    @Test
    public void sortWithMultipleConditions() {
        humans.sort(
                Comparator.comparing(Human::getAge)
                        .thenComparing(Human::getName)
        );
        assertThat(humans.get(0), equalTo(new Human("Gus", 6)));
        assertThat(humans.get(2), equalTo(new Human("Max", 13)));
    }

    @Before
    public void buildHumans() {
        humans = new ArrayList<>();
        humans.add(new Human("Gus", 6));
        humans.add(new Human("Isabel", 11));
        humans.add(new Human("Max", 13));
    }

}
