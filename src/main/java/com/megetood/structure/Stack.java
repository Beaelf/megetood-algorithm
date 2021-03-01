package com.megetood.structure;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/08/23 14:14
 */
public interface Stack<E> {
    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}

