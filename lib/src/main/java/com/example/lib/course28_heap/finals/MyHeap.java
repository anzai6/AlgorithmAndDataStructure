package com.example.lib.course28_heap.finals;

/**
 * �ѣ���ȫ�������������롢ɾ���������򡢴��ϵ��¶ѻ������µ��϶ѻ����󶥶ѡ�С����
 * ����Ĭ��ʹ�ô󶥶ѣ�����ĳ���ڵ�һ�����ڻ�����������ӽڵ�
 * ���ڵ��1��ʼ����
 * Created by qinshunan on 2019/4/9.
 */

public class MyHeap {

    // ������
    private int[] data; // ������±�1��ʼ�洢����
    // Ĭ������
    private static final int DEFAULT_CAPACITY = 12;
    // ���ݳ���
    int count = 0;
    // ���鳤��
    int n;

    public MyHeap() {
    }

    public MyHeap(int capacity) {
    }

    /**
     * ����һ���ڵ㣺��������β����Ȼ����µ��϶ѻ�
     *
     * @param item ��Ҫ���������
     */
    public void insert(int item) {
    }

    /**
     * ɾ��ĳ���ڵ��˼·�������һ���ڵ㽻��λ�ã�ɾ�����һ���ڵ㣬Ȼ��Ըýڵ���д��ϵ��µĶѻ�
     *
     * @param index ɾ���ڵ���±�
     */
    public void delete(int index) {
    }

    /**
     * ���ϵ��¶ѻ�:���θ��ӽڵ�ȽϽ���λ�ã�ֱ�����϶ѽṹ
     *
     * @param index ���ѻ��Ľڵ��±�
     */
    public void fromUpToDownHeapUp(int index) {
    }

    /**
     * ���µ��϶ѻ�:���θ����ڵ�ȽϽ���λ�ã�ֱ�����϶ѽṹ
     *
     * @param index ���ѻ��Ľڵ��±�
     */
    public void fromDownToUpHeapUp(int index) {
    }

    /**
     * ��������
     *
     * @param list
     * @param i
     * @param p
     */
    private void swap(int[] list, int i, int p) {
        int item = list[p];
        list[p] = list[i];
        list[i] = item;
    }

}
