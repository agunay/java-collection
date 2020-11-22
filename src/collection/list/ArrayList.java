package collection.list;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 5;
    private int size = 0;
    private Object elements[];

    public ArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) { return true; }
        else { return false; }
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) { return true; }
        }
        return false;
    }

    @Override
    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public E get(int index) {
        return (E) elements[index];
    }

    @Override
    public E set(int index, E e) {
        Object tmp = elements[index];
        elements[index] = e;
        return (E) tmp;
    }

    @Override
    public void add(E e) {
        ensureCapacity();
        elements[size] = e;
        size++;
    }

    public void add(int index, E e) {
        add(e); // Adds to the end

        // Shift DOWN
        for (int i = size - 1; i > index; i--) {
            Object tmp = elements[i];
            elements[i] = elements[i-1];
            elements[i-1] = tmp;
        }
    }

    @Override
    public void remove(Object o) {
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                index = i;
            }
        }

        // Shift UP
        for (int i = index; i < elements.length - 1; i++) {
            elements[i] = elements[i+1];
        }
        elements[size-1] = null;
        size--;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) { return i; }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            System.out.println(elements[i].toString());
        }
        return sb.toString();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOfRange(elements, 0, size);
    }

//    @Override
//    public Iterator<E> iterator() {
//        return null;
//    }

    private void ensureCapacity() {
        if (size == elements.length) {
            int newSize = elements.length * 2;
            elements = Arrays.copyOf(elements, newSize);
        }
    }


}
