package com.example.lib.course62_exercise.graph;

/**
 * ������Ȩͼ����Ӿ����ʾ
 */

public class GraphExercise {

    int mTotalPoint; // ����ĸ���
    int[][] data; // �ڽӾ����ʾͼ

    public GraphExercise(int points) {
        mTotalPoint = points;
        int[][] data = new int[mTotalPoint][mTotalPoint];
    }

    /**
     * ���һ����
     *
     * @param startPoint
     * @param endPoint
     */
    public void addEde(int startPoint, int endPoint) {
        data[startPoint][endPoint] = 1; // ��Ȩͼ����ͳһ��ֵ1���������Ȩͼ���Ը������Ȩֵ
        data[endPoint][startPoint] = 1; // ����ͼ
    }
}
