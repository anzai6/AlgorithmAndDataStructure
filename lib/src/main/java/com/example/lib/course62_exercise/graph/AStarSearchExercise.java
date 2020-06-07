package com.example.lib.course62_exercise.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Astar
 */

public class AStarSearchExercise {

    private int mTotalPoint; // ����ĸ���
    private LinkedList<AStarEdge>[] adj; // �ڽӱ�,��ʾͼ
    private ArrayList<Point> mPointArrayList;

    public AStarSearchExercise(int points) {
        mTotalPoint = points;
        adj = new LinkedList[mTotalPoint];
        for (int i = 0; i < mTotalPoint; i++) {
            adj[i] = new LinkedList<>();
        }
        //        �ο�AStart.jpgͼƬ
        // �������11,12,13��������
        mPointArrayList = new ArrayList<>();
        Point point0 = new Point(0, 320, 630);
        Point point1 = new Point(1, 300, 630);
        Point point2 = new Point(2, 280, 625);
        Point point3 = new Point(3, 270, 630);
        Point point4 = new Point(4, 320, 700);
        Point point5 = new Point(5, 360, 620);
        Point point6 = new Point(6, 320, 590);
        Point point7 = new Point(7, 370, 580);
        Point point8 = new Point(8, 350, 730);
        Point point9 = new Point(9, 390, 690);
        Point point10 = new Point(10, 400, 620);
        mPointArrayList.add(point0);
        mPointArrayList.add(point1);
        mPointArrayList.add(point2);
        mPointArrayList.add(point3);
        mPointArrayList.add(point4);
        mPointArrayList.add(point5);
        mPointArrayList.add(point6);
        mPointArrayList.add(point7);
        mPointArrayList.add(point8);
        mPointArrayList.add(point9);
        mPointArrayList.add(point10);

        addEdge(point0, point1, 20);
        addEdge(point0, point4, 60);
        addEdge(point0, point5, 60);
        addEdge(point0, point6, 60);
        addEdge(point1, point2, 20);
        addEdge(point2, point3, 10);
        addEdge(point3, point4, 80);
        addEdge(point3, point6, 80);
        addEdge(point4, point8, 50);
        addEdge(point5, point8, 70);
        addEdge(point5, point9, 80);
        addEdge(point5, point10, 50);
        addEdge(point6, point7, 70);
        addEdge(point7, point10, 110);
        addEdge(point8, point9, 50);
        addEdge(point9, point10, 60);

    }

    /**
     * ���һ����(��Ȩ��)
     *
     * @param startPoint ���
     * @param endPoint   �յ�
     * @param weight     Ȩ��
     */
    public void addEdge(Point startPoint, Point endPoint, int weight) {
        AStarEdge aStarEdge = new AStarEdge(startPoint, endPoint, weight);
        adj[startPoint.s].add(aStarEdge);
    }

    /**
     * ���·���㷨����s��t
     *
     * @param startPoint
     * @param endPoint
     */
    public void aStarSearch(Point startPoint, Point endPoint) {
        if (startPoint == endPoint)
            return;
        AStartVertex[] vertexList = new AStartVertex[mTotalPoint]; // �洢s���㵽�����ж���ľ���
        for (int i = 0; i < mTotalPoint; i++) {
            Point point = mPointArrayList.get(i);
            vertexList[i] = new AStartVertex(point);
            vertexList[i].h = getH(point, endPoint);
        }
        boolean[] inQueue = new boolean[mTotalPoint]; // true��ʾ���㣨�±��ţ��Ѿ�������У���ֹ�ظ��������
        PriorityQueue<AStartVertex> queue = new PriorityQueue<>(new Comparator<AStartVertex>() {
            @Override
            public int compare(AStartVertex o1, AStartVertex o2) {
                if (o1.f > o2.f)
                    return 1;
                else
                    return -1;
            }
        });
        vertexList[startPoint.s].distance = 0;
        vertexList[startPoint.s].f = vertexList[startPoint.s].h;
        queue.add(vertexList[startPoint.s]);
        inQueue[startPoint.s] = true;

        while (!queue.isEmpty()) {
            AStartVertex w = queue.poll(); // ȡ����ǰ�������ж�������·��
            if (w.p == endPoint) {// ��ֹ
                printRoute(vertexList, startPoint, endPoint);
                System.out.print("" + startPoint.s);
                return;
            }
            for (int i = 0; i < adj[w.p.s].size(); i++) {
                AStarEdge AStarEdge = adj[w.p.s].get(i);
                AStartVertex nextVertex = vertexList[AStarEdge.endPoint.s];
                int distance = w.distance + AStarEdge.weight;
                int f = distance + nextVertex.h;

                if (inQueue[AStarEdge.endPoint.s]) { // �Ѿ��ڶ���
                    if (f < nextVertex.f) {
                        nextVertex.pre = AStarEdge.startPoint;
                        nextVertex.f = f;
                        nextVertex.distance = distance;
                        queue.remove(nextVertex);
                        queue.add(nextVertex);
                    }
                } else {
                    if (f < nextVertex.f) {
                        nextVertex.pre = AStarEdge.startPoint;
                        nextVertex.distance = distance;
                        nextVertex.f = f;
                    }
                    queue.add(nextVertex);
                    inQueue[AStarEdge.endPoint.s] = true;
                }
            }
        }
    }

    /**
     * ����������������پ���
     *
     * @return
     */
    public int getH(Point point1, Point point2) {
        return Math.abs(point1.x - point2.x) + Math.abs(point1.y - point2.y);
    }

    public void printRoute(AStartVertex[] vertexList, Point s, Point t) {
        if (s == t)
            return;
        System.out.print(t.s + " <- ");
        printRoute(vertexList, s, vertexList[t.s].pre);
    }

    public static void main(String[] args) {

        AStarSearchExercise myAStartSearch = new AStarSearchExercise(11);

        // ����Խ϶�·��,0�㵽10��
        myAStartSearch.aStarSearch(myAStartSearch.mPointArrayList.get(0), myAStartSearch.mPointArrayList.get(10));
    }

}
