package com.example.lib.course62_exercise.graph;

/**
 * ĳ�����㵽��P����ľ���,pre��ǰһ������
 */
public class AStartVertex {
    Point p;
    int distance = Integer.MAX_VALUE;
    int f = Integer.MAX_VALUE; // ���ۺ���
    int h = Integer.MAX_VALUE; // ��������
    Point pre;


    public AStartVertex(Point p) {
        this.p = p;
    }

}
