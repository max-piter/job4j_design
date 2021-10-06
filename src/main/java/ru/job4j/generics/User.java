package ru.job4j.generics;

import java.util.Objects;

/**
 * класс создаёт тип элемента, для хранения в пользовательском контейнере UserStore
 */
public class User extends Base {

    private String name;

    /**
     * Конструктор, для создания экземпляров a new User.
     *
     * @param id   the id
     * @param name the name
     */
    public User(String id, String name) {
        super(id);
        this.name = name;
    }

    /**
     * метод для доступа к private полю  String  name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает значение  private поля  String  name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * метод для доступа к private полю  String id
     * @return String id
     */
    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "User{"
               + "id: " + super.getId() + '\''
               + "name='" + name + '\''
               +  '}';
    }
}
