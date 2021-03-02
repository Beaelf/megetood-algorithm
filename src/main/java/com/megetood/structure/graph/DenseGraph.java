package com.megetood.structure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 稠密图：邻接矩阵
 *
 * @author chengdong.lei@hand-china.com 2020/09/16 12:49
 */
public class DenseGraph implements Graph{
    private int n;// 点
    private int m;// 边
    private boolean directed;// 是否有向
    private boolean[][] g;

    public DenseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = new boolean[n][n];
    }

    // 在索引为 v w 两个顶点vertex，建立连接
    @Override
    public void addEdge(int v, int w) {
        checkRange(v, w);

        if (hasEdge(v, w)) {
            return;
        }

        g[v][w] = true;
        if (!directed) {
            g[w][v] = true;
        }

        m++;
    }

    // 判断v,w之间是否有边edge
    public boolean hasEdge(int v, int w) {
        checkRange(v, w);
        return g[v][w];
    }

    public AdjIterator adjIterator(int v) {
        return new AdjIterator(this, v);
    }

    private class AdjIterator {
        DenseGraph G;
        int v;
        int index;

        public AdjIterator(DenseGraph graph, int v) {
            this.G = graph;
            this.v = v;
            this.index = -1;
        }

        public int begin() {
            index = -1;
            return next();
        }

        public int next() {
            for (index += 1; index < G.getN(); index++) {
                if (G.g[v][index]) {
                    return index;
                }
            }
            return -1;
        }

        boolean end() {
            return index >= G.getN();
        }
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

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public boolean[][] getG() {
        return g;
    }

    public static void main(String[] args) {
        DenseGraph graph = GraphGenerator.generateD();
        for (int i = 0; i < graph.getN(); i++) {
            AdjIterator adj = graph.adjIterator(i);
            for (int w = adj.begin(); !adj.end(); w = adj.next()) {
                System.out.print(w + " ");
            }
            System.out.println();
        }
    }
}
