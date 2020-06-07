package com.example.lib.course43_shortestpath.teacher;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * ShortestPath-���·��-�Ȱ����ݽṹת����������Ȩͼ
 */
public class Graph { // ������Ȩͼ���ڽӱ��ʾ��
    private LinkedList<Edge> adj[]; // �ڽӱ�
    private int v; // �������

    public Graph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t, int w) { // ���һ����,s -> t
        this.adj[s].add(new Edge(s, t, w));
    }

    private class Edge {
        public int sid; // �ߵ���ʼ������
        public int tid; // �ߵ���ֹ������
        public int w; // Ȩ��

        public Edge(int sid, int tid, int w) {
            this.sid = sid;
            this.tid = tid;
            this.w = w;
        }
    }

    // �����������Ϊ�� dijkstra ʵ���õ�
    private class Vertex {
        public int id; // ������ ID
        public int dist; // ����ʼ���㵽�������ľ���

        public Vertex(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }

    public void dijkstra(int s, int t) { // �Ӷ��� s ������ t �����·��
        int[] predecessor = new int[this.v]; // ������ԭ���·��
        Vertex[] vertexes = new Vertex[this.v]; // ��ʼ���㵽��ÿһ����������·��
        for (int i = 0; i < this.v; ++i) {
            vertexes[i] = new Vertex(i, Integer.MAX_VALUE);
        }
        // С���Ѷ���
        PriorityQueue<Vertex> queue = new PriorityQueue(this.v, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Vertex vertex1 = (Vertex) o1;
                Vertex vertex2 = (Vertex) o2;
                if (vertex1.dist <= vertex2.dist)
                    return 0;
                else
                    return 1;
            }
        });
        boolean[] inEueue = new boolean[this.v]; // ����Ƿ���������
        vertexes[s].dist = 0;
        queue.add(vertexes[s]);
        inEueue[s] = true;

        while (!queue.isEmpty()) {
            Vertex minVertex = queue.poll(); // ȡ�Ѷ�Ԫ�ز�ɾ��
            if (minVertex.id == t) break; // ���·��������
            for (int i = 0; i < adj[minVertex.id].size(); ++i) {
                Edge e = adj[minVertex.id].get(i); // ȡ��һ�� minVetex �����ı�
                Vertex nextVertex = vertexes[e.tid]; // minVertex-->nextVertex
                if (minVertex.dist + e.w < nextVertex.dist) { // ���� next �� dist
                    nextVertex.dist = minVertex.dist + e.w;
                    predecessor[nextVertex.id] = minVertex.id;
                    if (inEueue[nextVertex.id] == true) {
                        // ���¶����е� dist ֵ
                        queue.remove(nextVertex);
                        queue.add(nextVertex);
                    } else {
                        queue.add(nextVertex);
                        inEueue[nextVertex.id] = true;
                    }
                }
            }
        }
        // ������·��
        System.out.print(s);
        print(s, t, predecessor);
    }

    private void print(int s, int t, int[] predecessor) {
        if (s == t) return;
        print(s, predecessor[t], predecessor);
        System.out.print("->" + t);
    }


    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 4, 15);
        graph.addEdge(1, 2, 15);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 5, 5);
        graph.addEdge(3, 2, 1);
        graph.addEdge(3, 5, 12);
        graph.addEdge(4, 5, 10);
        graph.dijkstra(0, 5);
    }
}


