package com.example.lib.course12_sorts.finals;

import com.example.lib.course11_sorts.my.MySorts;

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
    }

    public static void main(String[] args) {
        MergeSort myMergeSort = new MergeSort();
        int n = 10;
        int[] data1 = MySorts.getRandomArray(n);
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
