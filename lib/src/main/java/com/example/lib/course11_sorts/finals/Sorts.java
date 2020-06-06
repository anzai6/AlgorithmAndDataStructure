package com.example.lib.course11_sorts.finals;

import com.example.lib.course11_sorts.my.MySorts;

/**
 * 冒泡排序、插入排序、选择排序
 * <p>
 * Author: Zheng
 */
public class Sorts {

    /**
     * 冒泡排序，不断的跟相邻的item去比较，然后交换
     * (稳定性排序，即相同的item位置不会改变)
     * 这是向上冒泡，还有向下冒泡，即从0开始依次往上比较，小于则交换到0的位置，一轮下来0项就是最小的，以此类推。
     *
     * @param data
     * @return
     */
    public int[] bubblingSort(int[] data) {
        return data;
    }

    /**
     * 插入排序，左边是排序好的，不断往右扩散，如：0和1项排序好了，拿2项跟0和1比较，插入合适的位置，
     * 然后0、1、2排序好了，拿3项跟0、1、2比较，插入合适的位置，以此类推后续。
     * (稳定性排序，即相同的item位置不会改变)
     *
     * @param data
     * @return
     */
    public int[] insertionSort(int[] data) {
        return data;
    }

    /**
     * 选择排序，取n-1项不断跟项目比较，大于n-1项则交换，最终n-1项就是最大值，然后n-2、n-3....以此类推
     * (非稳定性排序,因为存在交换位置)
     *
     * @param data
     * @return
     */
    public int[] selectionSort(int[] data) {
        return data;
    }

    /**
     * 扩展：
     * 折半插入排序，0~i-1项是已排序好的，然后利用折半搜索法寻找i项的插入位置。然后对应的数据往后移动
     * (稳定性排序，即相同的item位置不会改变)
     *
     * @param data
     * @return
     */
    public int[] halfInsertionSort(int[] data) {
        return data;
    }


    /**
     * 扩展：
     * 希尔排序：https://blog.csdn.net/qq_39207948/article/details/80006224
     * (非稳定性排序)
     *
     * @param data
     * @return
     */
    public int[] shellSort(int[] data) {
        return data;
    }

    /**
     * 将arr[i]插入到所在分组的正确位置
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
//        System.out.println("排序前");
//        mySorts.printArray(data1);
//        System.out.println("冒泡排序：");
//        mySorts.bubblingSort(data1);
//        mySorts.printArray(data1);
//
//        System.out.println("排序前");
//        mySorts.printArray(data2);
//        System.out.println("插入排序：");
//        mySorts.insertionSort(data2);
//        mySorts.printArray(data2);
//
//        System.out.println("排序前");
//        mySorts.printArray(data3);
//        System.out.println("选择排序：");
//        mySorts.selectionSort(data3);
//        mySorts.printArray(data3);
//
//        System.out.println("排序前");
//        mySorts.printArray(data3);
//        System.out.println("折半插入排序：");
//        mySorts.halfInsertionSort(data3);
//        mySorts.printArray(data3);
//
        System.out.println("排序前");
        mySorts.printArray(data3);
        System.out.println("希尔排序：");
        mySorts.shellSort(data3);
        mySorts.printArray(data3);


        // 比较冒泡和插入排序的耗时：随机a个a长度的数组来排序
        /*int a = 5000;

        int[][] data4 = new int[a][a];
        for (int i = 0; i < a; i++) {
            data4[i] = getRandomArray(a);
        }
        int[][] data5 = new int[a][a];
        for (int i = 0; i < a; i++) {
            data5[i] = getRandomArray(a);
        }

        // 冒泡排序
        long buTime = System.currentTimeMillis();
        for (int i = 0; i < a; i++) {
            mySorts.bubblingSort(data4[i]);
        }
        buTime = System.currentTimeMillis() - buTime;
        System.out.println("冒泡排序：" + buTime);

        // 插入排序
        long insertTime = System.currentTimeMillis();
        for (int i = 0; i < a; i++) {
            mySorts.insertionSort(data5[i]);
        }
        insertTime = System.currentTimeMillis() - insertTime;
        System.out.println("插入排序：" + insertTime);*/
    }

    /**
     * 获取一个随机数组
     *
     * @param n 长度
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
