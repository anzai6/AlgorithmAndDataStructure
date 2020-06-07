package com.example.lib.course11_sorts.finals;

import com.example.lib.course11_sorts.my.MySorts;

/**
 * ð�����򡢲�������ѡ������
 * <p>
 * Author: Zheng
 */
public class Sorts {

    /**
     * ð�����򣬲��ϵĸ����ڵ�itemȥ�Ƚϣ�Ȼ�󽻻�
     * (�ȶ������򣬼���ͬ��itemλ�ò���ı�)
     * ��������ð�ݣ���������ð�ݣ�����0��ʼ�������ϱȽϣ�С���򽻻���0��λ�ã�һ������0�������С�ģ��Դ����ơ�
     *
     * @param data
     * @return
     */
    public int[] bubblingSort(int[] data) {
        return data;
    }

    /**
     * �����������������õģ�����������ɢ���磺0��1��������ˣ���2���0��1�Ƚϣ�������ʵ�λ�ã�
     * Ȼ��0��1��2������ˣ���3���0��1��2�Ƚϣ�������ʵ�λ�ã��Դ����ƺ�����
     * (�ȶ������򣬼���ͬ��itemλ�ò���ı�)
     *
     * @param data
     * @return
     */
    public int[] insertionSort(int[] data) {
        return data;
    }

    /**
     * ѡ������ȡn-1��ϸ���Ŀ�Ƚϣ�����n-1���򽻻�������n-1��������ֵ��Ȼ��n-2��n-3....�Դ�����
     * (���ȶ�������,��Ϊ���ڽ���λ��)
     *
     * @param data
     * @return
     */
    public int[] selectionSort(int[] data) {
        return data;
    }

    /**
     * ��չ��
     * �۰��������0~i-1����������õģ�Ȼ�������۰�������Ѱ��i��Ĳ���λ�á�Ȼ���Ӧ�����������ƶ�
     * (�ȶ������򣬼���ͬ��itemλ�ò���ı�)
     *
     * @param data
     * @return
     */
    public int[] halfInsertionSort(int[] data) {
        return data;
    }


    /**
     * ��չ��
     * ϣ������https://blog.csdn.net/qq_39207948/article/details/80006224
     * (���ȶ�������)
     *
     * @param data
     * @return
     */
    public int[] shellSort(int[] data) {
        return data;
    }

    /**
     * ��arr[i]���뵽���ڷ������ȷλ��
     *
     * @param arr
     * @param interval
     * @param i
     */
    private void insertI(int[] arr, int interval, int i) {
    }

    public void printArray(int[] data) {
        for (int a : data) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MySorts mySorts = new MySorts();
        int n = 10;
        int[] data1 = getRandomArray(n);
        int[] data2 = getRandomArray(n);
        int[] data3 = getRandomArray(n);
//        System.out.println("����ǰ");
//        mySorts.printArray(data1);
//        System.out.println("ð������");
//        mySorts.bubblingSort(data1);
//        mySorts.printArray(data1);
//
//        System.out.println("����ǰ");
//        mySorts.printArray(data2);
//        System.out.println("��������");
//        mySorts.insertionSort(data2);
//        mySorts.printArray(data2);
//
//        System.out.println("����ǰ");
//        mySorts.printArray(data3);
//        System.out.println("ѡ������");
//        mySorts.selectionSort(data3);
//        mySorts.printArray(data3);
//
//        System.out.println("����ǰ");
//        mySorts.printArray(data3);
//        System.out.println("�۰��������");
//        mySorts.halfInsertionSort(data3);
//        mySorts.printArray(data3);
//
//        System.out.println("����ǰ");
        System.out.println("ˮ��ѵ���");
//        mySorts.printArray(data3);
//        System.out.println("ϣ������");
//        mySorts.shellSort(data3);
//        mySorts.printArray(data3);


        // �Ƚ�ð�ݺͲ�������ĺ�ʱ�����a��a���ȵ�����������
        /*int a = 5000;

        int[][] data4 = new int[a][a];
        for (int i = 0; i < a; i++) {
            data4[i] = getRandomArray(a);
        }
        int[][] data5 = new int[a][a];
        for (int i = 0; i < a; i++) {
            data5[i] = getRandomArray(a);
        }

        // ð������
        long buTime = System.currentTimeMillis();
        for (int i = 0; i < a; i++) {
            mySorts.bubblingSort(data4[i]);
        }
        buTime = System.currentTimeMillis() - buTime;
        System.out.println("ð������" + buTime);

        // ��������
        long insertTime = System.currentTimeMillis();
        for (int i = 0; i < a; i++) {
            mySorts.insertionSort(data5[i]);
        }
        insertTime = System.currentTimeMillis() - insertTime;
        System.out.println("��������" + insertTime);*/
    }

    /**
     * ��ȡһ���������
     *
     * @param n ����
     * @return
     */
    public static int[] getRandomArray(int n) {
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = (int) (Math.random() * n);
        }
        return data;
    }

}
