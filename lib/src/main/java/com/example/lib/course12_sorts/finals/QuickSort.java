package com.example.lib.course12_sorts.finals;

import com.example.lib.course11_sorts.finals.Sorts;

/**
 * ��������ʱ�临�Ӷ�nlogn,ԭ�����򣬷��ȶ���
 * ��ԭ����ѡһ������Ϊ���㽫�����ΪС�ڻ���ʹ��ڵ��ڻ����������䣬���εݹ���ȥ��
 * ���Ӷȷ�����f(n) = f(k)+f(n-k)+n
 * ������kÿ��Ϊ1��ʱ�临�ӶȾ��� O(n^2);
 * ������,kÿ��Ϊn/2�����չ鲢���㣬ʱ�临�ӶȾ��� O(nlog^n);
 * ƽ�������
 * Created by qinshunan on 2019/3/6.
 */
public class QuickSort {

    /**
     * ��������
     *
     * @param arr ����������
     * @param n   �����С
     */
    public void quickSort(int[] arr, int n) {
        if (arr == null || arr.length == 0) {
            System.out.println("arr is empty");
            return;
        }
        quickSortInternally(arr, 0, n - 1);
    }

    /**
     * ���������p~r���䣨����r����������
     *
     * @param arr
     * @param p
     * @param r
     */
    private void quickSortInternally(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }
        int center = getMiddle(arr, p, r);
        quickSortInternally(arr, p, center - 1);
        quickSortInternally(arr, center + 1, r);
    }

    /**
     * ��ȡp~r������ĳ��ֵ�ķֽ��
     *
     * @param arr
     * @param p
     * @param r
     * @return
     */
    private int getMiddle(int[] arr, int p, int r) {
        // ���ֵ���Խ����Ż�����������ȡ��(ͷβ�м�ֵ������ȡ��λ��)���������ȡһ��ֵ������Ϊ�˷���ֱ��ȡ���һλ
        int value = arr[r];
        int center = p; // ���������� value �����꣬���ֽ�����꣬�����С�� value ��ֵ���ұ��Ǵ��� value ��ֵ
        int i = p;
        while (i < r) {
            if (arr[i] >= value) {
                i++;
                continue;
            } else {
                int temp = arr[i];
                arr[i] = arr[center];
                arr[center] = temp;
                center++;
                i++;
            }
        }
        // �� center ��ֵ�����һλ����
        arr[r] = arr[center];
        arr[center] = value;
        return center;
    }

    public static void main(String[] args) {
        QuickSort myQuickSort = new QuickSort();
        int n = 10;
        int[] data1 = Sorts.getRandomArray(n);
        System.out.println("����ǰ");
        printArray(data1);
        System.out.println("��������");
        myQuickSort.quickSort(data1, n);
        printArray(data1);
    }

    public static void printArray(int[] data) {
        for (int a : data) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
