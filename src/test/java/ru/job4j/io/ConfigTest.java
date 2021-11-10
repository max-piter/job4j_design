package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConfigTest {

    @Test
    public void whenPairWithWrongKey() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("Nottingham"),
                is("Forrest"));
        assertThat(config.value("surname"), is(Matchers.nullValue()));
    }


    @Test
    public void whenPairWithComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("Max"), is("Korovkin"));
        assertThat(config.value("# Comment"), is(Matchers.nullValue()));
    }

    @Test
    public void whenPairWithEmptyString() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("Piter"), is("Cooper"));
        assertThat(config.value("Brian"), is("Clough"));
    }

    @Test
    public void whenCheckTheRestMap() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("Max"),
                is("Korovkin"));
        assertThat(config.value("Brian"), is("Clough"));
        assertThat(config.value("Piter"), is("Cooper"));
        assertThat(config.value("Nottingham"), is("Forrest"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithNullValue() {
        String path = "./data/pair_with_NullValue.properties";
        Config config = new Config(path);
        config.load();
        config.value("Nottingham");
    }
}