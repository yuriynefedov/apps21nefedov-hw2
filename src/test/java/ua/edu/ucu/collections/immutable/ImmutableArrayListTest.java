package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.collections.Queue;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    private ImmutableArrayList immutableArrayList;
    Object[] array;

    @Before
    public void setUp() {
        array = new Integer[] {-2, 13, 14, 7};
        immutableArrayList = new ImmutableArrayList(array);
    }

    @Test
    public void testAdd() {
        ImmutableList arr = immutableArrayList.add(2, 10);
        Integer[] expected = new Integer[] {-2, 13, 10, 14, 7};
        assertArrayEquals(array, immutableArrayList.toArray());
        assertArrayEquals(expected, arr.toArray());
    }

    @Test
    public void testAddAll() {
        ImmutableList arr = immutableArrayList.addAll(3, new Integer[] {3, 4, 5});
        Integer[] expected = new Integer[] {-2, 13, 14, 3, 4, 5, 7};
        assertArrayEquals(array, immutableArrayList.toArray());
        assertArrayEquals(expected, arr.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddError() {
        immutableArrayList.get(12);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllError() {
        immutableArrayList.addAll(15, new Integer[0]);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveError() {
        immutableArrayList.remove(12);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetError() {
        immutableArrayList.set(15, 0);
    }

    @Test
    public void testRemove() {
        ImmutableList arr = immutableArrayList.remove(1);
        Integer[] expected = new Integer[] {-2, 14, 7};
        assertArrayEquals(array, immutableArrayList.toArray());
        assertArrayEquals(expected, arr.toArray());
    }

    @Test
    public void testSet() {
        ImmutableList arr = immutableArrayList.set(2, 1);
        Integer[] expected = new Integer[] {-2, 13, 1, 7};
        assertArrayEquals(array, immutableArrayList.toArray());
        assertArrayEquals(expected, arr.toArray());
    }

    @Test
    public void testIndexOf() {
        assertEquals(1, immutableArrayList.indexOf(13));
    }

    @Test
    public void testSize() {
        assertEquals(4, immutableArrayList.size());
    }

    @Test
    public void testClear() {
        ImmutableList arr = immutableArrayList.clear();
        Integer[] expected = new Integer[0];
        assertArrayEquals(expected, arr.toArray());
    }

    @Test
    public void testIsEmpty() {
        ImmutableList arr = immutableArrayList.clear();
        assertTrue(arr.isEmpty());
        assertFalse(immutableArrayList.isEmpty());
    }

    @Test
    public void testToArray() {
        assertArrayEquals(immutableArrayList.toArray(), new Integer[] {-2, 13, 14, 7});
    }
}