package com.example.lib.course31_graph.finals;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 无向图：包含广度优先搜索算法和深度优先搜索算法
 * 练习：广度和深度分别找到三度好友
 * Created by qinshunan on 2019/4/10.
 */

public class Graph {

    private int v; // 顶点的个数(这里默认从0到v-1)
    private LinkedList<Integer>[] adj; // 顶点的邻接表

    public Graph(int v) {
        if (v <= 0) {
            throw new IllegalArgumentException("v is invalid");
        }
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 两个顶点互为连接
     *
     * @param s
     * @param t
     */
    public void addEdge(int s, int t) {
        if (s >= v || t >= v || s == t) {
            return;
        }
        adj[s].add(t);
        adj[t].add(s);
    }


    /**
     * 广度优先算法：从顶点s到t的最短路径
     *
     * @param s
     * @param t
     */
    public void bfs(int s, int t) {
        // 广度优先即按层遍历
        boolean[] visited = new boolean[v]; // 存储已经遍历的点
        int[] prev = new int[v]; // 记录每一个被访问到的节点的路径上的前一个节点
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        LinkedList<Integer> list = new LinkedList<>(); // 存放正在遍历的点
        list.add(s);
        visited[s] = true;
        while (!list.isEmpty()) {
            int i = list.poll();
            if (i == t) {
                printRoute(prev, t);
                break;
            }
            LinkedList<Integer> edgeList = adj[i];
            Iterator<Integer> iterator = edgeList.iterator();
            while (iterator.hasNext()) {
                int h = iterator.next();
                // 没有访问过就添加
                if (!visited[h]) {
                    list.add(h);
                    visited[h] = true;
                    // 设置前置路径，方便打印
                    prev[h] = i;
                }
            }
        }
    }

    /**
     * 深度优先算法：利用递归思想，只要找到一条路径就终止
     *
     * @param s
     * @param t
     */
    public void dfs(int s, int t) {
        boolean[] visited = new boolean[v]; // 存储已经遍历的点
        int[] prev = new int[v]; // 记录每一个被访问到的节点的路径上的前一个节点
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        visited[s] = true;
        re_dfs(s, t, visited, prev);
    }

    boolean foundRoute = false;

    private void re_dfs(int s, int t, boolean[] visited, int[] prev) {
        if (s == t) {
            foundRoute = true;
            printRoute(prev, t);
            return;
        }
        if (foundRoute) {
            return;
        }
        LinkedList<Integer> list = adj[s];
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int h = iterator.next();
            // 没有访问过
            if (!visited[h]) {
                visited[h] = true;
                // 设置前置路径，方便打印
                prev[h] = s;
                // 继续深入
                re_dfs(h, t, visited, prev);
                if (foundRoute) {
                    return;
                }
                // 不行的话，回溯
                visited[h] = false;
                prev[h] = -1;
            }
        }

    }

    /**
     * 打印获取的路径
     *
     * @param prev
     * @param t
     */
    private void printRoute(int[] prev, int t) {
        if (prev[t] >= 0) {
            printRoute(prev, prev[t]);
            System.out.print(" -> " + t);
        } else {
            System.out.print(t + "");
        }
    }

    /**
     * 通过广度优先算法获取某个顶点n度好友关系
     *
     * @param s 某个顶点
     * @param n
     */
    public Queue<Integer> getThreeByBfs(int s, int n) {
        return null;
    }

    /**
     * 通过深度优先算法获取某个顶点n度好友关系
     *
     * @param s 某个顶点
     * @param n
     */
    public Queue<Integer> getThreeByDfs(int s, int n) {
        return null;
    }

    private void reGetThreeByDfs(Queue<Integer> queue, boolean[] visited, int s, int n) {
    }

    /**
     * 打印
     */
    private void printQueue(Queue<Integer> queue) {
        if (queue == null)
            return;
        while (queue.size() > 0) {
            System.out.print(queue.poll() + " ");
        }
    }

    public static void main(String[] args) {
        Graph myGraph = new Graph(8);
        myGraph.addEdge(0, 3);
        myGraph.addEdge(0, 1);
        myGraph.addEdge(1, 4);
        myGraph.addEdge(1, 2);
        myGraph.addEdge(2, 5);
        myGraph.addEdge(3, 4);
        myGraph.addEdge(4, 6);
        myGraph.addEdge(4, 5);
        myGraph.addEdge(5, 7);
        myGraph.addEdge(6, 7);
        // 关系图如下：
        // 0 —— 1 —— 2
        // |    |    |
        // 3 —— 4 —— 5
        //      |    |
        //      6 —— 7
//        myGraph.bfs(0, 7); // 0-3-4-6-7
        myGraph.dfs(0, 7);

        // 获取n度好友
//        myGraph.getThreeByBfs(0, 1);
//        myGraph.getThreeByDfs(0, 2); // 实现有问题，不能准确
    }

}
