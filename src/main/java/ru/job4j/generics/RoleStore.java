package ru.job4j.generics;

/**
 * класс реализует  версию контейнера для хранения обьектов типа Role
 *  по  шаблону интерфейса Store<Т>
 */
public class RoleStore implements Store<Role> {

    /**
     * Хранилище  для экземпляров типа данных Role
     */
    private final Store<Role> rStore = new MemStore<>();

    /**
     * метод  добавляет элемент в контейнер
     * @param model -  обобщённый тип элемента
     */
    @Override
    public void add(Role model) {
        rStore.add(model);
    }

    /**
     * медод заменяет значение элемента по ключу
     * @param id - id of some general element
     * @param model - general  model
     * @return - возвращает true, если замена прошла успешно и  false  -  если нет
     */
    @Override
    public boolean replace(String id, Role model) {
        return rStore.replace(id, model);
    }

    /**
     * метод удаляет элемент по id
     * @param id -  id of element? we need to delete
     * @return возвращает true, если удаление  прошло успешно и  false  -  если нет
     */
    @Override
    public boolean delete(String id) {
        return rStore.delete(id);
    }

    /**
     * метод осуществляет поиск элемента по id
     * @param id - id of element we need to find
     * @return значение элемента
     */
    @Override
    public Role findById(String id) {
        return rStore.findById(id);
    }
}
