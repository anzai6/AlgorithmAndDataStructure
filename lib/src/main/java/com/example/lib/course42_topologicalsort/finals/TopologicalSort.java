package com.example.lib.course42_topologicalsort.finals;

import java.util.LinkedList;

/**
 * �������򣺴�������������ϵ��Ȼ�������򣬱��磺�ļ�A�����ļ�B���ļ�B�����ļ�C�������ǵı���˳�򣬼���������
 * ������Ҫͨ���ֲ�˳�����Ƶ�ȫ��˳��ģ�һ�㶼���������������
 * Created by qinshunan on 2019/5/16.
 */

public class TopologicalSort {

    // ������������ݽṹ
    private int v; // �������
    private LinkedList<Integer>[] adj; // �ڽӾر���Žڵ�ͼ��ϵ

    public TopologicalSort(int v) {
    }

    /**
     * ��Ӷ���������ϵ
     *
     * @param s
     * @param t
     */
    public void addRely(int s, int t) { // s����t,��tָ��s : t -> s
    }

    /**
     * Kahn�㷨ʵ����������
     */
    public void sortByKahn() {
    }

    /**
     * ������ȱ��� -> DFS�㷨ʵ����������
     */
    public void sortByDFS() {
    }

    /**
     * �����ڵ�i�����������ڵ㣬��һ��һ�㴫����ȥ��ֱ��ĳ���ڵ�û�������κνڵ㣬�ʹ�ӡ������Ȼ���ӡ�������Ľڵ�
     *
     * @param i
     * @param reverseAdj
     * @param dfsValue
     */
    private void DFS(int i, LinkedList<Integer>[] reverseAdj, boolean[] dfsValue) {
    }

}
