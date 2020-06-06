package com.example.lib.course43_shortestpath.finals;

import com.example.lib.course62_exercise.graph.Edge;

import java.util.LinkedList;

/**
 * Dijkstra最短路径-有向权图中某两个顶点之间的最短路径
 * 实际开发中最关键的是把实际问题转化成数据结构，然后再考虑使用的算法
 */

public class ShortestPath {

    // 地图中求两个位置的最短行驶路径：将每个路口视为一个顶点，路视为有向边，路的长度为边的权重，整个地图是一个有向有权图的数据结构
    // 这样实际问题就转化为可编程问题求解了

    private int v; // 顶点个数
    private LinkedList<Edge>[] adj; // 邻接表-用来表示图的结构

    public ShortestPath(int v) {
    }

    /**
     * 往图中添加一条边
     *
     * @param s 起始顶点编号
     * @param t 终止顶点编号
     * @param w 边的权重
     */
    public void addEdge(int s, int t, int w) {
    }

    /**
     * 求从顶点s到t的最短路径(打印出来)
     *
     * @param s 其实顶点
     * @param t 终止顶点
     */
    public void dijkstra(int s, int t) {
    }

    private void printRoad(int s, int t, int[] preVertex) {
        if (s == t) {
            return;
        }
        printRoad(s, preVertex[t], preVertex);
        System.out.print("->" + t);
    }

    public static void main(String[] args) {
        ShortestPath myShortestPath = new ShortestPath(6);
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
