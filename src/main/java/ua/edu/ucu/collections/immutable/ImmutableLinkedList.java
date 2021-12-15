package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.InputMismatchException;

public final class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private Node tail;
    private int count;

    public ImmutableLinkedList(Object[] elements) {
        this.head = null;
        this.tail = null;
        this.count = 0;
        Node current = null;
        for (Object el : elements) {
            Node node = new Node();
            node.setValue(el);
            if (current != null) {
                current.setNext(node);
            }
            node.setPrevious(current);
            current = node;
            if (this.count == 0) {
                this.head = node;
            }
            if (this.count + 1 == elements.length) {
                this.tail = node;
            }
            this.count += 1;
        }
    }

    public ImmutableLinkedList() {
        this.count = 0;
        this.head = null;
        this.tail = null;
    }

    @Override
    public ImmutableList add(Object e) {
        return addAll(this.count, new Object[] {e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object [] {e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(this.count, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if ((index < 0) || (index > count)) {
            throw new IndexOutOfBoundsException();
        }
        Object[] list = Arrays.copyOf(this.toArray(), this.count);
        Object[] resultArr = new Object[this.count + c.length];
        for (int i = 0; i < resultArr.length; ++i) {
            if (i < index) {
                resultArr[i] = list[i];
            } else if (i - c.length < index) {
                resultArr[i] = c[i - index];
            } else {
                resultArr[i] = list[i - c.length];
            }
        }
        return new ImmutableLinkedList(resultArr);
    }

    @Override
    public Object get(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        Node node = head;
        int current = 0;
        while (node != null) {
            if (current == index) {
                return node.getValue();
            }
            node = node.getNext();
            current += 1;
        }
        return null;
    }

    @Override
    public ImmutableList remove(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        Object[] currentList = Arrays.copyOf(this.toArray(), count);
        Object[] updatedList = new Object[count - 1];
        int counter = 0;
        for (int i = 0; i < count; i++) {
            if (i == index) {
                continue;
            }
            updatedList[counter++] = currentList[i];
        }
        return new ImmutableLinkedList(updatedList);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        ImmutableList list = remove(index);
        return list.add(index, e);
    }

    @Override
    public int indexOf(Object e) {
        Node node = head;
        int counter = 0;
        while (node != null) {
            if (node.getValue() == e) {
                return counter;
            }
            counter += 1;
            node = node.getNext();
        }
        throw new InputMismatchException();
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public ImmutableList clear() {
        Object[] result = new Object[0];
        return new ImmutableLinkedList(result);
    }

    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[count];
        Node node = head;
        int counter = 0;
        while (node != null) {
            result[counter++] = node.getValue();
            node = node.getNext();
        }
        return result;
    }

    public ImmutableLinkedList addFirst(Object e) {
        Object[] currentList = Arrays.copyOf(this.toArray(), count);
        Object[] updatedList = new Object[count + 1];
        updatedList[0] = e;
        for (int i = 1; i <= count; ++i) {
            updatedList[i] = currentList[i-1];
        }

        return new ImmutableLinkedList(updatedList);
    }

    public ImmutableLinkedList addLast(Object e) {
        Object[] currentList = Arrays.copyOf(this.toArray(), count);
        Object[] updatedList = new Object[count + 1];
        updatedList[count] = e;
        for (int i = 0; i < count; ++i) {
            updatedList[i] = currentList[i];
        }
        return new ImmutableLinkedList(updatedList);
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public Object getFirst() {
        if (this.head == null) {
            throw new InputMismatchException();
        }
        return head.getValue();
    }

    public Object getLast() {
        if (this.tail == null) {
            throw new InputMismatchException();
        }
        return tail.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) this.remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) this.remove(count - 1);
    }
}
