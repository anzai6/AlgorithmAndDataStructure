package com.example.lib.course12_sorts.my;

import com.example.lib.course11_sorts.my.MySorts;

/**
 * �鲢���򣨿ɿ���Ϊ�ȶ�����ʱ�临�Ӷ���nlogn����Ϊ�ϲ�ʱ��Ҫһ��������ȣ����Կռ临�Ӷ���n��
 * Created by qinshunan on 2019/3/5.
 */
public class MyMergeSort {
    // f(n) = f(0,n/2) + f(n/2,n)+ merge();

    /**
     * �鲢����
     *
     * @param arr ����
     * @param n   �����С
     * @return
     */
    public void mergeSort(int[] arr, int n) {
        if (n < 2)
            return;
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
        if (p >= r)
            return;
        int m = (r + p) / 2;
        mergeSortInternally(arr, p, m);
        mergeSortInternally(arr, m + 1, r);

        merge(arr, p, m, r);
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
        int n = r - p + 1; // p~r����ĳ���
        int[] a = new int[n];
        int len1 = p; // p~m������±�
        int len2 = m + 1; // m+1~r������±�
        int i = 0; // ������a���±�

        // �ϲ�
        while (len1 <= m && len2 <= r) {
            if (arr[len1] <= arr[len2]) { // ������ھͼ�����Ϊ�˱�֤�ȶ���
                a[i++] = arr[len1++];
            } else {
                a[i++] = arr[len2++];
            }
        }

        // ��ʣ�µĺϲ�
        if (len1 > m) { // p~m����������Ѿ���������,��len1�±��ƶ���m+1~r������±�
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
