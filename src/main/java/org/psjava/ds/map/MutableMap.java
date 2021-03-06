package org.psjava.ds.map;

/**
 * Not allows null key.
 * but allows null value.
 */
public interface MutableMap<K, V> extends Map<K, V> {
    void clear();

    void add(K key, V nullableValue);

    void replace(K key, V nullableValue);

    void addOrReplace(K key, V nullableValue);

    void remove(K key);
}
