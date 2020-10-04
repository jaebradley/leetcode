package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class LFUCacheTest {
    @Test
    public void testWhenEmptyGetReturnsNegativeOne() {
       assertEquals(-1, new LFUCache(10).get(0));
    }

    @Test
    public void testSinglePutCanGetInputValue() {
        LFUCache cache = new LFUCache(1);
        cache.put(1, 2);
        assertEquals(2, cache.get(1));
    }

    @Test
    public void testOverCapacityRemovesLeastRecentlyUsedValueWhenTied() {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 2);
        cache.put(3, 4);
        cache.put(5, 6);
        assertEquals(-1, cache.get(1));
        assertEquals(4, cache.get(3));
        assertEquals(6, cache.get(5));
    }

    @Test
    public void testNothingIsSetWhenCapacityIs0() {
        LFUCache cache = new LFUCache(0);
        cache.put(1, 2);
        assertEquals(-1, cache.get(1));
    }

    @Test
    public void testEvictionWhenKeyIsGettedMultipleTimes() {
        LFUCache cache = new LFUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1));
        cache.put(3, 3);
        assertEquals(-1, cache.get(2));
        assertEquals(3, cache.get(3));
        cache.put(4, 4);
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }
}
