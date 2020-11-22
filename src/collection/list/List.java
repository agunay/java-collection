package collection.list;

import collection.Collection;

import java.util.Iterator;

public interface List<E> extends Collection<E> {
    int size();
    boolean isEmpty();
    boolean contains(Object o);
    void clear();
    E get(int index);
    E set(int index, E e);
    void add(E e);
    void remove(Object o);
    int indexOf(Object o);
    String toString();
    Object[] toArray();
//    Iterator<E> iterator();
}
