package ua.edu.ucu.collections.immutable;

public final class ImmutableArrayList implements ImmutableList {

    private Object[] array;

    public ImmutableArrayList(Object[] elements) {
        array = new Object[elements.length];
        System.arraycopy(elements, 0, array, 0, elements.length);
    }

    public ImmutableArrayList() { }

    @Override
    public ImmutableList add(Object e) {
        Object[] arr = new Object[1];
        arr[0] = e;
        return this.addAll(arr);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Object[] arr = new Object[1];
        arr[0] = e;
        return this.addAll(index, arr);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return this.addAll(array.length, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Object[] updatedArray = new Object[array.length + c.length];
        if (index >= 0) {
            System.arraycopy(array, 0, updatedArray, 0, index);
        }
        System.arraycopy(c, 0, updatedArray, index, c.length);
        System.arraycopy(array, index, updatedArray, index + c.length,
                array.length - index);
        return new ImmutableArrayList(updatedArray);
    }

    @Override
    public Object get(int index) {
        return this.array[index];
    }

    @Override
    public ImmutableList remove(int index) {
        Object[] updatedArray = new Object[array.length - 1];
        System.arraycopy(array, 0, updatedArray, 0, index);
        System.arraycopy(array, index + 1, updatedArray, index,
                array.length - 1 - index);
        return new ImmutableArrayList(updatedArray);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        Object[] updatedArray = new Object[array.length];
        System.arraycopy(array, 0, updatedArray, 0, array.length);
        updatedArray[index] = e;
        return new ImmutableArrayList(updatedArray);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < array.length; i++) {
            if (e == array[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public ImmutableList clear() {
        Object[] updatedArray = new Object[0];
        return new ImmutableArrayList(updatedArray);
    }

    @Override
    public boolean isEmpty() {
        for (Object obj: array) {
            if (obj != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray() {
        Object[] updatedArray = new Object[array.length];
        System.arraycopy(array, 0, updatedArray, 0, array.length);
        return updatedArray;
    }
}
