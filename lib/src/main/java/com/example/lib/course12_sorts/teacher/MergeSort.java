package com.example.lib.course12_sorts.teacher;

/**
 * Created by wangzheng on 2018/10/16.
 */
public class MergeSort {

    // �鲢�����㷨, a�����飬n��ʾ�����С
    public static void mergeSort(int[] a, int n) {
        mergeSortInternally(a, 0, n - 1);
    }

    // �ݹ���ú���
    private static void mergeSortInternally(int[] a, int p, int r) {
        // �ݹ���ֹ����
        if (p >= r) return;

        // ȡp��r֮����м�λ��q,��ֹ��p+r���ĺͳ���int�������ֵ
        int q = p + (r - p) / 2;
        // ���εݹ�
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q + 1, r);

        // ��A[p...q]��A[q+1...r]�ϲ�ΪA[p...r]
        merge(a, p, q, r);
    }

    private static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0; // ��ʼ������i, j, k
        int[] tmp = new int[r - p + 1]; // ����һ����С��a[p...r]һ������ʱ����
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++]; // i++����i:=i+1
            } else {
                tmp[k++] = a[j++];
            }
        }

        // �ж��ĸ�����������ʣ�������
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        // ��ʣ������ݿ�������ʱ����tmp
        while (start <= end) {
            tmp[k++] = a[start++];
        }

        // ��tmp�е����鿽����a[p...r]
        for (i = 0; i <= r - p; ++i) {
            a[p + i] = tmp[i];
        }
    }

}
