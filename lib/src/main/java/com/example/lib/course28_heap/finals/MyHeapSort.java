package com.example.lib.course28_heap.finals;

import com.example.lib.course11_sorts.my.MySorts;

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
    }

    /**
     * �����齨�ɶ�����
     *
     * @param data
     * @param len  ���ݳ���
     */
    public void buildHeap(int[] data, int len) {
    }


    /**
     * ���ϵ��¶ѻ�:���θ��ӽڵ�ȽϽ���λ�ã�ֱ�����϶ѽṹ
     *
     * @param data  ����
     * @param count �������ݳ���
     * @param index ���ѻ��Ľڵ��±�
     */
    public void fromUpToDownHeapUp(int[] data, int count, int index) {
    }

    /**
     * ���µ��϶ѻ�:���θ����ڵ�ȽϽ���λ�ã�ֱ�����϶ѽṹ
     *
     * @param data  ����
     * @param count �������ݳ���
     * @param index ���ѻ��Ľڵ��±�
     */
    public void fromDownToUpHeapUp(int[] data, int count, int index) {
    }

    /**
     * ��������
     *
     * @param list
     * @param i
     * @param p
     */
    private void swap(int[] list, int i, int p) {
    }

    public static void main(String[] args) {
        MyHeapSort myHeapSort = new MyHeapSort();
        int n = 30;
        int[] data = MySorts.getRandomArray(n);
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
