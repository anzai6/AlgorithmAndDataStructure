package com.example.lib.course12_sorts.finals;

import com.example.lib.course11_sorts.finals.Sorts;

/**
 * �鲢���򣨿ɿ���Ϊ�ȶ�����ʱ�临�Ӷ���nlogn����Ϊ�ϲ�ʱ��Ҫһ��������ȣ����Կռ临�Ӷ���n��
 * Created by qinshunan on 2019/3/5.
 */
public class MergeSort {

    /**
     * �鲢����
     *
     * @param arr ����
     * @param n   �����С
     * @return
     */
    public void mergeSort(int[] arr, int n) {
        if (arr == null || arr.length == 0) {
            System.out.println("arr is empty");
            return;
        }
        mergeSortInternally(arr, 0, n - 1);
    }

    /**
     * �������±��p-r��ֵ������r������������
     *
     * @param arr
     * @param p   ����߽��ֵ
     * @param r   ����߽��ֵ
     * @return
     */
    public void mergeSortInternally(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }
        int center = (p + r) / 2;
        mergeSortInternally(arr, p, center);
        mergeSortInternally(arr, center + 1, r);
        merge(arr, p, center, r);
    }

    /**
     * ��arr[p...m]��A[m+1...r]�ϲ�ΪA[p...r]��p~m��m+1~r����������õ�
     *
     * @param arr
     * @param p
     * @param m
     * @param r
     */
    public void merge(int[] arr, int p, int m, int r) {
        int[] newArr = new int[r - p + 1];
        int i = p;
        int j = m + 1;
        int k = 0;
        // �ϲ�
        while (i <= m && j <= r) {
            if (arr[i] < arr[j]) {
                newArr[k] = arr[i];
                i++;
            } else {
                newArr[k] = arr[j];
                j++;
            }
            k++;
        }

        // �ж��ĸ�����������ʣ�������
        int h = i > m ? j : i;
        while (k < newArr.length) {
            newArr[k] = arr[h];
            k++;
            h++;
        }
        // �ϲ���ɺ�copy
        for (int l = 0; l < newArr.length; l++) {
            arr[p + l] = newArr[l];
        }
    }

    public static void main(String[] args) {
        MergeSort myMergeSort = new MergeSort();
        int n = 10;
        int[] data1 = Sorts.getRandomArray(n);
        System.out.println("����ǰ");
        printArray(data1);
        System.out.println("�鲢����");
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
