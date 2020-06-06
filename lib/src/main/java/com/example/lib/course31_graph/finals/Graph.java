package com.example.lib.course31_graph.finals;

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
    }

    /**
     * 两个顶点互为连接
     *
     * @param s
     * @param t
     */
    public void addEdge(int s, int t) {
    }


    /**
     * 广度优先算法：从顶点s到t的最短路径
     *
     * @param s
     * @param t
     */
    public void bfs(int s, int t) {
    }

    /**
     * 深度优先算法：利用递归思想，只要找到一条路径就终止
     *
     * @param s
     * @param t
     */
    public void dfs(int s, int t) {
    }

    boolean foundRoute = false;

    private void re_dfs(int s, int t, boolean[] visited, int[] prev) {

    }

    /**
     * 打印获取的路径
     *
     * @param prev
     * @param t
     */
    private void printRoute(int[] prev, int t) {

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
//        myGraph.bfs(0,7); // 0-3-4-6-7
//        myGraph.dfs(0, 7);

        // 获取n度好友
        myGraph.getThreeByBfs(0, 1);
//        myGraph.getThreeByDfs(0, 2); // 实现有问题，不能准确
    }

}
