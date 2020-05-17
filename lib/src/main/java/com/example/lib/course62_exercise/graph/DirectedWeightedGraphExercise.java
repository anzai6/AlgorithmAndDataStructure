package com.example.lib.course62_exercise.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 有向权图：领接表表示
 */

public class DirectedWeightedGraphExercise {

    private int mTotalPoint; // 顶点的个数
    private LinkedList<Edge>[] adj; // 邻接表,表示图

    public DirectedWeightedGraphExercise(int points) {
        mTotalPoint = points;
        adj = new LinkedList[mTotalPoint];
        for (int i = 0; i < mTotalPoint; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 添加一条边(无权重,无向)
     *
     * @param startPoint 起点
     * @param endPoint   终点
     */
    public void addEdge(int startPoint, int endPoint) {
        Edge edge1 = new Edge(startPoint, endPoint);
        Edge edge2 = new Edge(endPoint, startPoint);
        adj[startPoint].add(edge1);
        adj[endPoint].add(edge2);
    }

    /**
     * 添加一条边(带权重)
     *
     * @param startPoint 起点
     * @param endPoint   终点
     * @param weight     权重
     */
    public void addEdge(int startPoint, int endPoint, int weight) {
        Edge edge = new Edge(startPoint, endPoint, weight);
        adj[startPoint].add(edge);
    }

    /**
     * 广度优先算法，求两点距离，适用于无权图
     *
     * @param startPoint
     * @param endPoint
     */
    public void bfs(int startPoint, int endPoint) {
        boolean[] visited = new boolean[mTotalPoint]; // 存储访问过的顶点
        int[] pre = new int[mTotalPoint]; // 存储以下标为顶点的前一个到达它的顶点，如 s->a->b,则pre[b] = a;
        for (int i = 0; i < mTotalPoint; i++) {
            pre[i] = -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startPoint);
        visited[startPoint] = true;

        while (!queue.isEmpty()) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                Edge edge = adj[w].get(i);
                int p = edge.endPoint;
                if (!visited[p]) { // 没有访问过
                    pre[p] = w;
                    visited[p] = true;
                    if (p == endPoint) { // 找到终点
                        System.out.println("广度优先算法找到路径：");
                        printRoute(pre, endPoint);
                        return;
                    } else {
                        queue.add(p);
                    }
                }
            }
        }
    }

    boolean isFound = false;

    /**
     * 深度优先算法，求两点距离，适用于无权图，不一定是最短距离
     *
     * @param startPoint
     * @param endPoint
     */
    public void dfs(int startPoint, int endPoint) {
        boolean[] visited = new boolean[mTotalPoint]; // 存储访问过的顶点
        int[] pre = new int[mTotalPoint]; // 存储以下标为顶点的前一个到达它的顶点，如 s->a->b,则pre[b] = a;
        for (int i = 0; i < mTotalPoint; i++) {
            pre[i] = -1;
        }

        dfsIn(startPoint, endPoint, pre, visited);

        System.out.println("深度优先算法找到路径：");
        printRoute(pre, endPoint);
    }

    /**
     * 深度优先算法：利用递归思想，只要找到一条路径就终止
     */
    public void dfsIn(int startPoint, int endPoint, int[] pre, boolean[] visited) {
        if (isFound)
            return;

        for (int i = 0; i < adj[startPoint].size(); i++) {
            if (isFound)
                return;
            Edge edge = adj[startPoint].get(i);
            int p = edge.endPoint;
            if (!visited[p]) {
                visited[p] = true;
                pre[p] = startPoint;
                if (p != endPoint) {
                    dfsIn(p, endPoint, pre, visited);
                } else { // 到达终点
                    isFound = true;
                    return;
                }
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
        int m = prev[t];
        if (m != -1) {
            System.out.print(t + "<-");
            printRoute(prev, m);
        } else {
            System.out.print(t + "");
        }
    }

    /**
     * 广度优先搜索算法
     * 获取某个顶点的n度关系：一度就是好友，二度就是好友的好友，三度就是好友的好友的好友
     *
     * @param s
     * @param n
     */
    public void getThreeByBfs(int s, int n) {
        if (n <= 0)
            return;
        boolean[] visited = new boolean[mTotalPoint]; // 存储访问过的顶点
        int count = 1;
        Queue<Integer> currentQueue = new LinkedList<>(); // 当前遍历层
        Queue<Integer> nextQueue = new LinkedList<>(); // 下一层
        currentQueue.add(s);
        visited[s] = true;

        while (!currentQueue.isEmpty()) {
            int w = currentQueue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                Edge edge = adj[w].get(i);
                int p = edge.endPoint;
                if (!visited[p]) { // 没有访问过
                    visited[p] = true;
                    nextQueue.add(p);
                }
            }
            if (currentQueue.isEmpty()) {
                if (count == n) {
                    printQueue(nextQueue);
                    return;
                } else {
                    count++;
                    currentQueue.addAll(nextQueue);
                    nextQueue.clear();
                }
            }
        }
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
        DirectedWeightedGraphExercise myGraph = new DirectedWeightedGraphExercise(8);
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
//        myGraph.dfs(0, 7);

        // 获取n度好友
        myGraph.getThreeByBfs(0, 7);
    }
}
