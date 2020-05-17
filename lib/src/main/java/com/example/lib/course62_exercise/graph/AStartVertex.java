package com.example.lib.course62_exercise.graph;

/**
 * 某个顶点到达P顶点的距离,pre是前一个顶点
 */
public class AStartVertex {
    Point p;
    int distance = Integer.MAX_VALUE;
    int f = Integer.MAX_VALUE; // 估价函数
    int h = Integer.MAX_VALUE; // 启发函数
    Point pre;


    public AStartVertex(Point p) {
        this.p = p;
    }

}
