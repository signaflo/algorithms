package com.signaflo.datastructures.maps;

import java.util.Optional;

public interface Map<K, V> {

    /**
     * Returns the number of entries in the map.
     *
     * @return The number of entries in the map.
     */
    int getSize();

    boolean isEmpty();

    /**
     * Return the value associated with the given key.
     *
     * @param key The key that maps to the value V.
     * @return The value associated with the given key.
     */
    Optional<V> get(K key);

    Optional<V> put(K key, V value);

    Optional<V> remove(K key);

    Iterable<K> keySet();

    Iterable<V> values();

    Iterable<Entry<K, V>> entrySet();

    interface Entry<K, V> {
        K getKey();
        V getValue();
    }


}
