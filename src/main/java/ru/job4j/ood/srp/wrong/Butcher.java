package ru.job4j.ood.srp.wrong;

import java.util.List;
import java.util.Objects;

/**
 * The type Butcher.
 * демонстрация модели данных  с излишней логикой
 * помимо хранения данных класс Butcher содержит метод addToDeperment(List<Butcher> butchers, Butcher butcher)
 * который сохраняет экземпляры класса в едином списке.
 */
public class Butcher {
    String name;
    String surname;
    int age;
    int experience;
    private String citizenship;

    public Butcher(String name, String surname, int age, int experience) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.experience = experience;
    }

    public boolean addToDeperment(List<Butcher> butchers, Butcher butcher) {
        return true;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public int getExperience() {
        return experience;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Butcher{"
              +  "name='" + name + '\''
              +  ", surname='" + surname + '\''
              +  ", age=" + age
              +  ", experience=" + experience
              +  '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Butcher)) {
            return false;
        }
        Butcher butcher = (Butcher) o;
        return getAge() == butcher.getAge()
                && getExperience() == butcher.getExperience()
                && getName().equals(butcher.getName())
                && getSurname().equals(butcher.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getAge(), getExperience());
    }
}
