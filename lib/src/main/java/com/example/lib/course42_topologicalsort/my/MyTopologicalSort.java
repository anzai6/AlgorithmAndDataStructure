package com.example.lib.course42_topologicalsort.my;

import java.util.LinkedList;

/**
 * �������򣺴�������������ϵ��Ȼ�������򣬱��磺�ļ�A�����ļ�B���ļ�B�����ļ�C�������ǵı���˳�򣬼���������
 * ������Ҫͨ���ֲ�˳�����Ƶ�ȫ��˳��ģ�һ�㶼���������������
 * Created by qinshunan on 2019/5/16.
 */

public class MyTopologicalSort {

    // ������������ݽṹ
    private int v; // �������
    private LinkedList<Integer>[] adj; // �ڽӾر���Žڵ�ͼ��ϵ

    public MyTopologicalSort(int v) {
        this.v = v;
        // ��ʼ��
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * ��Ӷ���������ϵ
     *
     * @param s
     * @param t
     */
    public void addRely(int s, int t) { // s����t,��tָ��s : t -> s
        adj[t].add(s);
    }

    /**
     * Kahn�㷨ʵ����������
     */
    public void sortByKahn() {
        int[] degressList = new int[v]; // ͳ��ÿ����������,Ҳ������������Ϊ0��֤������û�����������κνڵ�,��������Ϊ��Ҫ����ڵ�

        // ������нڵ�����
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                int w = adj[i].get(j); // w����i,i -> w
                degressList[w]++; // ������������ȼ�һ
            }
        }

        LinkedList<Integer> zeroV = new LinkedList<>(); // ��ŵ�ǰ�������κνڵ�Ľڵ㣬�����Ϊ0�Ľڵ�
        for (int i = 0; i < v; i++) {
            if (degressList[i] == 0)
                zeroV.add(i);
        }

        while (!zeroV.isEmpty()) {
            int a = zeroV.remove(); // ȡ��һ���ڵ㣬���Ӷ�����ɾ��
            System.out.print(a + " -> "); // ��ӡ�������൱��ѡ�У�������ǰ��

            // Ȼ�����������ڽڵ�a�Ľڵ���ȼ�һ
            for (int i = 0; i < adj[a].size(); i++) {
                int w = adj[a].get(i);
                degressList[w]--;
                if (degressList[w] == 0) // ����0�ͼ������
                    zeroV.add(w);
            }
        }
    }

    /**
     * ������ȱ��� -> DFS�㷨ʵ����������
     */
    public void sortByDFS() {
        LinkedList<Integer>[] reverseAdj = new LinkedList[v]; // ���ڽӱ�,���ڽӱ��Ӧ��ϵ�պ��෴
        for (int i = 0; i < v; i++) {
            reverseAdj[i] = new LinkedList<>();
        }
        // ���ڽӱ�ֵ
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                // w����i
                int w = adj[i].get(j); // i -> w
                adj[w].add(i); // w -> i
            }
        }

        boolean[] dfsValue = new boolean[v]; // ��¼�Լ���������ֵ,��һ���ܹؼ�����ֹ�ظ�����

        for (int i = 0; i < v; i++) {
            if (!dfsValue[i]) {
                dfsValue[i] = true;
                DFS(i, reverseAdj, dfsValue);
            }
        }
    }

    /**
     * �����ڵ�i�����������ڵ㣬��һ��һ�㴫����ȥ��ֱ��ĳ���ڵ�û�������κνڵ㣬�ʹ�ӡ������Ȼ���ӡ�������Ľڵ�
     *
     * @param i
     * @param reverseAdj
     * @param dfsValue
     */
    private void DFS(int i, LinkedList<Integer>[] reverseAdj, boolean[] dfsValue) {
        for (int j = 0; j < reverseAdj[i].size(); j++) {
            int w = reverseAdj[i].get(j);
            if (!dfsValue[w]) {
                dfsValue[w] = true;
                DFS(w, reverseAdj, dfsValue);
            }
        }
        // �Ȱ� i �������ɴ�����ж��㶼��ӡ����֮���ٴ�ӡ���Լ�
        System.out.print(i + " -> ");
    }

}
