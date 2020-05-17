package com.example.lib.course43_shortestpath.my;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Dijkstra最短路径-有向权图中某两个顶点之间的最短路径
 * 实际开发中最关键的是把实际问题转化成数据结构，然后再考虑使用的算法
 */

public class MyShortestPath {

    // 地图中求两个位置的最短行驶路径：将每个路口视为一个顶点，路视为有向边，路的长度为边的权重，整个地图是一个有向有权图的数据结构
    // 这样实际问题就转化为可编程问题求解了

    private int v; // 顶点个数
    private LinkedList<Edge>[] adj; // 邻接表-用来表示图的结构

    public MyShortestPath(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            // i是起始顶点的编号，列表保存从起始顶点i出发的所有边
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 往图中添加一条边
     *
     * @param s 起始顶点编号
     * @param t 终止顶点编号
     * @param w 边的权重
     */
    public void addEdge(int s, int t, int w) {
        adj[s].add(new Edge(s, t, w));
    }

    /**
     * 边
     */
    class Edge {
        int s; // 边的起始顶点编号
        int t; // 边的终止顶点编号
        int w; // 边的权重

        public Edge(int s, int t, int w) {
            this.s = s;
            this.t = t;
            this.w = w;
        }
    }

    // 顶点，这个类是为了 dijkstra 实现用的
    class Vertex {
        int t; // 当前顶点编号
        int distance; // 存储从起始顶点到当前顶点的距离

        public Vertex(int t, int distance) {
            this.t = t;
            this.distance = distance;
        }
    }

    /**
     * 求从顶点s到t的最短路径(打印出来)
     *
     * @param s 其实顶点
     * @param t 终止顶点
     */
    public void dijkstra(int s, int t) {
        int[] preVertex = new int[v]; // 下标是最短路径的顶点，值是最短路径中这个顶点的上一个顶点编号，这样是为了方便打印最短路径
        Vertex[] vertexList = new Vertex[v]; // 保存每个顶点到起始顶点的最短距离，即起始顶点到达每一个顶点的最短路径
        // 初始化并设置到达这个顶点的初始距离为整数的最大值
        for (int i = 0; i < v; i++) {
            vertexList[i] = new Vertex(i, Integer.MAX_VALUE);
        }
        // 小顶堆，存储从起始顶点s出发到达的顶点
        PriorityQueue<Vertex> queue = new PriorityQueue<>(v, new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                Vertex vertex1 = (Vertex) o1;
                Vertex vertex2 = (Vertex) o2;
                if (vertex1.distance <= vertex2.distance)
                    return 0;
                else
                    return 1;
            }
        });
        boolean[] inQueue = new boolean[v]; // true表示顶点（下标编号）已经加入队列，防止重复加入队列

        vertexList[s].distance = 0; // 到自身的距离为0
        inQueue[s] = true;
        queue.add(vertexList[s]); // 起始顶点入队

        while (!queue.isEmpty()) {
            // 每次从小顶堆中取出最小值，也就是从起始顶点到达所有已经遍历的顶点中的最短路径的顶点
            // 即相当于每次从最短路径顶点往下遍历，并把最短路径的这个顶点从队列中删除
            Vertex minVertex = queue.poll();
            if (minVertex.t == t) break;  // 最短路径产生了
            // 遍历这个顶点的所有可达边
            for (int i = 0; i < adj[minVertex.t].size(); i++) {
                Edge edge = adj[minVertex.t].get(i); // minVertex -> nextVertex 的边
                Vertex nextVertex = vertexList[edge.t]; // minVertex -> nextVertex
                // 如果经过minVertex到nextVertex的路径比之前存储的短就替换
                if (edge.w + minVertex.distance < nextVertex.distance) {
                    nextVertex.distance = edge.w + minVertex.distance; // 赋值最短路径
                    preVertex[nextVertex.t] = minVertex.t; // 设置前一个顶点
                    if (inQueue[nextVertex.t]) { // nextVertex已经在队列
                        queue.remove(nextVertex);
                        queue.add(nextVertex);
                    } else {
                        queue.add(nextVertex);
                        inQueue[nextVertex.t] = true;
                    }
                }
            }
        }

        System.out.print("最短路径为：" + s);
        printRoad(s, t, preVertex);
    }

    private void printRoad(int s, int t, int[] preVertex) {
        if (s == t) {
            return;
        }
        printRoad(s, preVertex[t], preVertex);
        System.out.print("->" + t);
    }

    public static void main(String[] args) {
        MyShortestPath myShortestPath = new MyShortestPath(6);
        myShortestPath.addEdge(0, 1, 10);
        myShortestPath.addEdge(0, 4, 15);
        myShortestPath.addEdge(1, 2, 15);
        myShortestPath.addEdge(1, 3, 2);
        myShortestPath.addEdge(2, 5, 5);
        myShortestPath.addEdge(3, 2, 1);
        myShortestPath.addEdge(3, 5, 12);
        myShortestPath.addEdge(4, 5, 10);
        // 求最短距离(0->1->3->2->5)
        myShortestPath.dijkstra(0, 5);
    }

}
