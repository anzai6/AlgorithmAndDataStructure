package com.example.lib.course62_exercise.graph;

/**
 * ��
 */
public class AStarEdge {
    Point startPoint; // ��ʼ����
    Point endPoint; // �ߵ��յ�
    int weight; // �ߵ�Ȩ��

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
