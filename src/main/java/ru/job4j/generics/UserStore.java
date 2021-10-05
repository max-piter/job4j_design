package ru.job4j.generics;

/**
 * класс реализует пользовательскую версию контейнера для хранения обьектов
 * по  шаблону интерфейса Store<Т>
 *
 */
public class UserStore implements Store<User> {


    /**
     * Хранилище  по шаблону интерфейса Store для объектов типа User
     * объект класса MemStore
     * @see MemStore
     */
    private final Store<User> uStore = new MemStore<>();

    /**
     * добавляет элемент типа User  хранилище store
     * @param model обобщённый элемент типа User
     */
    @Override
    public void add(User model) {
        uStore.add(model);
    }

    /**
     * Изменяет значение элемента находячщегося в хранилище по ключу
     * @param  id элемента значение которого необходимо заменить
     * @param model новое значение элемента
     * @return true если есть в хранилище есть элемент с данным ключом и его значение заменено на новое
     * и false если такого элемента нет
     */
    @Override
    public boolean replace(String id, User model) {
       return uStore.replace(id, model);
    }

    /**
     * удаляет значение по ключу
     * @param  id элемента, значение которого необходимо удалить
     * @return  - true если есть в хранилище есть элемент с данным ключом и его значение удалено
     * и false если такого элемента нет
     */
    @Override
    public boolean delete(String id) {
        return uStore.delete(id);
    }

    /**
     * возвращает значение элемента по указанномк ключу (id)
     * @param  id - ключ
     * @return значение типа User
     */
    @Override
    public User findById(String id) {
        return uStore.findById(id);
    }
}
