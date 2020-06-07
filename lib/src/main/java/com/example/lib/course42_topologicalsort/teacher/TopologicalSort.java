package com.example.lib.course42_topologicalsort.teacher;

import java.util.LinkedList;

/**
 * �������򣺴�������������ϵ��Ȼ�������򣬱��磺�ļ�A�����ļ�B���ļ�B�����ļ�C�������ǵı���˳�򣬼���������
 * ������Ҫͨ���ֲ�˳�����Ƶ�ȫ��˳��ģ�һ�㶼���������������
 */
public class TopologicalSort {

    // ������������ݽṹ
    private int v; // ����ĸ���
    private LinkedList<Integer> adj[]; // �ڽӱ�

    public TopologicalSort(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    // ���������ϵ
    public void addEdge(int s, int t) { // s ���� t���� s->t
        adj[s].add(t);
    }

    /**
     * Kahn�㷨ʵ����������
     */
    public void topoSortByKahn() {
        int[] inDegree = new int[v]; // ͳ��ÿ����������,Ҳ������������Ϊ0��֤������û�����������κνڵ�
        for (int i = 0; i < v; ++i) {
            for (int j = 0; j < adj[i].size(); ++j) {
                int w = adj[i].get(j); // i->w
                inDegree[w]++;
            }
        }
        LinkedList<Integer> queue = new LinkedList<>(); // ��ŵ�ǰ�������κνڵ�Ľڵ㣬�����Ϊ0�Ľڵ�
        for (int i = 0; i < v; ++i) {
            if (inDegree[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int i = queue.remove();
            System.out.print("->" + i);
            for (int j = 0; j < adj[i].size(); ++j) {
                int k = adj[i].get(j);
                inDegree[k]--;
                if (inDegree[k] == 0) queue.add(k);
            }
        }
    }


    /**
     * ������ȱ��� -> DFS�㷨ʵ����������
     */
    public void topoSortByDFS() {
        // �ȹ������ڽӱ��� s->t ��ʾ��s ������ t��t ���� s
        LinkedList<Integer> inverseAdj[] = new LinkedList[v];
        for (int i = 0; i < v; ++i) { // ����ռ�
            inverseAdj[i] = new LinkedList<>();
        }
        for (int i = 0; i < v; ++i) { // ͨ���ڽӱ��������ڽӱ�
            for (int j = 0; j < adj[i].size(); ++j) {
                int w = adj[i].get(j); // i->w
                inverseAdj[w].add(i); // w->i
            }
        }
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; ++i) { // ������ȱ���ͼ
            if (visited[i] == false) {
                visited[i] = true;
                dfs(i, inverseAdj, visited);
            }
        }
    }

    private void dfs(int vertex, LinkedList<Integer> inverseAdj[], boolean[] visited) {
        for (int i = 0; i < inverseAdj[vertex].size(); ++i) {
            int w = inverseAdj[vertex].get(i);
            if (visited[w] == true) continue;
            visited[w] = true;
            dfs(w, inverseAdj, visited);
        } // �Ȱ� vertex �������ɴ�����ж��㶼��ӡ����֮���ٴ�ӡ���Լ�
        System.out.print("->" + vertex);
    }


}
