package algo.java.cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LeastRecentlyUsedCacheTest {

    @Test
    public void cache_test() {
        LeastRecentlyUsedCache<Integer, String> cache = new LeastRecentlyUsedCache<>(2);
        assertEquals(0, cache.size());
        assertNull(cache.get(0));

        cache.insert(1, "one");
        assertEquals(1, cache.size());
        assertEquals("one", cache.get(1));

        cache.insert(2, "two");
        assertEquals(2, cache.size());
        assertEquals("two", cache.get(2));

        // Read 1 so it moves to head
        assertEquals("one", cache.get(1));
        cache.insert(3, "three");

        // Cache size should still be 2
        assertEquals(2, cache.size());
        assertEquals("one", cache.get(1));
        assertEquals("three", cache.get(3));

        // Expecting 2 to be evicted
        assertNull(cache.get(2));

        cache.clear();
        assertEquals(0, cache.size());

        cache.insert(1, "one");
        cache.insert(2, "two");
        assertEquals(2, cache.size());
        cache.insert(3, "three");
        assertEquals(2, cache.size());
        assertNull(cache.get(1));   // Expecting 1 to be evicted
        assertEquals("two", cache.get(2));
        assertEquals("three", cache.get(3));

        // Remove item
        cache.remove(2);
        assertEquals(1, cache.size());
        assertNull(cache.get(2));
        assertEquals("three", cache.get(3));

    }
}
