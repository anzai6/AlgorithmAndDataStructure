package com.example.lib.course11_sorts.my;

/**
 * 冒泡排序，插入排序，选择排序
 * Created by qinshunan on 2019/2/27.
 */
public class MySorts {

    /**
     * 冒泡排序，不断的跟相邻的item去比较，然后交换
     * (稳定性排序，即相同的item位置不会改变)
     * 这是向上冒泡，还有向下冒泡，即从0开始依次往上比较，小于则交换到0的位置，一轮下来0项就是最小的，以此类推。
     *
     * @param data
     * @return
     */
    public int[] bubblingSort(int[] data) {
        int n = data.length;
        for (int i = 0; i < n; i++) {
            boolean noTransFlag = false; // 判断这一轮是否有交换
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j] > data[j + 1]) {// 大于则交换
                    int value = data[j + 1];
                    data[j + 1] = data[j];
                    data[j] = value;
                    noTransFlag = true;
                }
            }
            // 如果没有发生交换证明已经排序好了，后面都不用再循环了
            if (!noTransFlag)
                break;
        }
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
        int n = data.length;
        for (int i = 1; i < n; i++) { // 从1开始，因为0项不需要比较
            int value = data[i];
            int j = i - 1;
            for (; j >= 0; j--) { // j以内的是排序好的选项
                if (data[j] > value) { // 大于value则往右移动一位
                    data[j + 1] = data[j];
                } else {
                    break;
                }
            }
            data[j + 1] = value;
        }
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
        int n = data.length;
        for (int i = n - 1; i > 0; i--) { // 0项不需要比较
            for (int j = i - 1; j >= 0; j--) {
                if (data[j] > data[i]) {// 大于则交换
                    int value = data[i];
                    data[i] = data[j];
                    data[j] = value;
                }
            }
        }
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
        int n = data.length;
        for (int i = 1; i < n; i++) { // 从1开始，因为0项不需要比较

            // 先找出中位数的下标m
            int value = data[i];
            int low = 0; // 比较区间的第一个元素所在位置
            int high = i - 1; // 比较区间的最后一个元素所在位置
            int m = 0; // 中位数
            while (low <= high) {
                m = (low + high) / 2;
                if (data[m] > value) { // 往低区间走
                    high = m - 1;
                } else { // 往高
                    low = m + 1;
                }
            }

            // 往右移动数据,考虑零界点low=hign的时候的hign的走势可知最终要移动的是high+1到i-1区间的值，好好考虑
            for (int j = i - 1; j > high; j--) {
                data[j + 1] = data[j];
            }
            data[high + 1] = value;

        }
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
        int n = data.length;
        int interval = n / 2; // 间隔，开始长度为数组长度的一半，然后逐渐递减
        for (; interval > 0; interval /= 2) { // 按间隔分组
            // 对间隔以内的各个分组进行插入排序
            for (int i = interval; i < n; i++) {
                // 将arr[i]插入到所在分组的正确位置
                insertI(data, interval, i);
            }
        }
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
        int insertValue = arr[i];
        int j;
        for (j = i - interval; j >= 0; j -= interval) {
            if (arr[j] > insertValue) {
                arr[j + interval] = arr[j];
            } else {
                break;
            }
        }
        arr[j + interval] = insertValue;
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
