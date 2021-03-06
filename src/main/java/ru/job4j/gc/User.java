package ru.job4j.gc;

public class User {

    private int age;
    private String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    /**
     * Класс не проходил Maven тесты с этим методом
     *  @Override
     *     protected void finalize() throws Throwable {
     *         System.out.printf("Removed %d, %s%n", age, name);
     *     }
     *
     */



    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{"
              +  "age=" + age
              +  ", name='" + name + '\''
              +  '}';
    }
}
