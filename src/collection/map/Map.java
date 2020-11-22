package collection.map;

import collection.Collection;

public interface Map<K, V> {
    int size();
    boolean isEmpty();
    boolean containsKey(Object key);
    boolean containsValue(Object value);
    V get(Object key);
    void put(K key, V value);
    V remove(Object key);
    void clear();
//    Set<K> keySet();
//    Collection<V> values();

    interface Entry<K, V> {
        K getKey();
        V getValue();
        V setValue(V value);
        int hashCode(); // for entry
    }

    int hashCode(); // for map
}
