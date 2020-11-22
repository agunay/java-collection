package test;

import collection.list.SinglyLinkedList;
import collection.list.Node;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SinglyLinkedListTest {
    private SinglyLinkedList singlyLinkedList;
    @Before
    public void Setup() {
        singlyLinkedList = new SinglyLinkedList<String>();
    }

    @Test
    public void IsEmpty() {
        Assert.assertTrue(singlyLinkedList.isEmpty());
        singlyLinkedList.add("A");
        Assert.assertFalse(singlyLinkedList.isEmpty());
    }

    @Test
    public void Contains() {
        Assert.assertFalse(singlyLinkedList.contains("B"));
        singlyLinkedList.add("A");
        Assert.assertFalse(singlyLinkedList.contains("B"));
        singlyLinkedList.add("B");
        Assert.assertTrue(singlyLinkedList.contains("B"));
    }

    @Test
    public void Clear() {
        singlyLinkedList.add("A");
        Assert.assertFalse(singlyLinkedList.isEmpty());
        singlyLinkedList.clear();
        Assert.assertTrue(singlyLinkedList.isEmpty());
    }

    @Test
    public void Add() {
        singlyLinkedList.add("A");
        singlyLinkedList.add("B");
        singlyLinkedList.add("C");
        Node head = singlyLinkedList.getHead();
        Assert.assertEquals("A", head.data);
        Assert.assertEquals("B", head.next.data);
    }

    @Test
    public void AddFirst() {
        singlyLinkedList.add("A");
        singlyLinkedList.add("B");
        singlyLinkedList.addFirst("X");
        Node head = singlyLinkedList.getHead();
        Assert.assertEquals("X", head.data);
        Assert.assertEquals("A", head.next.data);
    }

    @Test
    public void Remove() {
        singlyLinkedList.add("A");
        singlyLinkedList.add("B");
        singlyLinkedList.add("C");
        singlyLinkedList.remove("B");
        Node head = singlyLinkedList.getHead();
        Assert.assertEquals("C", head.next.data);
        Assert.assertEquals(2, singlyLinkedList.size());
    }

    @Test
    public void RemoveHead() {
        singlyLinkedList.add("A");
        singlyLinkedList.add("B");
        singlyLinkedList.add("C");
        singlyLinkedList.remove("A");
        Node head = singlyLinkedList.getHead();
        Assert.assertEquals("B", head.data);
        Assert.assertEquals(2, singlyLinkedList.size());
    }

    @Test
    public void RemoveLast() {
        singlyLinkedList.add("A");
        singlyLinkedList.add("B");
        singlyLinkedList.add("C");
        singlyLinkedList.remove("C");
        Assert.assertEquals(2, singlyLinkedList.size());
    }

    @Test
    public void toArray() {
        singlyLinkedList.add("A");
        singlyLinkedList.add("B");
        singlyLinkedList.add("C");
        String[] expected = new String[]{"A", "B", "C"};
        Assert.assertArrayEquals(expected, singlyLinkedList.toArray());
    }
}
