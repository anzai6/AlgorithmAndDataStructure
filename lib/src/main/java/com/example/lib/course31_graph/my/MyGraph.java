package com.example.lib.course31_graph.my;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 无向图：包含广度优先搜索算法和深度优先搜索算法
 * 练习：广度和深度分别找到三度好友
 * Created by qinshunan on 2019/4/10.
 */

public class MyGraph {

    private int v; // 顶点的个数(这里默认从0到v-1)
    private LinkedList<Integer>[] adj; // 顶点的邻接表

    public MyGraph(int v) {
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
        // 防止越界
        if ((s >= v || t >= v) && s == t)
            return;
        // 无向图所以两个都要加
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
        if (s == t)
            return;
        boolean[] visited = new boolean[v]; // 已经访问过的点对应下标的值急为true
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>(); // 待访问的点
        queue.add(s);
        int[] prev = new int[v]; // 记录算法路径，下标对应顶点，值对应顶点在路径上的上一个顶点
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }

        // 有顶点就继续访问
        while (queue.size() > 0) {
            int w = queue.poll();
            // 遍历该顶点的连接表
            for (int i = 0; i < adj[w].size(); i++) {
                int p = adj[w].get(i);
                if (!visited[p]) { // 如果未访问过
                    prev[p] = w;
                    if (p == t) { // 找到目标顶点
                        System.out.println("广度优先算法找到路径：");
                        printRoute(prev, t);
                        return;
                    }
                    visited[p] = true;
                    queue.add(p);
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
        if (s == t)
            return;
        boolean[] visited = new boolean[v]; // 已经访问过的点对应下标的值急为true
        visited[s] = true;
        int[] prev = new int[v]; // 记录算法路径，下标对应顶点，值对应顶点在路径上的上一个顶点
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        foundRoute = false;
        re_dfs(s, t, visited, prev);
    }

    boolean foundRoute = false;

    private void re_dfs(int s, int t, boolean[] visited, int[] prev) {
        if (foundRoute == true)
            return;
        for (int i = 0; i < adj[s].size(); i++) {
            if (foundRoute == true)
                return;
            int p = adj[s].get(i);
            if (!visited[p]) { // 如果未访问过
                visited[p] = true;
                prev[p] = s;
                if (p == t) {
                    foundRoute = true; // 找到路径则终止其它遍历
                    System.out.println("深度优先算法找到路径：");
                    printRoute(prev, t);
                    return;
                } else {
                    re_dfs(p, t, visited, prev);
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
     * 通过广度优先算法获取某个顶点n度好友关系
     *
     * @param s 某个顶点
     * @param n
     */
    public Queue<Integer> getThreeByBfs(int s, int n) {
        if (n <= 0)
            return null;
        boolean[] visited = new boolean[v]; // 已经访问过的点对应下标的值急为true
        visited[s] = true;
        Queue<Integer> currentQueue = new LinkedList<>(); // 当前访问层的点
        Queue<Integer> nextQueue = new LinkedList<>(); // 待访问层的点
        currentQueue.add(s);
        int count = 0;

        // 有顶点就继续访问
        while (currentQueue.size() > 0) {
            int w = currentQueue.poll();
            // 遍历该顶点的连接表
            for (int i = 0; i < adj[w].size(); i++) {
                int p = adj[w].get(i);
                if (!visited[p]) {
                    nextQueue.add(p);
                    visited[p] = true;
                }
            }
            if (currentQueue.size() == 0) { // 遍历完一层
                ++count;
                if (count == n) {
                    printQueue(nextQueue);
                    return nextQueue;
                } else {
                    currentQueue.clear();
                    currentQueue.addAll(nextQueue);
                    nextQueue.clear();
                }
            }
        }
        return nextQueue;
    }

    /**
     * 通过深度优先算法获取某个顶点n度好友关系
     *
     * @param s 某个顶点
     * @param n
     */
    public Queue<Integer> getThreeByDfs(int s, int n) {
        if (n <= 0)
            return null;
        boolean[] visited = new boolean[v]; // 已经访问过的点对应下标的值急为true
        Queue<Integer> queue = new LinkedList<>(); // n度好友列表
        reGetThreeByDfs(queue, visited, s, n);
        printQueue(queue);
        return queue;
    }

    private void reGetThreeByDfs(Queue<Integer> queue, boolean[] visited, int s, int n) {
        if (n < 0)
            return;
        visited[s] = true;
        if(n == 0){
            queue.add(s);
            return;
        }
        for (int i = 0; i < adj[s].size(); i++) {
            int p = adj[s].get(i);
            if (!visited[p]) {
                if (n != 0) {
                    reGetThreeByDfs(queue, visited, p, n - 1);
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
        MyGraph myGraph = new MyGraph(8);
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
