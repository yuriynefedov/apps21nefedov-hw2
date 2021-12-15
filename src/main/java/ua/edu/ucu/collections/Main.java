package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableArrayList;

public class Main {
    public static void main(String[] args) {
        Object[] elements = new Object[3];
        elements[0] = 0;
        elements[1] = 1;
        elements[2] = 2;
        ImmutableArrayList arrayList = new ImmutableArrayList(elements);
        System.out.println(arrayList);
    }
}
