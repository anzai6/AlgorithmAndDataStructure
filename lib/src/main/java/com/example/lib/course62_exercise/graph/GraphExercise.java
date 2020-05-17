package com.example.lib.course62_exercise.graph;

/**
 * 无向无权图：领接矩阵表示
 */

public class GraphExercise {

    int mTotalPoint; // 顶点的个数
    int[][] data; // 邻接矩阵表示图

    public GraphExercise(int points) {
        mTotalPoint = points;
        int[][] data = new int[mTotalPoint][mTotalPoint];
    }

    /**
     * 添加一条边
     *
     * @param startPoint
     * @param endPoint
     */
    public void addEde(int startPoint, int endPoint) {
        data[startPoint][endPoint] = 1; // 无权图这里统一赋值1，如果是有权图可以赋具体的权值
        data[endPoint][startPoint] = 1; // 无向图
    }
}
