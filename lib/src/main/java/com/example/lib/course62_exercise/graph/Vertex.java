package com.example.lib.course62_exercise.graph;

/**
 * 某个顶点到达P顶点的距离,pre是前一个顶点
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
