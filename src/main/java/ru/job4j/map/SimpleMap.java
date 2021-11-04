package ru.job4j.map;
import java.util.*;

/**
 * Класс Simple map -  реализация структуры HashMap на основе массива
 *
 * @param <K> the type parameter
 * @param <V> the type parameter
 */
public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table;

    public SimpleMap() {
        table = new MapEntry[8];
    }

    /**
     * метод put(K key, V value) - добавляет элемент в мапу
     * @param key -  key
     * @param value - value
     * @return - false, если добавление не удалось и true, если оно прошло успешно
     */
    @Override
    public boolean put(K key, V value) {
        boolean ifPutSuccess = false;
        float threshold = table.length * LOAD_FACTOR;
        if (count >= threshold) {
            expand();
        }

        MapEntry<K, V> newMap =  new MapEntry(key, value);
        int index = indexFor(hash(newMap.key.hashCode()));
        if (table[index] == null) {
            table[index] = newMap;
            ifPutSuccess = true;
            modCount++;
            count++;
        } else if (newMap.key.hashCode() == table[index].key.hashCode()) {
                if (newMap.key.equals(table[index].key) && !newMap.value.equals(table[index].value)) {
                    table[index].value = newMap.value;
                    ifPutSuccess = true;
                    modCount++;
                }
        }

        return ifPutSuccess;
    }

    /**
     * метод hash -  вычисляет хэш функцию. Формулу взял из  интернета,
     * другие генерировали повторяющиеся индексы
     * @param hashCode - хэшКод ключа
     * @return возвращает число hash
     */
    private int hash(int hashCode) {
        int h = hashCode;
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    /**
     * метод indexFor - генерирует индекс для бакета
     * @param hash - hash
     * @return - returns index of bucket
     */
    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    /**
     * метод expand() - увеличивает размер массива во избежании переполнения.
     * ориентируется на LOAD_FACTOR
     * вызывается в методе put()
     */
    private void expand() {
        capacity *= 2;
        MapEntry<K, V>[] oldTable = table;
        table =  new MapEntry[oldTable.length * 2];
        count = 0;
        for (MapEntry<K, V> baket: oldTable) {
            if (baket != null) {
                put(baket.key, baket.value);
            }
        }

    }

    /**
     * метод get(Object key) - позволяет получить значение по ключу
     * @param key - key
     * @return возвращиет значение (value), если оно существует и null, если его нет
     */
    @Override
    public V get(Object key) {
        int index = indexFor(hash(key.hashCode()));
        if (table[index] != null) {
          return  table[index].value;
        }
        return null;
    }

    /**
     * метод  remove(Object key) удаляет объект по ключу
     * @param key - key
     * @return false, если объекта не существует, true, если удалние прошло успешно.
     */
    @Override
    public boolean remove(Object key) {
        boolean ifRemoveSuccess = false;
        int index = indexFor(hash(key.hashCode()));
        if (table[index] != null) {
            table[index] = null;
            ifRemoveSuccess = true;
            modCount++;
            count--;
        }

        return ifRemoveSuccess;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            final int expectedModCount = modCount;
            final MapEntry<K, V>[] fullMapp = Arrays.stream(table)
                    .filter(Objects::nonNull)
                    .toArray(MapEntry[] :: new);
            int point = 0;

            @Override
            public boolean hasNext() {
                return point  < fullMapp.length;
            }

            @Override
            public Object next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return fullMapp[point++].key;
            }
        };
    }


    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "MapEntry{"
                    + "key=" + key
                    + ", value=" + value
                    + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof MapEntry)) {
                return false;
            }
            MapEntry<?, ?> mapEntry = (MapEntry<?, ?>) o;
            return Objects.equals(key, mapEntry.key)
                    && Objects.equals(value, mapEntry.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }


}
