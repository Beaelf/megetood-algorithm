package com.megetood.structure.graph;

import com.megetood.structure.Array;

/**
 * 稀疏图：邻接表
 *
 * @author chengdong.lei@hand-china.com 2020/09/16 12:49
 */
public class SparseGraph {
    private int n;
    private int m;
    private boolean directed;
    private Array<Array<Integer>> g = new Array<>();

    public SparseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        for (int i = 0; i < n; i++) {
            g.addLast(new Array<>());
        }
    }

    public void addEdge(int v, int w) {
        checkRange(v, w);

        g.get(v).addLast(w);
        if (v != w && !directed) {
            g.get(w).addLast(v);
        }
        m++;
    }

    public boolean hasEdge(int v, int w) {
        checkRange(v, w);

        for (int i = 0; i < g.get(v).getSize(); i++) {
            if (g.get(v).get(i) == w) {
                return true;
            }
        }

        return false;
    }

    public AdjIterator adjIterator(int v) {
        return new AdjIterator(this, v);
    }

    private class AdjIterator {
        SparseGraph G;
        int v;
        int index;

        public AdjIterator(SparseGraph graph, int v) {
            this.G = graph;
            this.v = v;
            this.index = 0;
        }

        public int begin() {
            index = 0;
            if (G.g.get(v).getSize() != 0) {
                return G.g.get(v).get(index);
            }
            return -1;
        }

        public int next() {
            index++;
            if (index < G.g.get(v).getSize()) {
                return G.g.get(v).get(index);
            }
            return -1;
        }

        boolean end() {
            return index >= G.g.get(v).getSize();
        }
    }

    public int getN() {
        return n;
    }

    private void checkRange(int v, int w) {
        if (v < 0 || v >= n) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(v));
        }
        if (w < 0 || w >= n) {
            throw new IllegalArgumentException(outOfBoundsMsg(w));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", n: " + n;
    }

    public static void main(String[] args) {
        SparseGraph gra = GraphGenerator.generateS();
        for (int i = 0; i < gra.getN(); i++) {
            AdjIterator adj = gra.adjIterator(i);

            for (int w = adj.begin(); !adj.end(); w = adj.next()) {
                System.out.print(w + " ");
            }
            System.out.println();
        }
    }
}
