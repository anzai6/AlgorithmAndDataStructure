package com.example.lib.course16_binarysearch2.my;

import com.example.lib.course11_sorts.finals.Sorts;
import com.example.lib.course13_sort.finals.CountingSort;

/**
 * ���ֲ�����չ�����ң���һ�����ڸ���ֵ�����һ�����ڸ���ֵ����һ�����ڵ��ڸ���ֵ�����һ��С�ڵ��ڸ���ֵ��
 * Created by qinshunan on 2019/3/12.
 */

public class MyNewBinarySearch {

    /**
     * ���ֲ���(��һ�����ڸ���ֵ)
     *
     * @param arr
     * @param len
     * @param value
     * @return
     */
    public int binarySearchFirstEqual(int[] arr, int len, int value) {
        if (len <= 0)
            return -1;
        int low = 0;
        int high = len - 1;

        while (low <= high) { // ע�ⲻ��low < high
            int mid = low + (high - low) / 2; // ���д��(low+high)/2��low+high�п��ܷǳ�������������
            // ��һ�����ڸ���ֵ������Сһλ�����ڻ���С�ڸ���ֵvalue
            if (arr[mid] == value &&
                    ((mid - 1) < 0 || arr[mid - 1] < value)) {
                return mid;
            } else if (arr[mid] < value) {
                low = mid + 1; // �ǵ���һλ
            } else if (arr[mid] >= value) {
                high = mid - 1; // �ǵý�һλ
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
        if (len <= 0)
            return -1;
        int low = 0;
        int high = len - 1;

        while (low <= high) { // ע�ⲻ��low < high
            int mid = low + (high - low) / 2; // ���д��(low+high)/2��low+high�п��ܷǳ�������������
            // ���һ�����ڸ���ֵ�����Ĵ�һλ�����ڻ��ߴ��ڸ���ֵvalue
            if (arr[mid] == value &&
                    ((mid + 1) > len-1 || arr[mid + 1] > value)) {
                return mid;
            } else if (arr[mid] <= value) {
                low = mid + 1; // �ǵ���һλ
            } else if (arr[mid] > value) {
                high = mid - 1; // �ǵý�һλ
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
        if (len <= 0)
            return -1;
        int low = 0;
        int high = len - 1;

        while (low <= high) { // ע�ⲻ��low < high
            int mid = low + (high - low) / 2; // ���д��(low+high)/2��low+high�п��ܷǳ�������������
            // ��һ�����ڵ��ڸ���ֵ������Сһλ�����ڻ���С�ڸ���ֵvalue
            if (arr[mid] >= value &&
                    ((mid - 1) < 0 || arr[mid - 1] < value)) {
                return mid;
            } else if (arr[mid] < value) {
                low = mid + 1; // �ǵ���һλ
            } else if (arr[mid] >= value) {
                high = mid - 1; // �ǵý�һλ
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
        if (len <= 0)
            return -1;
        int low = 0;
        int high = len - 1;

        while (low <= high) { // ע�ⲻ��low < high
            int mid = low + (high - low) / 2; // ���д��(low+high)/2��low+high�п��ܷǳ�������������
            // ���һ��С�ڵ��ڸ���ֵ�����Ĵ�һλ�����ڻ��ߴ��ڵ��ڸ���ֵvalue
            if (arr[mid] <= value &&
                    ((mid + 1) > len-1 || arr[mid + 1] > value)) {
                return mid;
            } else if (arr[mid] <= value) {
                low = mid + 1; // �ǵ���һλ
            } else if (arr[mid] > value) {
                high = mid - 1; // �ǵý�һλ
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        CountingSort myCountingSort = new CountingSort();
        int n = 10;
        int[] data1 = Sorts.getRandomArray(n);
        System.out.println("����ǰ");
        printArray(data1);
        System.out.println("��������");
        myCountingSort.countingSort(data1, n);
        printArray(data1);

        int value = 5;
        MyNewBinarySearch myBinarySearch = new MyNewBinarySearch();
        int a1 = myBinarySearch.binarySearchFirstEqual(data1, n, value);
        System.out.println("���ֲ���(��һ�����ڸ���ֵ)��" + a1);
        int a2 = myBinarySearch.binarySearchLastEqual(data1, n, value);
        System.out.println("���ֲ���(���һ�����ڸ���ֵ)��" + a2);
        int a3 = myBinarySearch.binarySearchFirstBigEqual(data1, n, value);
        System.out.println("���ֲ���(��һ�����ڵ��ڸ���ֵ)��" + a3);
        int a4 = myBinarySearch.binarySearchLastSmallEqual(data1, n, value);
        System.out.println("���ֲ���(���һ��С�ڵ��ڸ���ֵ)��" + a4);
    }

    public static void printArray(int[] data) {
        for (int a : data) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
