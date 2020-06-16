package com.example.lib.course15_binarysearch.my;

import com.example.lib.course11_sorts.finals.Sorts;
import com.example.lib.course13_sort.my.MyCountingSort;

/**
 * ���ֲ���
 * Created by qinshunan on 2019/3/12.
 */

public class MyBinarySearch {

    /**
     * ���ֲ���(Ҫ���������򣬲��ظ�)
     *
     * @param arr
     * @param len
     * @param value
     * @return
     */
    public int binarySearch(int[] arr, int len, int value) {
        if (len <= 0)
            return -1;
        int low = 0;
        int high = len - 1;

        while (low <= high) { // ע�ⲻ��low < high
            int mid = low + (high - low) / 2; // ���д��(low+high)/2��low+high�п��ܷǳ�������������
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] < value) {
                low = mid + 1; // �ǵ���һλ
            } else if (arr[mid] > value) {
                high = mid - 1; // �ǵý�һλ
            }
        }

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
        if (len <= 0)
            return -1;
        return subRecursionBinarySearch(arr, 0, len - 1, value);
    }

    public int subRecursionBinarySearch(int[] arr, int low, int high, int value) {
        if (low == high) {
            if (arr[low] == value) {
                return low;
            } else {
                return -1;
            }
        } else if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2; // ���д��(low+high)/2��low+high�п��ܷǳ�������������
        int a1 = subRecursionBinarySearch(arr, low, mid, value);
        int a2 = subRecursionBinarySearch(arr, mid + 1, high, value);

        return a1 != -1 ? a1 : a2;
    }

    public static void main(String[] args) {
        MyCountingSort myCountingSort = new MyCountingSort();
        int n = 4;
        int[] data1 = Sorts.getRandomArray(n);
        System.out.println("����ǰ");
        printArray(data1);
        System.out.println("��������");
        myCountingSort.countingSort(data1, n);
        printArray(data1);

        MyBinarySearch myBinarySearch = new MyBinarySearch();
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
