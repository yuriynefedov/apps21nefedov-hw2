package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    private ImmutableLinkedList immutalbeLL;
    Object[] array;

    @Before
    public void setUp() {
        array = new Integer[] {-12, -3, 6, 17};
        immutalbeLL = new ImmutableLinkedList(array);
    }

    @Test
    public void testAdd() {
        ImmutableList arr2 = immutalbeLL.add(1, 10);
        Integer[] expected = new Integer[] {-12, 10, -3, 6, 17};
        assertArrayEquals(array, immutalbeLL.toArray());
        assertArrayEquals(expected, arr2.toArray());
    }

    @Test
    public void testAddAll() {
        ImmutableList arr2 = immutalbeLL.addAll(1, new Integer[] {13, 3, 5});
        Integer[] expected = new Integer[] {-12, 13, 3, 5, -3, 6, 17};
        assertArrayEquals(array, immutalbeLL.toArray());
        assertArrayEquals(expected, arr2.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetError() {
        immutalbeLL.get(100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllError() {
        immutalbeLL.addAll(15, new Integer[0]);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveError() {
        immutalbeLL.remove(100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetError() {
        immutalbeLL.set(12, 10);
    }

    @Test
    public void testRemove() {
        ImmutableList arr2 = immutalbeLL.remove(1);
        Integer[] expected = new Integer[] {-12, 6, 17};
        assertArrayEquals(array, immutalbeLL.toArray());
        assertArrayEquals(expected, arr2.toArray());
    }

    @Test
    public void testSet() {
        ImmutableList arr2 = immutalbeLL.set(1, 1);
        Integer[] expected = new Integer[] {-12, 1, 6, 17};

        assertArrayEquals(array, immutalbeLL.toArray());
        assertArrayEquals(expected, arr2.toArray());
    }

    @Test
    public void testIndexOf() {
        assertEquals(2, immutalbeLL.indexOf(6));
    }

    @Test
    public void testSize() {
        assertEquals(4, immutalbeLL.size());
    }

    @Test
    public void testClear() {
        ImmutableList arr2 = immutalbeLL.clear();
        Integer[] expected = new Integer[0];
        assertArrayEquals(expected, arr2.toArray());
    }

    @Test
    public void testIsEmpty() {
        ImmutableList updated = immutalbeLL.clear();
        assertTrue(updated.isEmpty());
        assertFalse(immutalbeLL.isEmpty());
    }

    @Test
    public void testToArray() {
        assertArrayEquals(immutalbeLL.toArray(), new Integer[] {-12, -3, 6, 17});
    }
}