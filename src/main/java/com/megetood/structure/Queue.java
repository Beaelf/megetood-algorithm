package com.megetood.structure;

/**
 * 队列
 *
 * @author chengdong.lei@hand-china.com 2020/08/23 15:12
 */
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
