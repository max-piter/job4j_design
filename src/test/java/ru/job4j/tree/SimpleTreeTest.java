package ru.job4j.tree;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class SimpleTreeTest {

    Tree<Integer> tree = new SimpleTree<>(1);

    @Before
    public void initData() {
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
    }


    @Test
    public void when6ElFindLastThen6() {
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void whenChildExistOnLeafThenNotAdd() {
        assertFalse(tree.add(2, 6));
    }

    @Test
    public void whenTreeIsBinary() {
        assertTrue(tree.isBinary());
    }

    @Test
    public void whenEmptyThenTrue() {
        Tree<Integer> tree = new SimpleTree<>(1);
        assertTrue(tree.isBinary());
    }

}