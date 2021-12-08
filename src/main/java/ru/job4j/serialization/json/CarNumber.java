package ru.job4j.serialization.json;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CarNumber")
public class CarNumber {

    @XmlAttribute
    private String carNumber;

    public CarNumber() { }

    public CarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarNumber() {
        return carNumber;
    }

    @Override
    public String toString() {
        return "CarNumber{"
               + "carNumber=" + carNumber
               + '}';
    }
}
