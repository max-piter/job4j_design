package ru.job4j.serialization.json;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement(name = "Car")
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {

    @XmlAttribute
    private String model;

    @XmlAttribute
    private boolean isColored;

    @XmlAttribute
    private double engine;
    private CarNumber carNumber;
    private Person person;
    private String[] trafficViolations;

    public Car() { }

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
