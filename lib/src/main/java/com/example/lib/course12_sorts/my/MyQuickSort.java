package com.example.lib.course12_sorts.my;

import com.example.lib.course11_sorts.finals.Sorts;

/**
 * ��������ʱ�临�Ӷ�nlogn,ԭ�����򣬷��ȶ���
 * ��ԭ����ѡһ������Ϊ���㽫�����ΪС�ڻ���ʹ��ڵ��ڻ����������䣬���εݹ���ȥ��
 * Created by qinshunan on 2019/3/6.
 */

public class MyQuickSort {

    /**
     * ��������
     *
     * @param arr ����������
     * @param n   �����С
     */
    public void quickSor(int[] arr, int n) {
        mergeSortInternally(arr, 0, n - 1);
    }

    /**
     * ���������p~r���䣨����r����������
     *
     * @param arr
     * @param p
     * @param r
     */
    private void mergeSortInternally(int[] arr, int p, int r) {
        if (p >= r) return;
        int m = getMiddle(arr, p, r);
        mergeSortInternally(arr, p, m-1);
        mergeSortInternally(arr, m + 1, r);
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
        int basicItem = arr[r]; // �ȽϵĻ�׼��
        int m = p; // m���ǽ�Ҫ���صķֽ�㣬С��m��������m������С�ڻ�׼������䣬����m���Ǵ��ڵ��ڻ�׼�������

        for (int i = p; i < r; i++) { // ��Ϊarr[r]ѡΪ��׼�����ñ���
            if (arr[i] < basicItem) { // С�ڷŵ�m���ڵ�����
                if (i == m) { // ���ǻ�û�д��ڵ��ڻ�׼�����ֳ���
                    m++;
                } else { // �Ѿ��д��ڵ��ڻ�׼�����ֳ���,����i��m��ͬ���ˣ�i��ǰ��
                    int index = arr[i];
                    arr[i] = arr[m];
                    arr[m] = index;
                    m++;
                }
            }
        }


        arr[r] = arr[m];
        arr[m] = basicItem;
        return m;
    }

    public static void main(String[] args) {
        MyQuickSort myQuickSort = new MyQuickSort();
        int n = 10;
        int[] data1 = Sorts.getRandomArray(n);
        System.out.println("����ǰ");
        printArray(data1);
        System.out.println("��������");
        myQuickSort.quickSor(data1, n);
        printArray(data1);
    }

    public static void printArray(int[] data) {
        for (int a : data) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
