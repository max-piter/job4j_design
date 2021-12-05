package ru.job4j.serialization.json;

public class CarNumber {
    private final String carNumber;

    public CarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public String toString() {
        return "CarNumber{"
               + "carNumber=" + carNumber
               + '}';
    }
}
