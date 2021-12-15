package ua.edu.ucu.collections;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList lst;

    public Stack() {
        lst = new ImmutableLinkedList();
    }

    public void push(Object e) {
        lst = lst.addFirst(e);
    }

    public Object pop() {
        Object result = peek();
        lst = lst.removeFirst();
        return result;
    }

    public Object peek() {
        return lst.getFirst();
    }
}
