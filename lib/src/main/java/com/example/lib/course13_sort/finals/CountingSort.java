package com.example.lib.course13_sort.finals;

import com.example.lib.course11_sorts.my.MySorts;

/**
 * ��������Ҫ������Ķ��������д洢�Ķ��ǷǸ����������ҷ�Χ���󣬿������ȶ��Եģ���Ҫ�ռ�n����ԭ������,ʱ�临�ӵ��ǣ�7n+c
 * Created by qinshunan on 2019/3/11.
 */
public class CountingSort {


    /**
     * ��������
     *
     * @param arr
     * @param len
     */
    public void countingSort(int[] arr, int len) {

    }

    public static void main(String[] args) {
        CountingSort myCountingSort = new CountingSort();
        int n = 1000;
        int[] data1 = MySorts.getRandomArray(n);
        System.out.println("����ǰ");
        printArray(data1);
        System.out.println("��������");
        myCountingSort.countingSort(data1, n);
        printArray(data1);
    }

    public static void printArray(int[] data) {
        for (int a : data) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

}
