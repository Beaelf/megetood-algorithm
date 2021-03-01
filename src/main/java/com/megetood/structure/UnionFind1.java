package com.megetood.structure;

/**
 * 并查集
 *
 * @author chengdong.lei@hand-china.com 2020/09/07 9:40
 */
public class UnionFind1 implements UF {
    // 存放数据对应的集合编号
    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];
        // 初始化，每个元素没有交集
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    // p,q是否是同一个集合
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if(pID==qID){
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if(id[i]==pID){
                id[i]=qID;
            }
        }
    }

    // 返回p对应的集合编号
    private int find(int p) {
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("p is out of bound");
        }
        return id[p];
    }
}
