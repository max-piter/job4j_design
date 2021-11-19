package ru.job4j.io;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class ArgsNameTest {

    @Test
    public void whenGetFirst() {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        assertThat(jvm.get("Xmx"), is("512"));
    }

    @Test
    public void whenGetFirstReorder() {
        ArgsName jvm = ArgsName.of(new String[] {"-encoding=UTF-8", "-Xmx=512"});
        assertThat(jvm.get("Xmx"), is("512"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenGetNotExist() {
        ArgsName jvm = ArgsName.of(new String[] {});
        jvm.get("Xmx");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenWrongSomeArgument() {
        ArgsName jvm = ArgsName.of(new String[] {"-enconding=UTF-8", "-Xmx="});
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenWrongPositionOfFirstChar() {
        ArgsName jvm = ArgsName.of(new String[] {"Xmx=512-", "-encoding=UTF-8"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenAbstenceOfMinus() {
        ArgsName jvm = ArgsName.of(new String[] {"Xmx=512", "-encoding=UTF-8"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenTheMinusInstedOfKey() {
        ArgsName jvm = ArgsName.of(new String[] {"-=512", "-encoding=UTF-8"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenTheAbsenceOfValue() {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=", "-encoding=UTF-8"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenTheDubbleEquals() {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx==512", "-encoding=UTF-8"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenTheAbsenseOfEquals() {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx-512", "-encoding=UTF-8"});
    }



}