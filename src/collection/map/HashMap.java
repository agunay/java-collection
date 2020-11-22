package collection.map;

import java.util.Arrays;

public class HashMap<K, V> implements Map<K, V> {
    static class Node<K, V> implements Map.Entry<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() { return this.key; }

        @Override
        public V getValue() { return this.value; }

        @Override
        public V setValue(V newValue) {
            V oldValue = value;
            this.value = newValue;
            return oldValue;
        }
    }

    // ----------------------
    // HashMap Implementation

    private static final int INITIAL_CAPACITY = 1;
    private Node<K,V>[] table; // Where the key-value pairs are stored
    private int size;

    public HashMap() {
        this.table = new Node[INITIAL_CAPACITY];
        this.size = 0;
    }

    private int calculateIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % INITIAL_CAPACITY;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    @Override
    public boolean containsKey(Object key) {
        Node<K, V> node = getNode(key);
        return node == null ? false : true;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    private final Node<K, V> getNode(Object key) {
        int index = calculateIndex((K) key);
        Node<K,V> entry = table[index];

        if (entry == null) { return null; }
        if (entry.next == null) { return entry; }

        // Need to move to the end of the linked list
        while (entry.next != null) {
            if (entry.getKey().equals(key)) { return entry; }
            entry = entry.next;
        }

        return null;
    }

    @Override
    public V get(Object key) {
        Node<K, V> node = getNode(key);
        return node == null ? null : node.getValue();
    }

    @Override
    public void put(K key, V value) {
        ensureSize();
        int index = calculateIndex(key);;

        // Collision - insert to the tail of the linked list (aka 'chaining')
        if (table[index] != null) {
            Node<K, V> node = table[index];
            Node<K, V> curr = node;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node<K, V>(key, value,null);
        }
        else {
            table[index] = new Node(key, value, null);
        }
        size++;
    }

    public void replace(K key, V value) {
        int index = calculateIndex(key);

        if (table[index] == null) { return; }

        Node<K, V> node = table[index];
        Node curr = node;
        if (curr != null) {
            if (curr.getKey().equals(key)) {
                curr.value = value;
            }
            curr = curr.next;
        }
    }

    @Override
    public V remove(Object key) {
        int index = calculateIndex((K) key);

        if (table[index] == null) { return null; }

        Node<K, V> node = table[index];
        V removed;

        if (node.next == null) {
            removed = node.getValue();
            table[index] = null;
            size--;
            return removed;
        }

        Node curr = node;
        while (curr.next != null) {
            if (curr.next.getKey().equals(key)) {
                removed = (V) curr.next.getValue();
                curr.next = curr.next.next;
                size--;
                return removed;
            }
            curr = curr.next;
        }

        return null;
    }

    @Override
    public void clear() {
        this.table = new Node[INITIAL_CAPACITY];
        this.size = 0;
    }

    // TODO: Fix
    private void ensureSize() {
        if (size == table.length) {
            Node<K,V>[] newTable = Arrays.copyOf(table, table.length * 2);
            this.table = newTable;
        }
    }


    // --------------------------
    // TODO: Delete after testing
    public void putWithCollision(K key, V value) {
        int index = 3;

        // Collision - insert to the tail of the linked list (aka 'chaining')
        if (table[index] != null) {
            Node<K, V> node = table[index];
            Node<K, V> curr = node;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node<K, V>(key, value,null);
        }
        else {
            table[index] = new Node(key, value, null);
        }
        size++;
    }

    public V getWithCollision(Object key) {
        Node<K, V> node = getNodeWithCollision(key);
        return node == null ? null : node.getValue();
    }

    private final Node<K, V> getNodeWithCollision(Object key) {
        int index = 3;
        Node<K,V> entry = table[index];

        if (entry == null) { return null; }
        if (entry.next == null) { return entry; }

        // Need to move to the end of the linked list
        while (entry != null) {
            if (entry.getKey().equals(key)) { return entry; }
            entry = entry.next;
        }

        return null;
    }

    // --------------------------
}
