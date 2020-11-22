package collection;

import java.util.Iterator;

public interface Collection<E> {
    int size();
    boolean isEmpty();
    boolean contains(Object o);
    void add(E e);
    void remove(Object o);
    void clear();
    Object[] toArray();
//    Iterator<E> iterator();
}
