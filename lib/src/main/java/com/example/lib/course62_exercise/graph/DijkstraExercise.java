package com.example.lib.course62_exercise.graph;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 最短路径算法
 */

public class DijkstraExercise {

    private int mTotalPoint; // 顶点的个数
    private LinkedList<Edge>[] adj; // 邻接表,表示图

    public DijkstraExercise(int points) {
        mTotalPoint = points;
        adj = new LinkedList[mTotalPoint];
        for (int i = 0; i < mTotalPoint; i++) {
            adj[i] = new LinkedList<>();
        }
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
     * 最短路径算法：从s到t
     *
     * @param s
     * @param t
     */
    public void dijkstra(int s, int t) {
        if (s == t)
            return;
        Vertex[] vertexList = new Vertex[mTotalPoint]; // 存储s顶点到达所有顶点的距离
        for (int i = 0; i < mTotalPoint; i++) {
            vertexList[i] = new Vertex(i);
        }
        boolean[] inQueue = new boolean[mTotalPoint]; // true表示顶点（下标编号）已经加入队列，防止重复加入队列
        PriorityQueue<Vertex> queue = new PriorityQueue<>(new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                if (o1.distance > o2.distance)
                    return 1;
                else
                    return -1;
            }
        });
        vertexList[s].distance = 0;
        queue.add(vertexList[s]);
        inQueue[s] = true;

        while (!queue.isEmpty()) {
            Vertex w = queue.poll(); // 取出当前到达所有顶点的最短路径
            if (w.p == t) {// 终止
                printRoute(vertexList, s, t);
                System.out.print("" + s);
                return;
            }
            for (int i = 0; i < adj[w.p].size(); i++) {
                Edge edge = adj[w.p].get(i);
                int distance = w.distance + edge.weight;
                Vertex nextVertex = vertexList[edge.endPoint];

                if (inQueue[edge.endPoint]) { // 已经在队列
                    if (distance < nextVertex.distance) {
                        nextVertex.pre = edge.startPoint;
                        nextVertex.distance = distance;
                        queue.remove(nextVertex);
                        queue.add(nextVertex);
                    }
                } else {
                    if (distance < nextVertex.distance) {
                        nextVertex.pre = edge.startPoint;
                        nextVertex.distance = distance;
                    }
                    queue.add(nextVertex);
                    inQueue[edge.endPoint] = true;
                }
            }
        }
    }

    public void printRoute(Vertex[] vertexList, int s, int t) {
        if (s == t)
            return;
        System.out.print(t + " <- ");
        printRoute(vertexList, s, vertexList[t].pre);
    }

    public static void main(String[] args) {
        DijkstraExercise myShortestPath = new DijkstraExercise(6);
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
