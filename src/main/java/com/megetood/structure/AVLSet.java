package com.megetood.structure;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/08 13:37
 */
public class AVLSet<E extends Comparable<E>> implements Set<E> {
    private AVLTree<E,Object> avl;

    public AVLSet() {
        avl = new AVLTree<>();
    }

    @Override
    public void add(E e) {
        avl.add(e,null);
    }

    @Override
    public void remove(E e) {
        avl.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return avl.contains(e);
    }

    @Override
    public int getSize() {
        return avl.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }
}
