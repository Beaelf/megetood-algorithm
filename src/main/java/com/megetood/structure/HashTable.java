package com.megetood.structure;

import com.megetood.structure.Map;

import java.util.TreeMap;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/09 13:24
 */
public class HashTable<K extends Comparable<K>, V> implements Map<K, V> {
    /**
     * 哈希表容量
     */
    public static final int[] CAPACITY = {
            53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
            12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741
    };

    /**
     * 哈希冲突上界
     */
    private static final int UPPER_TOL = 10;

    /**
     * 哈希冲突下界
     */
    private static final int LOWER_TOL = 2;

    /**
     * 初始化容量
     */
    private int capacityIndex = 0;

    private TreeMap<K, V>[] hashTable; // 红黑树实现
    private int M;  // 长度
    private int size;

    public HashTable() {
        M = CAPACITY[capacityIndex];
        size = 0;
        hashTable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }

    // 哈希函数
    // 去除符号，计算偏移量
    private int hash(K key) {
        return key.hashCode() & 0x7fffffff % M;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;

            if (size >= UPPER_TOL * M && capacityIndex + 1 < CAPACITY.length) {
                capacityIndex++;
                resize(CAPACITY[capacityIndex]);
            }
        }
    }

    @Override
    public V remove(K key) {
        TreeMap<K, V> map = hashTable[hash(key)];
        V ret = null;
        if (map.containsKey(key)) {
            ret = map.remove(key);
            size--;

            if (size < LOWER_TOL * M && capacityIndex - 1 >= 0) {
                capacityIndex--;
                resize(CAPACITY[capacityIndex]);
            }
        }
        return ret;
    }

    private void resize(int newM) {
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newHashTable[i] = new TreeMap<>();
        }
        int oldM = M;
        this.M = newM;
        for (int i = 0; i < oldM; i++) {
            TreeMap<K, V> map = hashTable[i];
            for (K key : map.keySet()) {
                newHashTable[hash(key)].put(key, map.get(key));
            }
        }
        this.hashTable = newHashTable;
    }

    @Override
    public void set(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        map.put(key, value);
    }

    @Override
    public boolean contains(K key) {
        return hashTable[hash(key)].containsKey(key);
    }

    @Override
    public V get(K key) {
        return hashTable[hash(key)].get(key);
    }

}
