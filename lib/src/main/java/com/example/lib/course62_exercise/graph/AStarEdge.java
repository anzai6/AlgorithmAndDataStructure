package com.example.lib.course62_exercise.graph;

/**
 * 边
 */
public class AStarEdge {
    Point startPoint; // 起始顶点
    Point endPoint; // 边的终点
    int weight; // 边的权重

    public AStarEdge(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public AStarEdge(Point startPoint, Point endPoint, int weight) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.weight = weight;
    }
}
