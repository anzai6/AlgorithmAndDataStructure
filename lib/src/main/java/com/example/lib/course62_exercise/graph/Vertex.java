package com.example.lib.course62_exercise.graph;

/**
 * ĳ�����㵽��P����ľ���,pre��ǰһ������
 */
public class Vertex {
    int p;
    int distance = Integer.MAX_VALUE;
    int pre;

    public Vertex(int p, int distance) {
        this.p = p;
        this.distance = distance;
    }

    public Vertex(int p) {
        this.p = p;
    }

}
