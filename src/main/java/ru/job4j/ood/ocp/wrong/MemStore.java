package ru.job4j.ood.ocp.wrong;

import java.util.ArrayList;

/**
 * The type Memstore.
 * поля в данном классе-хранилище должны быть абстрактными,
 * т.к при желании сохранить что-либо другое нам придётся его изменять, нарушая оср
 *
 * параметры данного класса, а также возвращаемые значения не являются абстрактными,
 * что не позволяет нам использовать MemoryStore с другими моделями данных,
 * в случае необходимости, мы вынуждены будем  их изменять
 *
 */
public class MemStore implements Store {

    private final ArrayList<Person> personsList =  new ArrayList<>();
    private final ArrayList<Car> carsList =  new ArrayList<>();


    @Override
    public boolean addPerson(Person person) {
        return  personsList.add(person);
    }

    @Override
    public boolean addCar(Car car) {
        return  carsList.add(car);
    }
}

interface Store {
    boolean addPerson(Person person);
    boolean addCar(Car car);
}
