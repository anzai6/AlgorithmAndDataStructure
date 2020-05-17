package com.example.lib.course43_shortestpath.my;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Dijkstra���·��-����Ȩͼ��ĳ��������֮������·��
 * ʵ�ʿ�������ؼ����ǰ�ʵ������ת�������ݽṹ��Ȼ���ٿ���ʹ�õ��㷨
 */

public class MyShortestPath {

    // ��ͼ��������λ�õ������ʻ·������ÿ��·����Ϊһ�����㣬·��Ϊ����ߣ�·�ĳ���Ϊ�ߵ�Ȩ�أ�������ͼ��һ��������Ȩͼ�����ݽṹ
    // ����ʵ�������ת��Ϊ�ɱ�����������

    private int v; // �������
    private LinkedList<Edge>[] adj; // �ڽӱ�-������ʾͼ�Ľṹ

    public MyShortestPath(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            // i����ʼ����ı�ţ��б������ʼ����i���������б�
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * ��ͼ�����һ����
     *
     * @param s ��ʼ������
     * @param t ��ֹ������
     * @param w �ߵ�Ȩ��
     */
    public void addEdge(int s, int t, int w) {
        adj[s].add(new Edge(s, t, w));
    }

    /**
     * ��
     */
    class Edge {
        int s; // �ߵ���ʼ������
        int t; // �ߵ���ֹ������
        int w; // �ߵ�Ȩ��

        public Edge(int s, int t, int w) {
            this.s = s;
            this.t = t;
            this.w = w;
        }
    }

    // ���㣬�������Ϊ�� dijkstra ʵ���õ�
    class Vertex {
        int t; // ��ǰ������
        int distance; // �洢����ʼ���㵽��ǰ����ľ���

        public Vertex(int t, int distance) {
            this.t = t;
            this.distance = distance;
        }
    }

    /**
     * ��Ӷ���s��t�����·��(��ӡ����)
     *
     * @param s ��ʵ����
     * @param t ��ֹ����
     */
    public void dijkstra(int s, int t) {
        int[] preVertex = new int[v]; // �±������·���Ķ��㣬ֵ�����·��������������һ�������ţ�������Ϊ�˷����ӡ���·��
        Vertex[] vertexList = new Vertex[v]; // ����ÿ�����㵽��ʼ�������̾��룬����ʼ���㵽��ÿһ����������·��
        // ��ʼ�������õ����������ĳ�ʼ����Ϊ���������ֵ
        for (int i = 0; i < v; i++) {
            vertexList[i] = new Vertex(i, Integer.MAX_VALUE);
        }
        // С���ѣ��洢����ʼ����s��������Ķ���
        PriorityQueue<Vertex> queue = new PriorityQueue<>(v, new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                Vertex vertex1 = (Vertex) o1;
                Vertex vertex2 = (Vertex) o2;
                if (vertex1.distance <= vertex2.distance)
                    return 0;
                else
                    return 1;
            }
        });
        boolean[] inQueue = new boolean[v]; // true��ʾ���㣨�±��ţ��Ѿ�������У���ֹ�ظ��������

        vertexList[s].distance = 0; // ������ľ���Ϊ0
        inQueue[s] = true;
        queue.add(vertexList[s]); // ��ʼ�������

        while (!queue.isEmpty()) {
            // ÿ�δ�С������ȡ����Сֵ��Ҳ���Ǵ���ʼ���㵽�������Ѿ������Ķ����е����·���Ķ���
            // ���൱��ÿ�δ����·���������±������������·�����������Ӷ�����ɾ��
            Vertex minVertex = queue.poll();
            if (minVertex.t == t) break;  // ���·��������
            // ���������������пɴ��
            for (int i = 0; i < adj[minVertex.t].size(); i++) {
                Edge edge = adj[minVertex.t].get(i); // minVertex -> nextVertex �ı�
                Vertex nextVertex = vertexList[edge.t]; // minVertex -> nextVertex
                // �������minVertex��nextVertex��·����֮ǰ�洢�Ķ̾��滻
                if (edge.w + minVertex.distance < nextVertex.distance) {
                    nextVertex.distance = edge.w + minVertex.distance; // ��ֵ���·��
                    preVertex[nextVertex.t] = minVertex.t; // ����ǰһ������
                    if (inQueue[nextVertex.t]) { // nextVertex�Ѿ��ڶ���
                        queue.remove(nextVertex);
                        queue.add(nextVertex);
                    } else {
                        queue.add(nextVertex);
                        inQueue[nextVertex.t] = true;
                    }
                }
            }
        }

        System.out.print("���·��Ϊ��" + s);
        printRoad(s, t, preVertex);
    }

    private void printRoad(int s, int t, int[] preVertex) {
        if (s == t) {
            return;
        }
        printRoad(s, preVertex[t], preVertex);
        System.out.print("->" + t);
    }

    public static void main(String[] args) {
        MyShortestPath myShortestPath = new MyShortestPath(6);
        myShortestPath.addEdge(0, 1, 10);
        myShortestPath.addEdge(0, 4, 15);
        myShortestPath.addEdge(1, 2, 15);
        myShortestPath.addEdge(1, 3, 2);
        myShortestPath.addEdge(2, 5, 5);
        myShortestPath.addEdge(3, 2, 1);
        myShortestPath.addEdge(3, 5, 12);
        myShortestPath.addEdge(4, 5, 10);
        // ����̾���(0->1->3->2->5)
        myShortestPath.dijkstra(0, 5);
    }

}
