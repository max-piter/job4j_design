package ru.job4j.map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;

public class SimpleMapTest {

    Map<String, String> map;

    @Before
    public void startTest() {
        map =  new SimpleMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        map.put("5", "5");
        map.put("6", "6");
        map.put("7", "7");
        map.put("8", "8");
        map.put("9", "9");
        map.put("10", "10");
        map.put("11", "11");
        map.put("12", "12");
        map.put("13", "13");
        map.put("wex", "14");
        map.put("kex", "15");
        map.put("fex", "16");
    }

    @Test
    public void whenKeyExists() {
        Assert.assertFalse(map.put("1", "1"));
    }

    @Test
    public void whenGetValueByKey() {
        Assert.assertEquals("15", map.get("kex"));
    }

    @Test
    public void whenGetValueByKeyButItisNull() {
        Assert.assertNull(map.get("t"));
    }

    @Test
    public void whenRemoveFalse() {
        Assert.assertFalse(map.remove("t"));
    }

    @Test
    public void whenRemoveTrue() {
        Assert.assertTrue(map.remove("kex"));
        Assert.assertNull(map.get("kex"));
    }

    @Test
    public void whenCheckIterator() {
        Iterator<String> iterator = map.iterator();
        Assert.assertTrue(iterator.hasNext());
    }

    @Test
    public void whenIterator() {
        map.remove("1");
        map.remove("2");
        map.remove("3");
        map.remove("4");
        map.remove("5");
        map.remove("6");
        map.remove("7");
        map.remove("8");
        map.remove("9");
        map.remove("10");
        map.remove("11");
        map.remove("12");
        map.remove("13");
        map.remove("wex");
        map.remove("kex");
        map.remove("fex");
        Assert.assertFalse(map.iterator().hasNext());
    }
}
