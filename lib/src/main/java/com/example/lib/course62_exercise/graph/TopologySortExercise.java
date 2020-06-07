package com.example.lib.course62_exercise.graph;

import java.util.LinkedList;

/**
 * �������򣺴�������������ϵ��Ȼ�������򣬱��磺�ļ�A�����ļ�B���ļ�B�����ļ�C�������ǵı���˳�򣬼���������
 * ������Ҫͨ���ֲ�˳�����Ƶ�ȫ��˳��ģ�һ�㶼���������������
 */

public class TopologySortExercise {

    private int v;
    private LinkedList<Integer>[] adj; // �ڽӱ��洢ͼ�ṹ,LinkedList�洢����ĳ����������ж���

    public TopologySortExercise(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * s ���� t
     *
     * @param s
     * @param t
     */
    public void addEdge(int s, int t) {
        adj[t].add(s);
    }

    /**
     * Kahn��������
     */
    public void topoSortByKahn() {
        int[] degree = new int[v]; // ͳ��ÿ����������,Ҳ������������Ϊ0��֤������û�����������κνڵ�
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                int w = adj[i].get(j); // w ���� i
                degree[w]++;
            }
        }
        LinkedList<Integer> list = new LinkedList<>(); // �洢���Ϊ0�Ķ��㣬��û�������κζ���
        for (int i = 0; i < v; i++) {
            if (degree[i] == 0)
                list.add(i);
        }
        while (!list.isEmpty()) {
            int w = list.poll(); // ����
            System.out.print("->" + w);
            for (int i = 0; i < adj[w].size(); i++) {
                int p = adj[w].get(i); // p ���� w
                degree[p]--;
                if (degree[p] == 0)
                    list.add(p);
            }
        }
    }

    /**
     * ������ȱ��� -> DFS�㷨ʵ����������
     */
    public void topoSortByDsf() {
        LinkedList<Integer>[] adjN = new LinkedList[v]; // ���ڽӱ�����洢�������������ж���
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                int w = adj[i].get(j); // w ���� i
                adjN[w].add(i);
            }
        }
        boolean[] visited = new boolean[v]; // ���ʹ��Ķ���
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dsfIn(i, adjN, visited);
            }
        }
    }

    /**
     * ������ȱ��� -> DFS�㷨ʵ����������
     */
    public void dsfIn(int vertex, LinkedList<Integer>[] adjN, boolean[] visited) {
        // �ȼ��ض���vertex���������ж��㣬�ټ�������
        for (int i = 0; i < adjN[vertex].size(); i++) {
            int w = adj[vertex].get(i);
            if (!visited[w]) {
                visited[i] = true;
                dsfIn(w, adjN, visited);
            }
        }
        System.out.print("->" + vertex);
    }
}
