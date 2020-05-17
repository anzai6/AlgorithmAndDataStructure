package com.example.lib.course62_exercise.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ����Ȩͼ����ӱ��ʾ
 */

public class DirectedWeightedGraphExercise {

    private int mTotalPoint; // ����ĸ���
    private LinkedList<Edge>[] adj; // �ڽӱ�,��ʾͼ

    public DirectedWeightedGraphExercise(int points) {
        mTotalPoint = points;
        adj = new LinkedList[mTotalPoint];
        for (int i = 0; i < mTotalPoint; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * ���һ����(��Ȩ��,����)
     *
     * @param startPoint ���
     * @param endPoint   �յ�
     */
    public void addEdge(int startPoint, int endPoint) {
        Edge edge1 = new Edge(startPoint, endPoint);
        Edge edge2 = new Edge(endPoint, startPoint);
        adj[startPoint].add(edge1);
        adj[endPoint].add(edge2);
    }

    /**
     * ���һ����(��Ȩ��)
     *
     * @param startPoint ���
     * @param endPoint   �յ�
     * @param weight     Ȩ��
     */
    public void addEdge(int startPoint, int endPoint, int weight) {
        Edge edge = new Edge(startPoint, endPoint, weight);
        adj[startPoint].add(edge);
    }

    /**
     * ��������㷨����������룬��������Ȩͼ
     *
     * @param startPoint
     * @param endPoint
     */
    public void bfs(int startPoint, int endPoint) {
        boolean[] visited = new boolean[mTotalPoint]; // �洢���ʹ��Ķ���
        int[] pre = new int[mTotalPoint]; // �洢���±�Ϊ�����ǰһ���������Ķ��㣬�� s->a->b,��pre[b] = a;
        for (int i = 0; i < mTotalPoint; i++) {
            pre[i] = -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startPoint);
        visited[startPoint] = true;

        while (!queue.isEmpty()) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                Edge edge = adj[w].get(i);
                int p = edge.endPoint;
                if (!visited[p]) { // û�з��ʹ�
                    pre[p] = w;
                    visited[p] = true;
                    if (p == endPoint) { // �ҵ��յ�
                        System.out.println("��������㷨�ҵ�·����");
                        printRoute(pre, endPoint);
                        return;
                    } else {
                        queue.add(p);
                    }
                }
            }
        }
    }

    boolean isFound = false;

    /**
     * ��������㷨����������룬��������Ȩͼ����һ������̾���
     *
     * @param startPoint
     * @param endPoint
     */
    public void dfs(int startPoint, int endPoint) {
        boolean[] visited = new boolean[mTotalPoint]; // �洢���ʹ��Ķ���
        int[] pre = new int[mTotalPoint]; // �洢���±�Ϊ�����ǰһ���������Ķ��㣬�� s->a->b,��pre[b] = a;
        for (int i = 0; i < mTotalPoint; i++) {
            pre[i] = -1;
        }

        dfsIn(startPoint, endPoint, pre, visited);

        System.out.println("��������㷨�ҵ�·����");
        printRoute(pre, endPoint);
    }

    /**
     * ��������㷨�����õݹ�˼�룬ֻҪ�ҵ�һ��·������ֹ
     */
    public void dfsIn(int startPoint, int endPoint, int[] pre, boolean[] visited) {
        if (isFound)
            return;

        for (int i = 0; i < adj[startPoint].size(); i++) {
            if (isFound)
                return;
            Edge edge = adj[startPoint].get(i);
            int p = edge.endPoint;
            if (!visited[p]) {
                visited[p] = true;
                pre[p] = startPoint;
                if (p != endPoint) {
                    dfsIn(p, endPoint, pre, visited);
                } else { // �����յ�
                    isFound = true;
                    return;
                }
            }
        }
    }

    /**
     * ��ӡ��ȡ��·��
     *
     * @param prev
     * @param t
     */
    private void printRoute(int[] prev, int t) {
        int m = prev[t];
        if (m != -1) {
            System.out.print(t + "<-");
            printRoute(prev, m);
        } else {
            System.out.print(t + "");
        }
    }

    /**
     * ������������㷨
     * ��ȡĳ�������n�ȹ�ϵ��һ�Ⱦ��Ǻ��ѣ����Ⱦ��Ǻ��ѵĺ��ѣ����Ⱦ��Ǻ��ѵĺ��ѵĺ���
     *
     * @param s
     * @param n
     */
    public void getThreeByBfs(int s, int n) {
        if (n <= 0)
            return;
        boolean[] visited = new boolean[mTotalPoint]; // �洢���ʹ��Ķ���
        int count = 1;
        Queue<Integer> currentQueue = new LinkedList<>(); // ��ǰ������
        Queue<Integer> nextQueue = new LinkedList<>(); // ��һ��
        currentQueue.add(s);
        visited[s] = true;

        while (!currentQueue.isEmpty()) {
            int w = currentQueue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                Edge edge = adj[w].get(i);
                int p = edge.endPoint;
                if (!visited[p]) { // û�з��ʹ�
                    visited[p] = true;
                    nextQueue.add(p);
                }
            }
            if (currentQueue.isEmpty()) {
                if (count == n) {
                    printQueue(nextQueue);
                    return;
                } else {
                    count++;
                    currentQueue.addAll(nextQueue);
                    nextQueue.clear();
                }
            }
        }
    }

    /**
     * ��ӡ
     */
    private void printQueue(Queue<Integer> queue) {
        if (queue == null)
            return;
        while (queue.size() > 0) {
            System.out.print(queue.poll() + " ");
        }
    }

    public static void main(String[] args) {
        DirectedWeightedGraphExercise myGraph = new DirectedWeightedGraphExercise(8);
        myGraph.addEdge(0, 3);
        myGraph.addEdge(0, 1);
        myGraph.addEdge(1, 4);
        myGraph.addEdge(1, 2);
        myGraph.addEdge(2, 5);
        myGraph.addEdge(3, 4);
        myGraph.addEdge(4, 6);
        myGraph.addEdge(4, 5);
        myGraph.addEdge(5, 7);
        myGraph.addEdge(6, 7);
        // ��ϵͼ���£�
        // 0 ���� 1 ���� 2
        // |    |    |
        // 3 ���� 4 ���� 5
        //      |    |
        //      6 ���� 7
//        myGraph.bfs(0, 7); // 0-3-4-6-7
//        myGraph.dfs(0, 7);

        // ��ȡn�Ⱥ���
        myGraph.getThreeByBfs(0, 7);
    }
}
