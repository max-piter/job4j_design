package ru.job4j.generics;


import java.util.Objects;

/**
 * Класс типа  Role.
 * опреляет тип элемента хранения
 */
public class Role extends Base {
    private String name;

    /**
     * Конструктор, для создания экземпляров new Role.
     *
     * @param id   the id
     * @param name the name
     */
    public Role(String id, String name) {
        super(id);
        this.name =  name;
    }

    /**
     *
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets id
     * @return String id
     */
    public String getId() {
        return super.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Role)) {
            return false;
        }
        Role role = (Role) o;
        return getName().equals(role.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
