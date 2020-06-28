package com.example.lib.course28_heap.finals;

import com.example.lib.course11_sorts.finals.Sorts;

/**
 * �������Ȱ����齨�ɶ����飬Ȼ��������
 * ������ڵ��1��ʼ����
 * Created by qinshunan on 2019/4/9.
 */

public class MyHeapSort {

    /**
     * �������Ȱ����齨�ɶ����飬Ȼ��������
     *
     * @param data
     * @param len  ���ݳ���
     */
    public void heapSort(int[] data, int len) {
        if (data == null || len <= 1 || data.length < len) {
            return;
        }
        // ����
        buildHeap(data, len);
        // ����ÿ��ȡ���ֵ�����һ������
        for (int i = len; i > 1; i--) {
            swap(data, i, 1);
            fromUpToDownHeapUp(data, i - 1, 1);
        }
    }

    /**
     * �����齨�ɶ����飬�����һ��Ҷ�ӽ��ĸ��ڵ㿪ʼ�����϶��¶ѻ�����
     *
     * @param data
     * @param len  ���ݳ���
     */
    public void buildHeap(int[] data, int len) {
        for (int i = len / 2; i >= 1; i--) {
            fromUpToDownHeapUp(data, len, i);
        }
    }


    /**
     * ���ϵ��¶ѻ�:���θ��ӽڵ�ȽϽ���λ�ã�ֱ�����϶ѽṹ
     *
     * @param data  ����
     * @param count �������ݳ���
     * @param index ���ѻ��Ľڵ��±�
     */
    public void fromUpToDownHeapUp(int[] data, int count, int index) {
        if (index < 1) {
            return;
        }
        // ���ӽڵ������²�ѭ��
        while (index * 2 <= count) {
            int leftSub = index * 2; // ���ӽڵ�
            int rightSub = index * 2 + 1; // ���ӽڵ�
            int maxSub = leftSub; // ���ֵ���ӽڵ�����
            // �����ӽڵ��ұ����ӽڵ��
            if (rightSub <= count && data[rightSub] > data[leftSub]) {
                maxSub = rightSub;
            }
            // ����ӽڵ������������Ҫ���¶ѻ�
            if (data[maxSub] > data[index]) {
                swap(data, maxSub, index);
                index = maxSub;
            } else { // �ѻ�����
                return;
            }
        }
    }

    /**
     * ���µ��϶ѻ�:���θ����ڵ�ȽϽ���λ�ã�ֱ�����϶ѽṹ
     *
     * @param data  ����
     * @param count �������ݳ���
     * @param index ���ѻ��Ľڵ��±�
     */
    public void fromDownToUpHeapUp(int[] data, int count, int index) {
        if (index > count || index <= 1) {
            return;
        }
        int parentIndex = index / 2;
        // ���ڵ������������Ҫ���϶ѻ�
        while (parentIndex >= 1 && data[parentIndex] < data[index]) {
            swap(data, parentIndex, index);
            index = parentIndex;
            parentIndex = index / 2;
        }
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

    public static void main(String[] args) {
        MyHeapSort myHeapSort = new MyHeapSort();
        int n = 10;
        int[] data = Sorts.getRandomArray(n);
        System.out.println("����ǰ");
        printArray(data);
        System.out.println("������");
        myHeapSort.heapSort(data, n - 1);
        printArray(data);
    }

    public static void printArray(int[] data) {
        for (int a : data) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

}
