package com.example.lib.course42_topologicalsort.my;

import java.util.LinkedList;

/**
 * 拓扑排序：存在两两依赖关系，然后求排序，比如：文件A依赖文件B，文件B依赖文件C，求他们的编译顺序，即拓扑排序
 * 凡是需要通过局部顺序来推导全局顺序的，一般都用拓扑排序来解决
 * Created by qinshunan on 2019/5/16.
 */

public class MyTopologicalSort {

    // 拓扑排序的数据结构
    private int v; // 顶点个数
    private LinkedList<Integer>[] adj; // 邻接矩表，存放节点图关系

    public MyTopologicalSort(int v) {
        this.v = v;
        // 初始化
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 添加顶点依赖关系
     *
     * @param s
     * @param t
     */
    public void addRely(int s, int t) { // s依赖t,则t指向s : t -> s
        adj[t].add(s);
    }

    /**
     * Kahn算法实现拓扑排序
     */
    public void sortByKahn() {
        int[] degressList = new int[v]; // 统计每个顶点的入度,也就是依赖数，为0则证明自身没有依赖其它任何节点,即可以作为首要输出节点

        // 求出所有节点的入度
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                int w = adj[i].get(j); // w依赖i,i -> w
                degressList[w]++; // 有依赖数则入度加一
            }
        }

        LinkedList<Integer> zeroV = new LinkedList<>(); // 存放当前不依赖任何节点的节点，即入度为0的节点
        for (int i = 0; i < v; i++) {
            if (degressList[i] == 0)
                zeroV.add(i);
        }

        while (!zeroV.isEmpty()) {
            int a = zeroV.remove(); // 取出一个节点，并从队列中删除
            System.out.print(a + " -> "); // 打印出来，相当于选中，排序在前面

            // 然后将所有依赖于节点a的节点入度减一
            for (int i = 0; i < adj[a].size(); i++) {
                int w = adj[a].get(i);
                degressList[w]--;
                if (degressList[w] == 0) // 减到0就加入队列
                    zeroV.add(w);
            }
        }
    }

    /**
     * 深度优先遍历 -> DFS算法实现拓扑排序
     */
    public void sortByDFS() {
        LinkedList<Integer>[] reverseAdj = new LinkedList[v]; // 逆邻接表,跟邻接表对应关系刚好相反
        for (int i = 0; i < v; i++) {
            reverseAdj[i] = new LinkedList<>();
        }
        // 逆邻接表赋值
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                // w依赖i
                int w = adj[i].get(j); // i -> w
                adj[w].add(i); // w -> i
            }
        }

        boolean[] dfsValue = new boolean[v]; // 记录以及遍历过的值,这一步很关键，防止重复遍历

        for (int i = 0; i < v; i++) {
            if (!dfsValue[i]) {
                dfsValue[i] = true;
                DFS(i, reverseAdj, dfsValue);
            }
        }
    }

    /**
     * 遍历节点i的所有依赖节点，并一层一层传到下去，直到某个节点没有依赖任何节点，就打印出来，然后打印依赖他的节点
     *
     * @param i
     * @param reverseAdj
     * @param dfsValue
     */
    private void DFS(int i, LinkedList<Integer>[] reverseAdj, boolean[] dfsValue) {
        for (int j = 0; j < reverseAdj[i].size(); j++) {
            int w = reverseAdj[i].get(j);
            if (!dfsValue[w]) {
                dfsValue[w] = true;
                DFS(w, reverseAdj, dfsValue);
            }
        }
        // 先把 i 这个顶点可达的所有顶点都打印出来之后，再打印它自己
        System.out.print(i + " -> ");
    }

}
