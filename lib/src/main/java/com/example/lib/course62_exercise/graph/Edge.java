package com.example.lib.course62_exercise.graph;

/**
 * 边
 */
public class Edge {
    int startPoint; // 起始顶点
    int endPoint; // 边的终点
    int weight; // 边的权重

    public Edge(int startPoint, int endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Edge(int startPoint, int endPoint, int weight) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.weight = weight;
    }
}
