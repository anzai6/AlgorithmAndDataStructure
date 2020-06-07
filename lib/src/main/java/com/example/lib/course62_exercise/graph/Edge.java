package com.example.lib.course62_exercise.graph;

/**
 * ��
 */
public class Edge {
    int startPoint; // ��ʼ����
    int endPoint; // �ߵ��յ�
    int weight; // �ߵ�Ȩ��

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
