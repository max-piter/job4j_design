package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "/Users/a123/projects/job4j_design/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.dialect"),
                is("org.hibernate.dialect.PostgreSQLDialect"));
        assertThat(config.value("surname"), is(Matchers.nullValue()));
    }

    @Test
    public void whenCommentInFile() {
        String path = "/Users/a123/projects/job4j_design/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.url"),
                is("jdbc:postgresql://127.0.0.1:5432/trackstudio"));
        assertThat(config.value("# PostgreSQL"), is(Matchers.nullValue()));

    }

    @Test
    public void whenPairWithComment() {
        String path = "/Users/a123/projects/job4j_design/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("Max"), is("Korovkin"));
        assertThat(config.value("# Comment"), is(Matchers.nullValue()));
    }

    @Test
    public void whenPairWithEmptyString() {
        String path = "/Users/a123/projects/job4j_design/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("Piter"), is("Cooper"));
        assertThat(config.value("Brian"), is("Clough"));
    }

    @Test
    public void whenCheckTheRestMap() {
        String path = "/Users/a123/projects/job4j_design/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.driver_class"),
                is("org.postgresql.Driver"));
        assertThat(config.value("hibernate.connection.username"), is("postgres"));
        assertThat(config.value("hibernate.connection.password"), is("password"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithNullValue() {
        String path = "/Users/a123/projects/job4j_design/pair_with_NullValue.properties";
        Config config = new Config(path);
        config.load();
        config.value("Nottingham");
    }
}