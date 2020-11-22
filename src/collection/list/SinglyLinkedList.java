package collection.list;

public class SinglyLinkedList<E> implements List<E> {
    private Node head;
    private int size;

    public SinglyLinkedList() {
        this.size = 0;
        this.head = null;
    }

    public Node getHead() {
        return head;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (head == null) { return true; }
        else { return false; }
    }

    @Override
    public boolean contains(Object o) {
        if (head == null) { return false; }

        Node curr = head;
        while (curr != null) {
            if (curr.data.equals(o)) { return true; }
            curr = curr.next;
        }

        return false;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    // Adds to the tail of the linked list
    @Override
    public void add(E e) {
        Node<E> newNode = new Node(e);

        if (this.head == null) {
            this.head = newNode;
            size++;
            return;
        }

        Node<E> curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        size++;
    }

    // Adds to the head of the linked list
    public void addFirst(E e) {
        Node<E> newNode = new Node(e);

        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        Node tmp = head;
        head = newNode;
        head.next = tmp;
        size++;
    }

    @Override
    public void remove(Object o) {
        if (head == null) { return; }

        if (head.data.equals(o)) {
            head = head.next;
            size--;
            return;
        }

        Node curr = head;

        while (curr.next != null) {
            if (curr.next.data.equals(o)) {
                curr.next = curr.next.next;
                size--;
                return;
            }
            curr = curr.next;
        }
    }

    @Override
    public Object[] toArray() {
        if (head == null) return null;

        Object[] arr = new Object[size];

        int index = 0;
        Node curr = head;

        while (curr != null) {
            arr[index] = curr.data;
            curr = curr.next;
            index++;
        }

        return arr;
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("");
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("");
    }

    @Override
    public E set(int index, E e) {
        throw new UnsupportedOperationException("");
    }
}
