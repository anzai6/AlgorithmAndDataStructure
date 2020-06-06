package com.example.lib.course42_topologicalsort.finals;

import java.util.LinkedList;

/**
 * 拓扑排序：存在两两依赖关系，然后求排序，比如：文件A依赖文件B，文件B依赖文件C，求他们的编译顺序，即拓扑排序
 * 凡是需要通过局部顺序来推导全局顺序的，一般都用拓扑排序来解决
 * Created by qinshunan on 2019/5/16.
 */

public class TopologicalSort {

    // 拓扑排序的数据结构
    private int v; // 顶点个数
    private LinkedList<Integer>[] adj; // 邻接矩表，存放节点图关系

    public TopologicalSort(int v) {
    }

    /**
     * 添加顶点依赖关系
     *
     * @param s
     * @param t
     */
    public void addRely(int s, int t) { // s依赖t,则t指向s : t -> s
    }

    /**
     * Kahn算法实现拓扑排序
     */
    public void sortByKahn() {
    }

    /**
     * 深度优先遍历 -> DFS算法实现拓扑排序
     */
    public void sortByDFS() {
    }

    /**
     * 遍历节点i的所有依赖节点，并一层一层传到下去，直到某个节点没有依赖任何节点，就打印出来，然后打印依赖他的节点
     *
     * @param i
     * @param reverseAdj
     * @param dfsValue
     */
    private void DFS(int i, LinkedList<Integer>[] reverseAdj, boolean[] dfsValue) {
    }

}
