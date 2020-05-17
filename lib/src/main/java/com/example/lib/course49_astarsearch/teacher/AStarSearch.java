package com.example.lib.course49_astarsearch.teacher;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * A*�㷨������ʽ�����㷨���Ľ���dijkstra�㷨�����·���㷨�����ܹ����Ӹ�Ч����ȡ�Ӷ���s������i��·�ߣ�������·�߲������·�ߣ�
 * ֻ����Խ϶̵�·�ߣ�
 * ����ʽ�����㷨������������������پ��룬�������������Ӷ�������ۺ�����ͨ�����ۺ���������ƫ·�ߣ�̰�ĵĳ������п��ܵ����յ�ķ���ǰ����
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

    private LinkedList<Edge> adj[]; // �ڽӱ�
    private int v; // �������

    public AStarSearch(int v) {
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


    private class Vertex {
        public int id; // ������ ID
        public int dist; // ����ʼ���㣬���������ľ��룬Ҳ���� g(i)
        public int f; // ������f(i)=g(i)+h(i)
        public int x, y; // �����������ڵ�ͼ�е����꣨x, y��

        public Vertex(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.f = Integer.MAX_VALUE;
            this.dist = Integer.MAX_VALUE;
        }
    }

    // Graph ��ĳ�Ա�������ڹ��캯���г�ʼ��
    Vertex[] vertexes = new Vertex[this.v];

    // ����һ����������Ӷ��������
    public void addVetex(int id, int x, int y) {
        vertexes[id] = new Vertex(id, x, y);
    }

    public void astar(int s, int t) { // �Ӷ��� s ������ t ��·��
        int[] predecessor = new int[this.v]; // ������ԭ·��
        // ���� vertex �� f ֵ������С���ѣ������ǰ��� dist
        PriorityQueue<Vertex> queue = new PriorityQueue(this.v, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Vertex vertex1 = (Vertex) o1;
                Vertex vertex2 = (Vertex) o2;
                if (vertex1.f <= vertex2.f)
                    return 0;
                else
                    return 1;
            }
        });
        boolean[] inqueue = new boolean[this.v]; // ����Ƿ���������
        vertexes[s].dist = 0;
        vertexes[s].f = 0;
        queue.add(vertexes[s]);
        inqueue[s] = true;
        while (!queue.isEmpty()) {
            Vertex minVertex = queue.poll(); // ȡ�Ѷ�Ԫ�ز�ɾ��
            for (int i = 0; i < adj[minVertex.id].size(); ++i) {
                Edge e = adj[minVertex.id].get(i); // ȡ��һ�� minVetex �����ı�
                Vertex nextVertex = vertexes[e.tid]; // minVertex-->nextVertex
                if (minVertex.dist + e.w < nextVertex.dist) { // ���� next �� dist,f
                    nextVertex.dist = minVertex.dist + e.w;
                    nextVertex.f
                            = nextVertex.dist + hManhattan(nextVertex, vertexes[t]);
                    predecessor[nextVertex.id] = minVertex.id;
                    if (inqueue[nextVertex.id] == true) {
                        queue.remove(nextVertex);
                        queue.add(nextVertex);
                    } else {
                        queue.add(nextVertex);
                        inqueue[nextVertex.id] = true;
                    }
                }
                if (nextVertex.id == t) { // ֻҪ���� t �Ϳ��Խ��� while ��
                    queue.clear(); // ��� queue�������Ƴ� while ѭ��
                    break;
                }
            }
        }
        // ���·��
        System.out.print(s);
        print(s, t, predecessor); // print ������ο� dijkstra �㷨��ʵ��
    }

    int hManhattan(Vertex v1, Vertex v2) { // Vertex ��ʾ���㣬�����ж���
        return Math.abs(v1.x - v2.x) + Math.abs(v1.y - v2.y);
    }


    private void print(int s, int t, int[] predecessor) {
        if (s == t) return;
        print(s, predecessor[t], predecessor);
        System.out.print("->" + t);
    }


    public static void main(String[] args) {
//        �ο�AStart.jpgͼƬ
        AStarSearch graph = new AStarSearch(6);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 4, 15);
        graph.addEdge(1, 2, 15);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 5, 5);
        graph.addEdge(3, 2, 1);
        graph.addEdge(3, 5, 12);
        graph.addEdge(4, 5, 10);
        graph.astar(0, 5);
    }


}
