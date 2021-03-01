package com.megetood.structure;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/02 17:06
 */
public interface Set<E> {
    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}
