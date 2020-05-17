package com.example.lib.course31_graph.my;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ����ͼ������������������㷨��������������㷨
 * ��ϰ����Ⱥ���ȷֱ��ҵ����Ⱥ���
 * Created by qinshunan on 2019/4/10.
 */

public class MyGraph {

    private int v; // ����ĸ���(����Ĭ�ϴ�0��v-1)
    private LinkedList<Integer>[] adj; // ������ڽӱ�

    public MyGraph(int v) {
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
        // ��ֹԽ��
        if ((s >= v || t >= v) && s == t)
            return;
        // ����ͼ����������Ҫ��
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
        if (s == t)
            return;
        boolean[] visited = new boolean[v]; // �Ѿ����ʹ��ĵ��Ӧ�±��ֵ��Ϊtrue
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>(); // �����ʵĵ�
        queue.add(s);
        int[] prev = new int[v]; // ��¼�㷨·�����±��Ӧ���㣬ֵ��Ӧ������·���ϵ���һ������
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }

        // �ж���ͼ�������
        while (queue.size() > 0) {
            int w = queue.poll();
            // �����ö�������ӱ�
            for (int i = 0; i < adj[w].size(); i++) {
                int p = adj[w].get(i);
                if (!visited[p]) { // ���δ���ʹ�
                    prev[p] = w;
                    if (p == t) { // �ҵ�Ŀ�궥��
                        System.out.println("��������㷨�ҵ�·����");
                        printRoute(prev, t);
                        return;
                    }
                    visited[p] = true;
                    queue.add(p);
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
        if (s == t)
            return;
        boolean[] visited = new boolean[v]; // �Ѿ����ʹ��ĵ��Ӧ�±��ֵ��Ϊtrue
        visited[s] = true;
        int[] prev = new int[v]; // ��¼�㷨·�����±��Ӧ���㣬ֵ��Ӧ������·���ϵ���һ������
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        foundRoute = false;
        re_dfs(s, t, visited, prev);
    }

    boolean foundRoute = false;

    private void re_dfs(int s, int t, boolean[] visited, int[] prev) {
        if (foundRoute == true)
            return;
        for (int i = 0; i < adj[s].size(); i++) {
            if (foundRoute == true)
                return;
            int p = adj[s].get(i);
            if (!visited[p]) { // ���δ���ʹ�
                visited[p] = true;
                prev[p] = s;
                if (p == t) {
                    foundRoute = true; // �ҵ�·������ֹ��������
                    System.out.println("��������㷨�ҵ�·����");
                    printRoute(prev, t);
                    return;
                } else {
                    re_dfs(p, t, visited, prev);
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
     * ͨ����������㷨��ȡĳ������n�Ⱥ��ѹ�ϵ
     *
     * @param s ĳ������
     * @param n
     */
    public Queue<Integer> getThreeByBfs(int s, int n) {
        if (n <= 0)
            return null;
        boolean[] visited = new boolean[v]; // �Ѿ����ʹ��ĵ��Ӧ�±��ֵ��Ϊtrue
        visited[s] = true;
        Queue<Integer> currentQueue = new LinkedList<>(); // ��ǰ���ʲ�ĵ�
        Queue<Integer> nextQueue = new LinkedList<>(); // �����ʲ�ĵ�
        currentQueue.add(s);
        int count = 0;

        // �ж���ͼ�������
        while (currentQueue.size() > 0) {
            int w = currentQueue.poll();
            // �����ö�������ӱ�
            for (int i = 0; i < adj[w].size(); i++) {
                int p = adj[w].get(i);
                if (!visited[p]) {
                    nextQueue.add(p);
                    visited[p] = true;
                }
            }
            if (currentQueue.size() == 0) { // ������һ��
                ++count;
                if (count == n) {
                    printQueue(nextQueue);
                    return nextQueue;
                } else {
                    currentQueue.clear();
                    currentQueue.addAll(nextQueue);
                    nextQueue.clear();
                }
            }
        }
        return nextQueue;
    }

    /**
     * ͨ����������㷨��ȡĳ������n�Ⱥ��ѹ�ϵ
     *
     * @param s ĳ������
     * @param n
     */
    public Queue<Integer> getThreeByDfs(int s, int n) {
        if (n <= 0)
            return null;
        boolean[] visited = new boolean[v]; // �Ѿ����ʹ��ĵ��Ӧ�±��ֵ��Ϊtrue
        Queue<Integer> queue = new LinkedList<>(); // n�Ⱥ����б�
        reGetThreeByDfs(queue, visited, s, n);
        printQueue(queue);
        return queue;
    }

    private void reGetThreeByDfs(Queue<Integer> queue, boolean[] visited, int s, int n) {
        if (n < 0)
            return;
        visited[s] = true;
        if(n == 0){
            queue.add(s);
            return;
        }
        for (int i = 0; i < adj[s].size(); i++) {
            int p = adj[s].get(i);
            if (!visited[p]) {
                if (n != 0) {
                    reGetThreeByDfs(queue, visited, p, n - 1);
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
        MyGraph myGraph = new MyGraph(8);
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
//        myGraph.bfs(0,7); // 0-3-4-6-7
//        myGraph.dfs(0, 7);

        // ��ȡn�Ⱥ���
        myGraph.getThreeByBfs(0, 1);
//        myGraph.getThreeByDfs(0, 2); // ʵ�������⣬����׼ȷ
    }

}
