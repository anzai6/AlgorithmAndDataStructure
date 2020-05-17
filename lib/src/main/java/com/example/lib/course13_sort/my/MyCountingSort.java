package com.example.lib.course13_sort.my;

import com.example.lib.course11_sorts.my.MySorts;

/**
 * ��������Ҫ������Ķ��������д洢�Ķ��ǷǸ����������ҷ�Χ���󣬿������ȶ��Եģ���Ҫ�ռ�n����ԭ������,ʱ�临�ӵ��ǣ�7n+c
 * Created by qinshunan on 2019/3/11.
 */
public class MyCountingSort {


    /**
     * ��������
     *
     * @param arr
     * @param len
     */
    public void countingSort(int[] arr, int len) {

        if (len <= 1)
            return;

        int maxItem = 0;

        // �ҳ����ֵ
        for (int i = 0; i < len; i++) {
            if (maxItem < arr[i])
                maxItem = arr[i];
        }

        // ����һ����������newCountArr���±��С[0,maxItem],
        int[] newCountArr = new int[maxItem + 1];

        // ����ÿ��Ԫ�صĸ���������newCountArr�У�arr�����ֵ��ӦnewCountArr���±ꣻ����arr��ĳ��ֵ2,��newCountArr[2]��ֵ��Ӧ����arr[]=2�ĸ���
        for (int i = 0; i < len; i++) {
            newCountArr[arr[i]]++;
        }

        // �����ۼӣ�������ĸ�����ӵó������λ�ã�����newCountArr[5] = 7����5��arr�е�λ�������7�����������5��������6,7λ
        for (int i = 1; i <= maxItem; i++) {
            newCountArr[i] += newCountArr[i - 1];
        }

        // ��ʱ����r���洢����֮��Ľ��
        int[] newArr = new int[len];
        // ��������Ĺؼ������ˣ��е������:��len-1��ʼ������0��ʼ��Ϊ�˱�֤�ȶ��ԣ���������arr,ͨ������ֵ�ҵ���newCountArr��Ӧ���±꣬��ֵ��newArr,�����ٿ���newArr��arr
        for (int i = len - 1; i >= 0; i--) {
            int item = arr[i];
            int index = newCountArr[item]--;
            newArr[index - 1] = item;
        }

        // ��������
        for (int i = 0; i < len; i++) {
            arr[i] = newArr[i];
        }
    }

    public static void main(String[] args) {
        MyCountingSort myCountingSort = new MyCountingSort();
        int n = 1000;
        int[] data1 = MySorts.getRandomArray(n);
        System.out.println("����ǰ");
        printArray(data1);
        System.out.println("��������");
        myCountingSort.countingSort(data1, n);
        printArray(data1);
    }

    public static void printArray(int[] data) {
        for (int a : data) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

}
