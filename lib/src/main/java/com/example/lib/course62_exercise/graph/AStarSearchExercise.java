package com.example.lib.course62_exercise.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Astar
 */

public class AStarSearchExercise {

    private int mTotalPoint; // 顶点的个数
    private LinkedList<AStarEdge>[] adj; // 邻接表,表示图
    private ArrayList<Point> mPointArrayList;

    public AStarSearchExercise(int points) {
        mTotalPoint = points;
        adj = new LinkedList[mTotalPoint];
        for (int i = 0; i < mTotalPoint; i++) {
            adj[i] = new LinkedList<>();
        }
        //        参考AStart.jpg图片
        // 这里忽略11,12,13这三个点
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
     * 添加一条边(带权重)
     *
     * @param startPoint 起点
     * @param endPoint   终点
     * @param weight     权重
     */
    public void addEdge(Point startPoint, Point endPoint, int weight) {
        AStarEdge aStarEdge = new AStarEdge(startPoint, endPoint, weight);
        adj[startPoint.s].add(aStarEdge);
    }

    /**
     * 最短路径算法：从s到t
     *
     * @param startPoint
     * @param endPoint
     */
    public void aStarSearch(Point startPoint, Point endPoint) {
        if (startPoint == endPoint)
            return;
        AStartVertex[] vertexList = new AStartVertex[mTotalPoint]; // 存储s顶点到达所有顶点的距离
        for (int i = 0; i < mTotalPoint; i++) {
            Point point = mPointArrayList.get(i);
            vertexList[i] = new AStartVertex(point);
            vertexList[i].h = getH(point, endPoint);
        }
        boolean[] inQueue = new boolean[mTotalPoint]; // true表示顶点（下标编号）已经加入队列，防止重复加入队列
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
            AStartVertex w = queue.poll(); // 取出当前到达所有顶点的最短路径
            if (w.p == endPoint) {// 终止
                printRoute(vertexList, startPoint, endPoint);
                System.out.print("" + startPoint.s);
                return;
            }
            for (int i = 0; i < adj[w.p.s].size(); i++) {
                AStarEdge AStarEdge = adj[w.p.s].get(i);
                AStartVertex nextVertex = vertexList[AStarEdge.endPoint.s];
                int distance = w.distance + AStarEdge.weight;
                int f = distance + nextVertex.h;

                if (inQueue[AStarEdge.endPoint.s]) { // 已经在队列
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
     * 求两个顶点的曼哈顿距离
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

        // 求相对较短路径,0点到10点
        myAStartSearch.aStarSearch(myAStartSearch.mPointArrayList.get(0), myAStartSearch.mPointArrayList.get(10));
    }

}
