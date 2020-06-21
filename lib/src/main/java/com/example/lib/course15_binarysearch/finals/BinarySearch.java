package com.example.lib.course15_binarysearch.finals;

import com.example.lib.course13_sort.finals.CountingSort;

import java.util.HashMap;

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
        if (arr == null || arr.length == 0) {
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
                return center;
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
        if (arr == null || arr.length == 0) {
            System.out.println("arr is empty");
            return -1;
        }
        return subRecursionBinarySearch(arr, 0, len - 1, value);
    }

    public int subRecursionBinarySearch(int[] arr, int low, int high, int value) {
        if (low > high) {
            return -1;
        }
        int center = (low + high) / 2;
        if (arr[center] > value) { // ���ڣ���������
            return subRecursionBinarySearch(arr, low, center - 1, value);
        } else if (arr[center] < value) { // С�ڣ���������
            return subRecursionBinarySearch(arr, center + 1, high, value);
        } else {
            return center;
        }
    }

    public static void main(String[] args) {
        CountingSort myCountingSort = new CountingSort();
        int n = 10;
        int maxValue = 2 * n;
        int value = (int) (Math.random() * maxValue);
        int[] data1 = getRandomArrayNoSame(n, maxValue);
        System.out.println("����ǰ");
        printArray(data1);
        System.out.println("��������");
        myCountingSort.countingSort(data1, n);
        printArray(data1);

        BinarySearch myBinarySearch = new BinarySearch();
        int a1 = myBinarySearch.binarySearch(data1, n, value);
        int a2 = myBinarySearch.recursionBinarySearch(data1, n, value);
        System.out.println("���ֲ��ң�value = " + value + ", λ�ã�" + a1 + " : " + a2);
    }

    public static void printArray(int[] data) {
        for (int a : data) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    /**
     * ��ȡһ���������,Ԫ�ز�ͬ
     *
     * @param n ����
     * @return
     */
    public static int[] getRandomArrayNoSame(int n, int maxValue) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            int newValue = (int) (Math.random() * maxValue);
            while (hashMap.containsKey(newValue)) {
                newValue = (int) (Math.random() * maxValue);
            }
            hashMap.put(Integer.valueOf(newValue), Integer.valueOf(newValue));
            data[i] = newValue;
        }
        return data;
    }
}
