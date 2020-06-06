package com.example.lib.course49_astarsearch.finals;

import com.example.lib.course62_exercise.graph.Edge;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * A*�㷨������ʽ�����㷨���Ľ���dijkstra�㷨�����·���㷨�����ܹ����Ӹ�Ч����ȡ�Ӷ���s������i��·�ߣ�������·�߲������·�ߣ�
 * ֻ����Խ϶̵�·�ߣ�
 * ����ʽ�����㷨����������������Ͷپ��룬�������������Ӷ�������ۺ�����ͨ�����ۺ���������ƫ·�ߣ�̰�ĵĳ������п��ܵ����յ�ķ���ǰ����
 */
public class AStarSearch {

    /**
     * �����پ��룺����������ݺ�����ľ���֮�ͣ��������£�����s(x1,y2),i(x2,y2);
     * h(i) = Math.abs(x1 - x2) + Math.abs(y2 - y2);
     * <p>
     * <p>
     * ���ۺ���: f(i)
     * ��������(�����پ���): h(i)
     * ���s���յ�i��·������: g(i)
     * f(i) = h(i) + g(i);
     * <p>
     * ��f(i)����dijkstra�㷨�е�������룬��g(i)��Ȼ����whileѭ����ֻҪ����������i��ֱ����ֹ��������
     * <p>
     * ���������پ�����Ҫ�Ƿ�ֹ��Ч�ı�������ʵ�п��Լ����Ϊֱ����i�㷽������������s��i�㣬i��s��Ķ��棬��
     * ֱ����������Ѱ��·�ߣ������Ƕ���������������ȥ��������������ֻҪ�ҵ�i����У�������Ҫ�������ж�����ɴ�i���·��
     * ���е�����̰���㷨����Ȼ��õĽ����һ�������·�ߣ�ȴ�����Ч��
     */


    // ��ͼ��������λ�õ������ʻ·������ÿ��·����Ϊһ�����㣬·��Ϊ����ߣ�·�ĳ���Ϊ�ߵ�Ȩ�أ�������ͼ��һ��������Ȩͼ�����ݽṹ
    // ����ʵ�������ת��Ϊ�ɱ�����������


    private int v = 11; // �������
    private LinkedList<Edge>[] adj; // �ڽӱ�-������ʾͼ�Ľṹ
    private ArrayList<Point> mPointArrayList;

    public AStarSearch() {
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            // i����ʼ����ı�ţ��б������ʼ����i���������б�
            adj[i] = new LinkedList<>();
        }
        init();
    }

    public void init() {
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
     * ��ͼ�����һ����
     *
     * @param startPoint ��ʼ����
     * @param endPoint   ��ֹ����
     * @param w          �ߵ�Ȩ��
     */
    public void addEdge(Point startPoint, Point endPoint, int w) {
    }

    /**
     * ��Ӷ���s��t����Խ϶�·��·��(��ӡ����)
     *
     * @param startPoint ��ʵ����
     * @param endPoint   ��ֹ����
     */
    public void astart(Point startPoint, Point endPoint) {
    }

    private void printRoad(Point s, Point t, Point[] preVertex) {
        if (s == t) {
            return;
        }
        printRoad(s, preVertex[t.s], preVertex);
        System.out.print("->" + t.s);
    }

    /**
     * ����������������پ���
     *
     * @return
     */
//    int hManhattan(Vertex v1, Vertex v2) { // Vertex ��ʾ����
//    }

    public static void main(String[] args) {
        //        �ο�AStart.jpgͼƬ
        // �������11,12,13��������


        AStarSearch myAStartSearch = new AStarSearch();


        // ����Խ϶�·��,0�㵽10��
        myAStartSearch.astart(myAStartSearch.mPointArrayList.get(0), myAStartSearch.mPointArrayList.get(10));
    }


}
