package com.megetood.structure;

/**
 * 并查集接口union find
 *
 * @author chengdong.lei@hand-china.com 2020/09/07 9:32
 */
public interface UF {

    int getSize();

    /**
     * 两个元素是否在一个集合
     *
     * @param p
     * @param q
     * @return
     */
    boolean isConnected(int p, int q);

    /**
     * 并
     *
     * @param p
     * @param q
     */
    void unionElements(int p, int q);

}
