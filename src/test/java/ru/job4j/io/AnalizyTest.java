package ru.job4j.io;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

public class AnalizyTest {
    @Rule
    public TemporaryFolder folder =  new TemporaryFolder();

    @Test
    public void checkTheServer() throws IOException {
        File source = new File("source1.csv");
        File target =  new File("unavailable1.csv");
        try (PrintWriter writerOut = new PrintWriter(source)) {
            writerOut.println("200 10:56:01\n" +
                    "500 10:57:01\n" +
                    "400 10:58:01\n" +
                    "500 10:59:01\n" +
                    "400 11:01:02\n" +
                    "200 11:02:02");
        }
        Analizy firstTest = new Analizy();
        firstTest.unavailable("source1.csv", "unavailable1.csv");
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader readerIn = new BufferedReader(new FileReader(target))) {
            readerIn.lines().forEach(rsl :: append);
        }
        assertThat(rsl.toString(), is("10:57:01;11:02:02;"));
    }
}
