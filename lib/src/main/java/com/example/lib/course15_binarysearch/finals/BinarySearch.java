package com.example.lib.course15_binarysearch.finals;

import com.example.lib.course11_sorts.my.MySorts;
import com.example.lib.course13_sort.my.MyCountingSort;

/**
 * ���ֲ���
 * Created by qinshunan on 2019/3/12.
 */

public class BinarySearch {

    /**
     * ���ֲ���(Ҫ���������򣬲��ظ�)
     *
     * @param arr
     * @param len
     * @param value
     * @return
     */
    public int binarySearch(int[] arr, int len, int value) {

        return -1;
    }

    /**
     * �ݹ���ֲ���
     *
     * @param arr
     * @param len
     * @param value
     * @return
     */
    public int recursionBinarySearch(int[] arr, int len, int value) {
        return 0;
    }

    public int subRecursionBinarySearch(int[] arr, int low, int high, int value) {

        return 1;
    }

    public static void main(String[] args) {
        MyCountingSort myCountingSort = new MyCountingSort();
        int n = 4;
        int[] data1 = MySorts.getRandomArray(n);
        System.out.println("����ǰ");
        printArray(data1);
        System.out.println("��������");
        myCountingSort.countingSort(data1, n);
        printArray(data1);

        BinarySearch myBinarySearch = new BinarySearch();
        int a1 = myBinarySearch.binarySearch(data1, n, 1);
        int a2 = myBinarySearch.recursionBinarySearch(data1, n, 1);
        System.out.println("���ֲ��ң�" + a1 + " : " + a2);
    }

    public static void printArray(int[] data) {
        for (int a : data) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
