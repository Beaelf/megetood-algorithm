package com.megetood.structure;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/03 19:53
 */
public interface Map<K, V> {
    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V value);

    int getSize();

    boolean isEmpty();
}
