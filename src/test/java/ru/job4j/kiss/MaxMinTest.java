package ru.job4j.kiss;
import org.junit.jupiter.api.Test;


import java.util.Comparator;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import java.util.*;


class MaxMinTest {

    MaxMin mm = new MaxMin();

    Comparator<Attachment> comparatorForNames = (left, right) -> left.getName().compareTo(right.getName());

    Attachment a = new Attachment("E", 150);
    Attachment b = new Attachment("D", 100);
    Attachment c = new Attachment("C", 50);
    Attachment d = new Attachment("B", 10);
    Attachment e = new Attachment("A", 5);

    List<Attachment> attachments = Arrays.asList(a, d, c, d, e);


    @Test
    public void testMax() {
        Comparator<Integer> comparator = Integer::compareTo;
        List<Integer> list = List.of(214, 21, 44, -314, -3, 2435);
        assertThat(new MaxMin().max(list, comparator), is(2435));
    }

    @Test
    public void testMin() {
        Comparator<Integer> comparator = Integer::compareTo;
        List<Integer> list = List.of(214, 21, 44, -314, -3, 2435);
        assertThat(new MaxMin().min(list, comparator), is(-314));
    }

    @Test
    public void testMaxObject() {

        assertThat(mm.max(attachments, Comparator.comparingInt(Attachment::getSize)),
                is(a));
        assertThat(mm.max(attachments, comparatorForNames), is(a));
    }

    @Test
    public void testMinObject() {
        assertThat(mm.min(attachments, Comparator.comparingInt(Attachment::getSize)),
                is(e));
        assertThat(mm.min(attachments, comparatorForNames), is(e));
    }


}