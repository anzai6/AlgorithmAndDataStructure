package com.example.lib.course31_graph.finals;

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
    }

    /**
     * �������㻥Ϊ����
     *
     * @param s
     * @param t
     */
    public void addEdge(int s, int t) {
    }


    /**
     * ��������㷨���Ӷ���s��t�����·��
     *
     * @param s
     * @param t
     */
    public void bfs(int s, int t) {
    }

    /**
     * ��������㷨�����õݹ�˼�룬ֻҪ�ҵ�һ��·������ֹ
     *
     * @param s
     * @param t
     */
    public void dfs(int s, int t) {
    }

    boolean foundRoute = false;

    private void re_dfs(int s, int t, boolean[] visited, int[] prev) {

    }

    /**
     * ��ӡ��ȡ��·��
     *
     * @param prev
     * @param t
     */
    private void printRoute(int[] prev, int t) {

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
//        myGraph.bfs(0,7); // 0-3-4-6-7
//        myGraph.dfs(0, 7);

        // ��ȡn�Ⱥ���
        myGraph.getThreeByBfs(0, 1);
//        myGraph.getThreeByDfs(0, 2); // ʵ�������⣬����׼ȷ
    }

}
