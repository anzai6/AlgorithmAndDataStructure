package com.example.lib.course16_binarysearch2.finals;

import com.example.lib.course11_sorts.finals.Sorts;
import com.example.lib.course13_sort.finals.CountingSort;

/**
 * ���ֲ�����չ�����ң���һ�����ڸ���ֵ�����һ�����ڸ���ֵ����һ�����ڵ��ڸ���ֵ�����һ��С�ڵ��ڸ���ֵ��
 * Created by qinshunan on 2019/3/12.
 */

public class NewBinarySearch {

    /**
     * ���ֲ���(��һ�����ڸ���ֵ)
     *
     * @param arr
     * @param len
     * @param value
     * @return
     */
    public int binarySearchFirstEqual(int[] arr, int len, int value) {
        if (arr == null || len == 0 || arr.length < len) {
            System.out.println("arr is empty");
            return -1;
        }
        int low = 0;
        int high = len - 1;
        int center = 0;
        while (low <= high) {
            center = (low + high) / 2;
            if (arr[center] > value) { // ���ڣ���������
                high = center - 1;
            } else if (arr[center] < value) { // С�ڣ���������
                low = center + 1;
            } else {
                // ��ȵ�����£��жϵ�һλ�ǲ���С��value�������֤�����ǵ�һ������value��
                if (center <= 0 || arr[center - 1] < value) {
                    return center;
                } else { // ���򣬼�������������
                    high = center - 1;
                }
            }
        }
        return -1;
    }

    /**
     * ���ֲ���(���һ�����ڸ���ֵ)
     *
     * @param arr
     * @param len
     * @param value
     * @return
     */
    public int binarySearchLastEqual(int[] arr, int len, int value) {
        if (arr == null || len == 0 || arr.length < len) {
            System.out.println("arr is empty");
            return -1;
        }
        int low = 0;
        int high = len - 1;
        int center = 0;
        while (low <= high) {
            center = (low + high) / 2;
            if (arr[center] > value) { // ���ڣ���������
                high = center - 1;
            } else if (arr[center] < value) { // С�ڣ���������
                low = center + 1;
            } else {
                // ��ȵ�����£��жϸ�һλ�ǲ��Ǵ���value�������֤���������һ������value��
                if (center >= len - 1 || arr[center + 1] > value) {
                    return center;
                } else { // ���򣬼�������������
                    low = center + 1;
                }
            }
        }
        return -1;
    }


    /**
     * ���ֲ���(��һ�����ڵ��ڸ���ֵ)
     *
     * @param arr
     * @param len
     * @param value
     * @return
     */
    public int binarySearchFirstBigEqual(int[] arr, int len, int value) {
        if (arr == null || len == 0 || arr.length < len) {
            System.out.println("arr is empty");
            return -1;
        }
        int low = 0;
        int high = len - 1;
        int center = 0;
        while (low <= high) {
            center = (low + high) / 2;
            if (arr[center] >= value) { // ���ڵ���
                // �жϵ�һλ�ǲ���С��value�������֤�����ǵ�һ�����ڵ���value��
                if (center <= 0 || arr[center - 1] < value) {
                    return center;
                } else { // ���򣬼�������������
                    high = center - 1;
                }
            } else { // С�ڣ���������
                low = center + 1;
            }
        }
        return -1;
    }

    /**
     * ���ֲ���(���һ��С�ڵ��ڸ���ֵ)
     *
     * @param arr
     * @param len
     * @param value
     * @return
     */
    public int binarySearchLastSmallEqual(int[] arr, int len, int value) {
        if (arr == null || len == 0 || arr.length < len) {
            System.out.println("arr is empty");
            return -1;
        }
        int low = 0;
        int high = len - 1;
        int center = 0;
        while (low <= high) {
            center = (low + high) / 2;
            if (arr[center] > value) { // ���ڣ���������
                high = center - 1;
            } else { // С�ڵ���
                // �жϸ�һλ�ǲ��Ǵ���value�������֤���������һ��С�ڵ���value��
                if (center >= len - 1 || arr[center + 1] > value) {
                    return center;
                } else { // ���򣬼�������������
                    low = center + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        CountingSort myCountingSort = new CountingSort();
        int n = 10;
        int value = (int) (Math.random() * n);
        int[] data1 = Sorts.getRandomArray(n);
        System.out.println("����ǰ");
        printArray(data1);
        System.out.println("��������");
        myCountingSort.countingSort(data1, n);
        printArray(data1);

        System.out.println("���ֲ��ҵ�ֵ��value = " + value);
        NewBinarySearch myBinarySearch = new NewBinarySearch();
        int a1 = myBinarySearch.binarySearchFirstEqual(data1, n, value);
        System.out.println("��һ�����ڸ���ֵ��" + a1);
        int a2 = myBinarySearch.binarySearchLastEqual(data1, n, value);
        System.out.println("���һ�����ڸ���ֵ��" + a2);
        int a3 = myBinarySearch.binarySearchFirstBigEqual(data1, n, value);
        System.out.println("��һ�����ڵ��ڸ���ֵ��" + a3);
        int a4 = myBinarySearch.binarySearchLastSmallEqual(data1, n, value);
        System.out.println("���һ��С�ڵ��ڸ���ֵ��" + a4);
    }

    public static void printArray(int[] data) {
        for (int a : data) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
