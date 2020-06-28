package com.example.lib.course31_graph.finals;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ����ͼ������������������㷨��������������㷨
 * ��ϰ����Ⱥ���ȷֱ��ҵ����Ⱥ���
 * Created by qinshunan on 2019/4/10.
 */

public class Graph {

    private int v; // ����ĸ���(����Ĭ�ϴ�0��v-1)
    private LinkedList<Integer>[] adj; // ������ڽӱ�

    public Graph(int v) {
        if (v <= 0) {
            throw new IllegalArgumentException("v is invalid");
        }
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * �������㻥Ϊ����
     *
     * @param s
     * @param t
     */
    public void addEdge(int s, int t) {
        if (s >= v || t >= v || s == t) {
            return;
        }
        adj[s].add(t);
        adj[t].add(s);
    }


    /**
     * ��������㷨���Ӷ���s��t�����·��
     *
     * @param s
     * @param t
     */
    public void bfs(int s, int t) {
        // ������ȼ��������
        boolean[] visited = new boolean[v]; // �洢�Ѿ������ĵ�
        int[] prev = new int[v]; // ��¼ÿһ�������ʵ��Ľڵ��·���ϵ�ǰһ���ڵ�
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        LinkedList<Integer> list = new LinkedList<>(); // ������ڱ����ĵ�
        list.add(s);
        visited[s] = true;
        while (!list.isEmpty()) {
            int i = list.poll();
            if (i == t) {
                printRoute(prev, t);
                break;
            }
            LinkedList<Integer> edgeList = adj[i];
            Iterator<Integer> iterator = edgeList.iterator();
            while (iterator.hasNext()) {
                int h = iterator.next();
                // û�з��ʹ������
                if (!visited[h]) {
                    list.add(h);
                    visited[h] = true;
                    // ����ǰ��·���������ӡ
                    prev[h] = i;
                }
            }
        }
    }

    /**
     * ��������㷨�����õݹ�˼�룬ֻҪ�ҵ�һ��·������ֹ
     *
     * @param s
     * @param t
     */
    public void dfs(int s, int t) {
        boolean[] visited = new boolean[v]; // �洢�Ѿ������ĵ�
        int[] prev = new int[v]; // ��¼ÿһ�������ʵ��Ľڵ��·���ϵ�ǰһ���ڵ�
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        visited[s] = true;
        re_dfs(s, t, visited, prev);
    }

    boolean foundRoute = false;

    private void re_dfs(int s, int t, boolean[] visited, int[] prev) {
        if (s == t) {
            foundRoute = true;
            printRoute(prev, t);
            return;
        }
        if (foundRoute) {
            return;
        }
        LinkedList<Integer> list = adj[s];
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int h = iterator.next();
            // û�з��ʹ�
            if (!visited[h]) {
                visited[h] = true;
                // ����ǰ��·���������ӡ
                prev[h] = s;
                // ��������
                re_dfs(h, t, visited, prev);
                if (foundRoute) {
                    return;
                }
                // ���еĻ�������
                visited[h] = false;
                prev[h] = -1;
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
        if (prev[t] >= 0) {
            printRoute(prev, prev[t]);
            System.out.print(" -> " + t);
        } else {
            System.out.print(t + "");
        }
    }

    /**
     * ͨ����������㷨��ȡĳ������n�Ⱥ��ѹ�ϵ
     *
     * @param s ĳ������
     * @param n
     */
    public Queue<Integer> getThreeByBfs(int s, int n) {
        return null;
    }

    /**
     * ͨ����������㷨��ȡĳ������n�Ⱥ��ѹ�ϵ
     *
     * @param s ĳ������
     * @param n
     */
    public Queue<Integer> getThreeByDfs(int s, int n) {
        return null;
    }

    private void reGetThreeByDfs(Queue<Integer> queue, boolean[] visited, int s, int n) {
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
        Graph myGraph = new Graph(8);
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
        myGraph.dfs(0, 7);

        // ��ȡn�Ⱥ���
//        myGraph.getThreeByBfs(0, 1);
//        myGraph.getThreeByDfs(0, 2); // ʵ�������⣬����׼ȷ
    }

}
