package com.example.lib.course12_sorts.finals;

import com.example.lib.course11_sorts.my.MySorts;

/**
 * 归并排序（可控制为稳定排序，时间复杂度是nlogn，因为合并时需要一个数组过度，所以空间复杂度是n）
 * Created by qinshunan on 2019/3/5.
 */
public class MergeSort {

    /**
     * 归并排序
     *
     * @param arr 数组
     * @param n   数组大小
     * @return
     */
    public void mergeSort(int[] arr, int n) {
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
    }

    public static void main(String[] args) {
        MergeSort myMergeSort = new MergeSort();
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
