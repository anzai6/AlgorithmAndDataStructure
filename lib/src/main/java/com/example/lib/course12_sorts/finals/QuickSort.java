package com.example.lib.course12_sorts.finals;

import com.example.lib.course11_sorts.finals.Sorts;

/**
 * ��������ʱ�临�Ӷ�nlogn,ԭ�����򣬷��ȶ���
 * ��ԭ����ѡһ������Ϊ���㽫�����ΪС�ڻ���ʹ��ڵ��ڻ����������䣬���εݹ���ȥ��
 * Created by qinshunan on 2019/3/6.
 */

public class QuickSort {

    /**
     * ��������
     *
     * @param arr ����������
     * @param n   �����С
     */
    public void quickSor(int[] arr, int n) {
    }

    /**
     * ���������p~r���䣨����r����������
     *
     * @param arr
     * @param p
     * @param r
     */
    private void mergeSortInternally(int[] arr, int p, int r) {
    }

    /**
     * ��ȡp~r������ĳ��ֵ�ķֽ��
     *
     * @param arr
     * @param p
     * @param r
     * @return
     */
    private int getMiddle(int[] arr, int p, int r) {
        return 0;
    }

    public static void main(String[] args) {
        QuickSort myQuickSort = new QuickSort();
        int n = 10;
        int[] data1 = Sorts.getRandomArray(n);
        System.out.println("����ǰ");
        printArray(data1);
        System.out.println("��������");
        myQuickSort.quickSor(data1, n);
        printArray(data1);
    }

    public static void printArray(int[] data) {
        for (int a : data) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
