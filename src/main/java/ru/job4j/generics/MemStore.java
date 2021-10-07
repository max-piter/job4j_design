package ru.job4j.generics;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * универсальный класс дляя хранения объектов
 * созданный по шаблону интерфейса Store<T>
 * @param <T> the type parameter
 */
public final class MemStore<T extends Base> implements Store<T> {

    /**
     * структура хранилища, типа HashMap
     */
    private final Map<String, T> mem = new HashMap<>();

    /**
     * переопределённый метод интерфейса Store
     * добавляет элемент в хранилище
     * @param model обобщённый тип
     */
    @Override
    public void add(T model) {
        mem.put(model.getId(), model);
    }

    /**
     * переопределённый метод  интерфейса Store
     * заменяет значение элемента по ключу
     * @param  id элемента, значение которого надо заменить
     * @param  model  новое значение
     * @return - возвращает true, если  значение по ключу (id) найдено и заменено успешно,
     *  и false, если такого ключа нет и значение не найдено
     */
    @Override
    public boolean replace(String id, T model) {
        return mem.replace(model.getId(), model) != null;
    }

    /**
     * переопределённый метод  интерфейса Store
     * удаляет элемент по id
     * @param id элемента, значение которого необходимо удалить
     * @return - true, если удаление прошло успешно и false, если ключ не найден
     */
    @Override
    public boolean delete(String id) {
        return mem.remove(id) != null;
    }

    /**
     * переопределённый метод  интерфейса Store
     * ищет значение, в данном случае объект Т по ключу (id)
     * @param  id элемента
     * @return возвращает значение элемента
     */
    @Override
    public T findById(String id) {
      return mem.get(id);
    }

    @Override
    public void print() {
        for (String el: mem.keySet()) {
            System.out.println(mem.get(el));
        }
    }
}
