package com.example.lib.course13_sort.finals;

import com.example.lib.course11_sorts.finals.Sorts;

/**
 * ��������Ҫ������Ķ��������д洢�Ķ��ǷǸ����������ҷ�Χ���󣬿������ȶ��Եģ���Ҫ�ռ�n����ԭ������,ʱ�临�ӵ��ǣ�7n+c
 * ������ݹ�������Ǹ��������Խ�����ֵ����ȫ��Ԫ�ؼ�ȥ10000�����߱�Ϊ����������������
 * Created by qinshunan on 2019/3/11.
 */
public class CountingSort {


    /**
     * �������򣬼��������д洢�Ķ��ǷǸ�������
     *
     * @param arr
     * @param len
     */
    public void countingSort(int[] arr, int len) {
        if (arr == null || arr.length == 0) {
            System.out.println("arr is empty");
            return;
        }
        if (arr.length == 1) {
            return;
        }
        int maxItem = arr[0];
        // �ڲ�֪�����ֵ������£�����һ��Ѱ�����ֵ
        for (int i = 1; i < len; i++) {
            if (arr[i] > maxItem) {
                maxItem = arr[i];
            }
        }

        // �������ֵ���������飬���Բ���ԭ��������
        int[] countArr = new int[maxItem + 1];
        // ����ÿ��Ԫ�صĸ���������countArr�У�arr�����ֵ��ӦcountArr���±ꣻ����arr��ĳ��ֵ2,��countArr[2]��ֵ��Ӧ����arr[]=2�ĸ���
        for (int i = 0; i < len; i++) {
            countArr[arr[i]]++;
        }
        // ������������ܣ���һ���Ǿ��������ܺ�ÿ��Ԫ�ش������ arr ����Ķ���λ�ã�
        // ���� countArr[8] = 9; ��Ԫ��8����� position Ϊ�� arr ���±�Ϊ 9 �� item��������������Ͷ���
        for (int i = 1; i < maxItem + 1; i++) {
            countArr[i] += countArr[i - 1];
        }

        // �½�����������õ�Ԫ��
        int[] tempArr = new int[len];
        // ���򣬴Ӻ���ǰ������Ϊ�˱�֤�ȶ��ԣ�ԭ���� aar ��������ĳ�� item ʱȥ countArr �鿴���������λ���±꣬
        // Ȼ������Ӧ�±�� tempArr ����
        for (int i = len - 1; i >= 0; i--) {
            int value = arr[i];
            int valueIndex = (countArr[value]-- - 1);
            tempArr[valueIndex] = value;
        }

        // copy
        for (int i = 0; i < len; i++) {
            arr[i] = tempArr[i];
        }
    }

    public static void main(String[] args) {
        CountingSort myCountingSort = new CountingSort();
        int n = 100;
        int[] data1 = Sorts.getRandomArray(n);
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
