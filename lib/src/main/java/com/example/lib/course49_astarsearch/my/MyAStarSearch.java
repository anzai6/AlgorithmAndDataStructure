package com.example.lib.course49_astarsearch.my;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * A*�㷨������ʽ�����㷨���Ľ���dijkstra�㷨�����·���㷨�����ܹ����Ӹ�Ч����ȡ�Ӷ���s������i��·�ߣ�������·�߲������·�ߣ�
 * ֻ����Խ϶̵�·�ߣ�
 * ����ʽ�����㷨����������������Ͷپ��룬�������������Ӷ�������ۺ�����ͨ�����ۺ���������ƫ·�ߣ�̰�ĵĳ������п��ܵ����յ�ķ���ǰ����
 */
public class MyAStarSearch {

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

    public MyAStarSearch() {
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
        adj[startPoint.s].add(new Edge(startPoint, endPoint, w));
    }

    /**
     * ��
     */
    class Edge {
        Point startPoint; // �ߵ���ʼ����
        Point endPoint; // �ߵ���ֹ����
        int w; // �ߵ�Ȩ��

        public Edge(Point startPoint, Point endPoint, int w) {
            this.startPoint = startPoint;
            this.endPoint = endPoint;
            this.w = w;
        }
    }

    // ���㣬�������Ϊ�� atar ʵ���õ�
    class Vertex {
        Point point; // ��ǰ����
        int distance = Integer.MAX_VALUE; // �洢����ʼ���㵽��ǰ����ľ���
        int f = Integer.MAX_VALUE; // ���ۺ���

        public Vertex(Point point) {
            this.point = point;
        }
    }

    /**
     * ��Ӷ���s��t����Խ϶�·��·��(��ӡ����)
     *
     * @param startPoint ��ʵ����
     * @param endPoint   ��ֹ����
     */
    public void astart(Point startPoint, Point endPoint) {
        Point[] preVertex = new Point[v]; // �±������·���Ķ��㣬ֵ�����·��������������һ�������ţ�������Ϊ�˷����ӡ���·��
        Vertex[] vertexList = new Vertex[v]; // ����ÿ�����㵽��ʼ�������̾��룬����ʼ���㵽��ÿһ����������·��
        // ��ʼ�������õ����������ĳ�ʼ����Ϊ���������ֵ
        for (int i = 0; i < v; i++) {
            vertexList[i] = new Vertex(mPointArrayList.get(i));
        }
        // С���ѣ��洢����ʼ����s��������Ķ���
        PriorityQueue<Vertex> queue = new PriorityQueue<>(v, new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                Vertex vertex1 = o1;
                Vertex vertex2 = o2;
                if (vertex1.f <= vertex2.f) // ����ʹ�ù��ۺ��������ǵ�����ʹ�þ���
                    return 0;
                else
                    return 1;
            }
        });
        boolean[] inQueue = new boolean[v]; // true��ʾ���㣨�±��ţ��Ѿ�������У���ֹ�ظ��������

        vertexList[startPoint.s].distance = 0; // ������ľ���Ϊ0
        vertexList[startPoint.s].f = 0; // ������Ĺ��ۺ�������Ϊ0
        inQueue[startPoint.s] = true;
        queue.add(vertexList[startPoint.s]); // ��ʼ�������

        while (!queue.isEmpty()) {
            // ÿ�δ�С������ȡ����Сֵ��Ҳ���Ǵ���ʼ���㵽�������Ѿ������Ķ����е����·���Ķ���
            // ���൱��ÿ�δ����·���������±������������·�����������Ӷ�����ɾ��
            Vertex minVertex = queue.poll();

            // ���������������пɴ��
            for (int i = 0; i < adj[minVertex.point.s].size(); i++) {
                Edge edge = adj[minVertex.point.s].get(i); // minVertex -> nextVertex �ı�
                Vertex nextVertex = vertexList[edge.endPoint.s]; // minVertex -> nextVertex

                // �������minVertex��nextVertex��·����֮ǰ�洢�Ķ̾��滻,����ʹ�õĻ���·�����Ƚϣ�
                if (edge.w + minVertex.distance < nextVertex.f) {

                    nextVertex.distance = edge.w + minVertex.distance; // ��ֵ���·��
                    // ���¸�ֵ���ۺ�����ֵ
                    nextVertex.f = nextVertex.distance + hManhattan(nextVertex, vertexList[endPoint.s]);
                    preVertex[nextVertex.point.s] = minVertex.point; // ����ǰһ������
                    if (inQueue[nextVertex.point.s]) { // nextVertex�Ѿ��ڶ���
                        queue.remove(nextVertex);
                        queue.add(nextVertex);
                    } else {
                        queue.add(nextVertex);
                        inQueue[nextVertex.point.s] = true;
                    }
                }

                if (nextVertex.point.s == endPoint.s) { // ֻҪ���� endPoint �Ϳ��Խ��� while ��
                    queue.clear(); // ��� queue�������˳� while ѭ��
                    break;
                }
            }
        }

        System.out.print("���·��Ϊ��" + startPoint.s);
        printRoad(startPoint, endPoint, preVertex);
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
     * @param v1
     * @param v2
     * @return
     */
    int hManhattan(Vertex v1, Vertex v2) { // Vertex ��ʾ����
        return Math.abs(v1.point.x - v2.point.x) + Math.abs(v1.point.y - v2.point.y);
    }

    public static void main(String[] args) {
        //        �ο�AStart.jpgͼƬ
        // �������11,12,13��������


        MyAStarSearch myAStartSearch = new MyAStarSearch();


        // ����Խ϶�·��,0�㵽10��
        myAStartSearch.astart(myAStartSearch.mPointArrayList.get(0), myAStartSearch.mPointArrayList.get(10));
    }


}
