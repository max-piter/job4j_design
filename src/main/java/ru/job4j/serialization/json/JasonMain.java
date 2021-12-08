package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.io.UsageLog4j;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class JasonMain {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        final Car mazda = new Car("Mazda", true, 2.6, new CarNumber("AB234567C"),
                new Person(false, 30, new Contact("11-11-11"),
                        new String[] {"Worker", "Married"}), new String[] {"25.04.2016", "03.08.2020"});

        final Gson gson =  new GsonBuilder().create();

        try (FileOutputStream fos = new FileOutputStream("test.jason")) {
            fos.write(gson.toJson(mazda).getBytes());
        } catch (IOException e) {
            LOG.error("File not found");
        }

        try (FileReader fileReader = new FileReader("test.jason")) {
            Car mazdaFromJason = gson.fromJson(fileReader, Car.class);
            System.out.println(mazdaFromJason);
        } catch (IOException e) {
            LOG.error("File Not Found");
        }
    }
}
