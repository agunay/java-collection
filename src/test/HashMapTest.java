package test;

import collection.map.HashMap;
import collection.map.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HashMapTest {
    private HashMap map;

    @Before
    public void SetUp() {
        map = new HashMap<Character, Integer>();
    }

    @Test
    public void Put() {
        map.put('A', 1);
        Assert.assertEquals(1, map.get('A'));

        map.put('B', 2);
        Assert.assertEquals(2, map.get('B'));
    }

    @Test
    public void PutWithCollision() {
        map.putWithCollision('A', 1);
        map.putWithCollision('B', 2);
        Assert.assertEquals(1, map.getWithCollision('A'));
        Assert.assertEquals(2, map.getWithCollision('B'));
    }

    @Test
    public void ContainsKey() {
        map.put('A', 1);
        Assert.assertTrue(map.containsKey('A'));
        Assert.assertFalse(map.containsKey('B'));
    }

    @Test
    public void Replace() {
        map.put('A', 1);
        map.replace('A', 2);
        Assert.assertEquals(2, map.get('A'));
    }

    @Test
    public void Remove() {
        map.put('A', 1);
        map.put('B', 2);
        Assert.assertEquals(2, map.size());
        map.remove('B');
        Assert.assertEquals(1, map.size());
        Assert.assertEquals(null, map.get('B'));
    }
}
