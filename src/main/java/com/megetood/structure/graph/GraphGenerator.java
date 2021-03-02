package com.megetood.structure.graph;

import java.rmi.dgc.DGC;
import java.util.Random;

/**
 * description
 *
 * @author chengdong.lei@hand-china.com 2020/09/16 19:19
 */
public class GraphGenerator {
    /**
     *
     * @param n 顶点数
     * @param m 边数
     * @return
     */
    public static SparseGraph generateS(int n, int m){
        SparseGraph sparseGraph = new SparseGraph(n, false);
        Random ran = new Random();
        for (int i = 0; i < m; i++) {
            int a = ran.nextInt(n);
            int b = ran.nextInt(n);
            sparseGraph.addEdge(a,b);
        }
        return sparseGraph;
    }

    public static SparseGraph generateS(){
        return generateS(10,100);
    }

    public static DenseGraph generateD(int n, int m){
        DenseGraph graph = new DenseGraph(n, false);
        Random ran = new Random();
        for (int i = 0; i < m; i++) {
            int a = ran.nextInt(n);
            int b = ran.nextInt(n);
            graph.addEdge(a,b);
        }
        return graph;
    }

    public static DenseGraph generateD(){
       return generateD(10,100);
    }
}
