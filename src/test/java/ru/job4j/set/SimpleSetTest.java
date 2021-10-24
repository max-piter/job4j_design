package ru.job4j.set;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SimpleSetTest {

    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    public void whenAddManyObjects() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.add(2));
        assertTrue(set.add(3));
        assertTrue(set.add(423));
        assertTrue(set.add(null));
        assertFalse(set.add(null));
        assertTrue(set.contains(1));
        assertFalse(set.add(2));
    }

    @Test
    public void checkAmountOfElements() {
        Set<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        int count = 0;

        for (Integer ignored: set) {
            count++;
        }
        assertThat(count, is(4));
    }


    @Test
    public void checkStringValues() {
        Set<String> set = new SimpleSet<>();
        set.add("Max");
        set.add("Nik");
        set.add("Oleg");
        set.add("Marat");
        assertTrue(set.contains("Marat"));
        assertTrue(set.contains("Max"));
        assertTrue(set.contains("Nik"));
        assertFalse(set.contains("Fuck"));
    }


}