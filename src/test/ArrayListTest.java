package test;

import collection.list.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayListTest {

    private ArrayList arrayList;

    @Before
    public void SetUp() {
        arrayList = new ArrayList<String>();
    }

    @Test
    public void Set() {
        arrayList.set(0, "A");
        Assert.assertEquals("A", arrayList.get(0));
    }

    @Test
    public void SetExistingIndex() {
        arrayList.add(0, "A");
        String oldItem = (String) arrayList.set(0, "B");
        Assert.assertEquals("A", oldItem);
    }

    @Test
    public void Add() {
        arrayList.add("B");
        Assert.assertEquals("B", arrayList.get(0));
    }

    @Test
    public void AddWithIndex() {
        arrayList.add("A");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add(1,"B");
        Assert.assertEquals("B", arrayList.get(1));

        arrayList.add(0, "X");
        Assert.assertEquals("X", arrayList.get(0));
    }

    @Test
    public void Remove() {
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.remove("B");
        Assert.assertEquals(2, arrayList.size());
        Assert.assertEquals("C", arrayList.get(1));
        Assert.assertEquals(null, arrayList.get(2));
    }

    @Test
    public void AddMoreThanCapacity() {
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("E");
        arrayList.add("F");
        arrayList.add("G");
        Assert.assertEquals(7, arrayList.size());
    }

    @Test
    public void IndexOf() {
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        Assert.assertEquals(1,arrayList.indexOf("B"));
    }

    @Test
    public void Contains() {
        arrayList.add("A");
        Assert.assertTrue(arrayList.contains("A"));
        Assert.assertFalse(arrayList.contains("B"));
    }

    @Test
    public void IsEmpty() {
        arrayList.add("A");
        Assert.assertFalse(arrayList.isEmpty());
        arrayList.remove("A");
        Assert.assertTrue(arrayList.isEmpty());
    }

    @Test
    public void ToArray() {
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        Object[] arr = arrayList.toArray();
        Assert.assertEquals(3, arr.length);
    }
}
