package com.example.lib.course62_exercise.graph;

import java.util.LinkedList;

/**
 * 拓扑排序：存在两两依赖关系，然后求排序，比如：文件A依赖文件B，文件B依赖文件C，求他们的编译顺序，即拓扑排序
 * 凡是需要通过局部顺序来推导全局顺序的，一般都用拓扑排序来解决
 */

public class TopologySortExercise {

    private int v;
    private LinkedList<Integer>[] adj; // 邻接表：存储图结构,LinkedList存储依赖某个顶点的所有顶点

    public TopologySortExercise(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * s 依赖 t
     *
     * @param s
     * @param t
     */
    public void addEdge(int s, int t) {
        adj[t].add(s);
    }

    /**
     * Kahn拓扑排序
     */
    public void topoSortByKahn() {
        int[] degree = new int[v]; // 统计每个顶点的入度,也就是依赖数，为0则证明自身没有依赖其它任何节点
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                int w = adj[i].get(j); // w 依赖 i
                degree[w]++;
            }
        }
        LinkedList<Integer> list = new LinkedList<>(); // 存储入度为0的顶点，即没有依赖任何顶点
        for (int i = 0; i < v; i++) {
            if (degree[i] == 0)
                list.add(i);
        }
        while (!list.isEmpty()) {
            int w = list.poll(); // 加载
            System.out.print("->" + w);
            for (int i = 0; i < adj[w].size(); i++) {
                int p = adj[w].get(i); // p 依赖 w
                degree[p]--;
                if (degree[p] == 0)
                    list.add(p);
            }
        }
    }

    /**
     * 深度优先遍历 -> DFS算法实现拓扑排序
     */
    public void topoSortByDsf() {
        LinkedList<Integer>[] adjN = new LinkedList[v]; // 逆邻接表，链表存储顶点依赖的所有顶点
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                int w = adj[i].get(j); // w 依赖 i
                adjN[w].add(i);
            }
        }
        boolean[] visited = new boolean[v]; // 访问过的顶点
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dsfIn(i, adjN, visited);
            }
        }
    }

    /**
     * 深度优先遍历 -> DFS算法实现拓扑排序
     */
    public void dsfIn(int vertex, LinkedList<Integer>[] adjN, boolean[] visited) {
        // 先加载顶点vertex依赖的所有顶点，再加载自身
        for (int i = 0; i < adjN[vertex].size(); i++) {
            int w = adj[vertex].get(i);
            if (!visited[w]) {
                visited[i] = true;
                dsfIn(w, adjN, visited);
            }
        }
        System.out.print("->" + vertex);
    }
}
