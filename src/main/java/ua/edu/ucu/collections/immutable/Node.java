package ua.edu.ucu.collections.immutable;

public class Node {
    private Node previous;
    private Node next;
    private Object value;

    public Node() {
        this.previous = null;
        this.next = null;
        this.value = null;
    }

    @Override
    public String toString() {
        return value.toString();
    }


    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node prev) {
        this.previous = prev;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object val) {
        this.value = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node ne) {
        this.next = ne;
    }
}

