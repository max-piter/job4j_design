package ru.job4j.serialization.json;

import java.util.Arrays;

public class Car {
    private final String model;
    private boolean isColored;
    private final double engine;
    private final CarNumber carNumber;
    private final Person person;
    private String[] trafficViolations;

    public Car(String model, boolean isColored, double engine, CarNumber carNumber,
               Person person, String[] trafficViolations) {
        this.model = model;
        this.isColored = isColored;
        this.engine = engine;
        this.carNumber = carNumber;
        this.person = person;
        this.trafficViolations = trafficViolations;
    }

    @Override
    public String toString() {
        return "Car{"
               + "model='" + model + '\''
               + ", isColored=" + isColored
               + ", engine=" + engine
               + ", carNumber=" + carNumber
               + ", person=" + person
               + ", trafficViolations=" + Arrays.toString(trafficViolations)
               + '}';
    }
}
