package com.example.lib.course43_shortestpath.finals;

import com.example.lib.course62_exercise.graph.Edge;

import java.util.LinkedList;

/**
 * Dijkstra���·��-����Ȩͼ��ĳ��������֮������·��
 * ʵ�ʿ�������ؼ����ǰ�ʵ������ת�������ݽṹ��Ȼ���ٿ���ʹ�õ��㷨
 */

public class ShortestPath {

    // ��ͼ��������λ�õ������ʻ·������ÿ��·����Ϊһ�����㣬·��Ϊ����ߣ�·�ĳ���Ϊ�ߵ�Ȩ�أ�������ͼ��һ��������Ȩͼ�����ݽṹ
    // ����ʵ�������ת��Ϊ�ɱ�����������

    private int v; // �������
    private LinkedList<Edge>[] adj; // �ڽӱ�-������ʾͼ�Ľṹ

    public ShortestPath(int v) {
    }

    /**
     * ��ͼ�����һ����
     *
     * @param s ��ʼ������
     * @param t ��ֹ������
     * @param w �ߵ�Ȩ��
     */
    public void addEdge(int s, int t, int w) {
    }

    /**
     * ��Ӷ���s��t�����·��(��ӡ����)
     *
     * @param s ��ʵ����
     * @param t ��ֹ����
     */
    public void dijkstra(int s, int t) {
    }

    private void printRoad(int s, int t, int[] preVertex) {
        if (s == t) {
            return;
        }
        printRoad(s, preVertex[t], preVertex);
        System.out.print("->" + t);
    }

    public static void main(String[] args) {
        ShortestPath myShortestPath = new ShortestPath(6);
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
