package com.example.lib.course42_topologicalsort.teacher;

import java.util.LinkedList;

/**
 * 拓扑排序：存在两两依赖关系，然后求排序，比如：文件A依赖文件B，文件B依赖文件C，求他们的编译顺序，即拓扑排序
 * 凡是需要通过局部顺序来推导全局顺序的，一般都用拓扑排序来解决
 */
public class TopologicalSort {

    // 拓扑排序的数据结构
    private int v; // 顶点的个数
    private LinkedList<Integer> adj[]; // 邻接表

    public TopologicalSort(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    // 添加以来关系
    public void addEdge(int s, int t) { // s 先于 t，边 s->t
        adj[s].add(t);
    }

    /**
     * Kahn算法实现拓扑排序
     */
    public void topoSortByKahn() {
        int[] inDegree = new int[v]; // 统计每个顶点的入度,也就是依赖数，为0则证明自身没有依赖其它任何节点
        for (int i = 0; i < v; ++i) {
            for (int j = 0; j < adj[i].size(); ++j) {
                int w = adj[i].get(j); // i->w
                inDegree[w]++;
            }
        }
        LinkedList<Integer> queue = new LinkedList<>(); // 存放当前不依赖任何节点的节点，即入度为0的节点
        for (int i = 0; i < v; ++i) {
            if (inDegree[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int i = queue.remove();
            System.out.print("->" + i);
            for (int j = 0; j < adj[i].size(); ++j) {
                int k = adj[i].get(j);
                inDegree[k]--;
                if (inDegree[k] == 0) queue.add(k);
            }
        }
    }


    /**
     * 深度优先遍历 -> DFS算法实现拓扑排序
     */
    public void topoSortByDFS() {
        // 先构建逆邻接表，边 s->t 表示，s 依赖于 t，t 先于 s
        LinkedList<Integer> inverseAdj[] = new LinkedList[v];
        for (int i = 0; i < v; ++i) { // 申请空间
            inverseAdj[i] = new LinkedList<>();
        }
        for (int i = 0; i < v; ++i) { // 通过邻接表生成逆邻接表
            for (int j = 0; j < adj[i].size(); ++j) {
                int w = adj[i].get(j); // i->w
                inverseAdj[w].add(i); // w->i
            }
        }
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; ++i) { // 深度优先遍历图
            if (visited[i] == false) {
                visited[i] = true;
                dfs(i, inverseAdj, visited);
            }
        }
    }

    private void dfs(int vertex, LinkedList<Integer> inverseAdj[], boolean[] visited) {
        for (int i = 0; i < inverseAdj[vertex].size(); ++i) {
            int w = inverseAdj[vertex].get(i);
            if (visited[w] == true) continue;
            visited[w] = true;
            dfs(w, inverseAdj, visited);
        } // 先把 vertex 这个顶点可达的所有顶点都打印出来之后，再打印它自己
        System.out.print("->" + vertex);
    }


}
