package algo.java.cache;

import algo.java.data.structure.DoubleLinkedList;
import algo.java.data.structure.Node;

import java.util.HashMap;

/*
Leet code: https://leetcode.com/problems/lru-cache/description/

    High level idea:
        1. Create double linked list with key, value
        2. Create HashMap with key and DoubleLinkedList(ddl) item
        3. While reading, move item to front of the dll
        4. while inserting, remove last item from ddl and insert to head.
        5. Removing just remove item from cache and ddl

 */
public class LeastRecentlyUsedCache<K, V> {
    private final int capacity;

    private final DoubleLinkedList<CacheItem<K, V>> dlinkedList;
    private final HashMap<K, Node<CacheItem<K, V>>> cache;

    public LeastRecentlyUsedCache(int capacity) {
        if ( capacity <= 0) {
            throw new IllegalArgumentException("Invalid capacity");
        }
        this.capacity = capacity;
        dlinkedList = new DoubleLinkedList<>();
        cache = new HashMap<>();
    }

    public void insert(K key, V value) {
        if (capacity == cache.size()) {
            // Remove the least used item from cache
            K removedKey = dlinkedList.removeLast().key();
            cache.remove(removedKey);
        }
        CacheItem<K, V> item = new CacheItem<>(key, value);
        cache.put(key, dlinkedList.addFirst(item));
    }

    public void remove(K key) {
        if (cache.containsKey(key)) {
            dlinkedList.removeNode(cache.get(key));
            cache.remove(key);
        }
    }

    public V get(K key) {
        if (cache.containsKey(key)) {
            dlinkedList.moveToHead(cache.get(key));
            return cache.get(key).data.value();
        }
        return null;
    }

    public void clear() {
        cache.clear();
        dlinkedList.clear();
    }
    public int size() {
        return cache.size();
    }
}

