package com.example.lib.course12_sorts.my;

import com.example.lib.course11_sorts.my.MySorts;

/**
 * 归并排序（可控制为稳定排序，时间复杂度是nlogn，因为合并时需要一个数组过度，所以空间复杂度是n）
 * Created by qinshunan on 2019/3/5.
 */
public class MyMergeSort {
    // f(n) = f(0,n/2) + f(n/2,n)+ merge();

    /**
     * 归并排序
     *
     * @param arr 数组
     * @param n   数组大小
     * @return
     */
    public void mergeSort(int[] arr, int n) {
        if (n < 2)
            return;
        mergeSortInternally(arr, 0, n - 1);
    }

    /**
     * 对数组下标从p-r的值（包括r本身）进行排序
     *
     * @param arr
     * @param p   区间边界低值
     * @param r   区间边界高值
     * @return
     */
    public void mergeSortInternally(int[] arr, int p, int r) {
        if (p >= r)
            return;
        int m = (r + p) / 2;
        mergeSortInternally(arr, p, m);
        mergeSortInternally(arr, m + 1, r);

        merge(arr, p, m, r);
    }

    /**
     * 将arr[p...m]和A[m+1...r]合并为A[p...r]，p~m和m+1~r都是已排序好的
     *
     * @param arr
     * @param p
     * @param m
     * @param r
     */
    public void merge(int[] arr, int p, int m, int r) {
        int n = r - p + 1; // p~r区间的长度
        int[] a = new int[n];
        int len1 = p; // p~m区间的下标
        int len2 = m + 1; // m+1~r区间的下标
        int i = 0; // 新数组a的下标

        // 合并
        while (len1 <= m && len2 <= r) {
            if (arr[len1] <= arr[len2]) { // 这里等于就加入是为了保证稳定性
                a[i++] = arr[len1++];
            } else {
                a[i++] = arr[len2++];
            }
        }

        // 将剩下的合并
        if (len1 > m) { // p~m区间的数组已经遍历完了,将len1下标移动到m+1~r区间的下标
            len1 = len2;
        }
        while (i != n) {
            a[i++] = arr[len1++];
        }

        for (int j = 0; j < n; j++) {
            arr[p + j] = a[j];
        }
    }

    public static void main(String[] args) {
        MyMergeSort myMergeSort = new MyMergeSort();
        int n = 10;
        int[] data1 = MySorts.getRandomArray(n);
        System.out.println("排序前");
        printArray(data1);
        System.out.println("归并排序：");
        myMergeSort.mergeSort(data1, n);
        printArray(data1);
    }

    public static void printArray(int[] data) {
        for (int a : data) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
