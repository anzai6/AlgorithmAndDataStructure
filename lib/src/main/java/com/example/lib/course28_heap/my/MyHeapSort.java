package com.example.lib.course28_heap.my;

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
        buildHeap(data, len);
        // �Ѹ��ڵ㼴����������һλ����len������Ȼ����0~len-1��Χ�Ը��ڵ���д��ϵ��µĶѻ�
        // ������ȥ���ɳɶ�����
        for (int i = len; i > 1; --i) {
            swap(data, i, 1); // ����
            fromUpToDownHeapUp(data, i - 1, 1);
        }
    }

    /**
     * �����齨�ɶ�����
     *
     * @param data
     * @param len  ���ݳ���
     */
    public void buildHeap(int[] data, int len) {
        // len/2 �����һ����Ҷ�ӽڵ�Ľڵ㣬���Զ�len/2��1�±�����ݽ��д��ϵ��µĶѻ�
        for (int i = len / 2; i >= 1; --i) {
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
        // count/2֮��Ľڵ㶼��Ҷ�ӽڵ㣨���һ���ڵ���count�����ĸ��ڵ���count/2,���ԣ�
        while (index >= 1) {
            int leftChild = index * 2;
            int rightChild = index * 2 + 1;
            int maxP = index;// �����ڵ���������һ��
            // �ر�ע�⣬�����leftChild��rightChild����Խ����count������Ҫ��һ���ж�
            if (leftChild <= count && data[maxP] < data[leftChild])
                maxP = leftChild;
            if (rightChild <= count && data[maxP] < data[rightChild])
                maxP = rightChild;

            // ���ֵ����������Ҫ�ѻ���
            if (maxP == index) {
                return;
            } else {
                swap(data, maxP, index);
                index = maxP;
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
        if (index <= 1) return; // 1�Ǹ��ڵ�
        // ���ڵ��±�
        int p = index / 2;
        while (index > 1 && data[index] > data[p]) {
            // �����򽻻����ӽڵ�
            swap(data, index, p);

            index = p;
            p = index / 2;
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
        int n = 30;
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
