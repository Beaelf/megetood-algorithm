package com.megetood.executor.search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Binary Search Tree
 *
 * @author chengdong.lei@hand-china.com 2020/08/26 13:00
 */
public class BST<K extends Comparable<K>, V extends Comparable<V>> {


    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 添加元素
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    // 添加元素，递归算法
    public Node put(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.equals(node.key)) {
            node.value = value;
        } else if (key.compareTo(node.key) < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.right = put(node.right, key, value);
        }
        return node;
    }

    // 判断是否包含某个元素
    public boolean contains(K key) {
        return contains(root, key);
    }

    public boolean contains(Node node, K key) {
        if (node == null) {
            return false;
        }

        if (key.compareTo(node.key) == 0) {
            return true;
        } else if (key.compareTo(node.key) < 0) {
            return contains(node.left, key);
        } else {
            return contains(node.right, key);
        }

    }

    public V get(K key){
        return get(root, key);
    }

    private V get(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) == 0) {
            return node.value;
        } else if (key.compareTo(node.key) < 0) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
    }

    public static void main(String[] args) {
        BST<Integer,String> bst = new BST<>();
        bst.put(1,"kj");
        bst.put(9,"jll");
        bst.put(8,"djls");
        bst.put(2,"jj");
        bst.put(3,"bb");
        System.out.println(bst.get(3));
    }
}
