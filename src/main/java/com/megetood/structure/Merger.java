package com.megetood.structure;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/04 15:19
 */
public interface Merger<E> {
    E merge(E a, E b);
}
