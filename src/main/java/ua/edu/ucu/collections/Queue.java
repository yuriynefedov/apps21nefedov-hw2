package ua.edu.ucu.collections;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {

    private ImmutableLinkedList lst;

    public Queue() {
        lst = new ImmutableLinkedList();
    }
    public Object peek() {
        return lst.getFirst();
    }

    public Object dequeue() {
        Object result = peek();
        lst = lst.removeFirst();
        return result;
    }

    public void enqueue(Object e) {
        lst = lst.addLast(e);
    }
}
