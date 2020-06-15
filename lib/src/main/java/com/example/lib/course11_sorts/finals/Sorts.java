package com.example.lib.course11_sorts.finals;

/**
 * 冒泡排序、插入排序、选择排序
 */
public class Sorts {

    /**
     * 冒泡排序，不断的跟相邻的item去比较，然后交换
     * (稳定性排序，即相同的item位置不会改变)
     * 这是向上冒泡，还有向下冒泡，即从0开始依次往上比较，小于则交换到0的位置，一轮下来0项就是最小的，以此类推。
     * <p>
     * 稳定性排序，时间复杂度：最好 O(n^2)，最坏O(n^2)，平均O(n^2)
     *
     * @param data
     * @return
     */
    public int[] bubblingSort(int[] data) {
        if (data == null || data.length == 0) {
            System.out.println("data is empty");
            return data;
        }
        int len = data.length;
        for (int i = len - 1; i > 0; i--) {
            boolean isSwap = false;
            for (int j = 0; j < i; j++) {
                if (data[j] > data[j + 1]) { // 大于则交换
                    swapData(data, j, j + 1);
                    isSwap = true;
                }
            }
            if (!isSwap) { // 没有交换后，证明已经是有序的了
                return data;
            }
        }
        return data;
    }

    /**
     * 插入排序，左边是排序好的，不断往右扩散，如：0和1项排序好了，拿2项跟0和1比较，插入合适的位置，
     * 然后0、1、2排序好了，拿3项跟0、1、2比较，插入合适的位置，以此类推后续。
     * (稳定性排序，即相同的item位置不会改变)
     * <p>
     * 稳定性排序，时间复杂度：最好 O(n)，最坏O(n^2)，平均O(n^2)
     *
     * @param data
     * @return
     */
    public int[] insertionSort(int[] data) {
        if (data == null || data.length == 0) {
            System.out.println("data is empty");
            return data;
        }
        int len = data.length;
        for (int i = 1; i < len; i++) {
            int item = data[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                // 大于要插入的item时，往前移动
                if (data[j] > item) {
                    data[j + 1] = data[j];
                } else {
                    break;
                }
            }
            data[j + 1] = item;
        }
        return data;
    }

    /**
     * 选择排序，取n-1项不断跟项目比较，大于n-1项则交换，最终n-1项就是最大值，然后n-2、n-3....以此类推
     * (非稳定性排序,因为存在交换位置)
     * 非稳定性排序，时间复杂度：最好 O(n^2)，最坏O(n^2)，平均O(n^2)
     *
     * @param data
     * @return
     */
    public int[] selectionSort(int[] data) {
        if (data == null || data.length == 0) {
            System.out.println("data is empty");
            return data;
        }
        int len = data.length;
        for (int i = 0; i < len - 1; i++) {
            int maxItem = data[i];
            int maxIndex = i;

            for (int j = i + 1; j < len; j++) {
                if (data[j] < maxItem) {
                    maxItem = data[j];
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                swapData(data, i, maxIndex);
            }
        }
        return data;
    }

    /**
     * 插入排序针对数据量小或者基本有序的数据排序效率很高，对于数据量大且无序的数据效率较低，希尔排序就是据此改进的，
     * 现将数组进行间隔分成一个个组，此时一组数据很小，那插入排序就很高效，然后慢慢缩小间隔（每次缩小一半间隔），每组数据慢慢增多，
     * 但由于前面的铺垫，数据有序度较高，所以此时数据量虽大，效率也依旧很高，等到间隔缩小到1后，排序完成
     * 扩展：
     * 希尔排序：https://blog.csdn.net/qq_39207948/article/details/80006224
     * (非稳定性排序)
     *
     * @param data
     * @return
     */
    public int[] shellSort(int[] data) {
        if (data == null || data.length == 0) {
            System.out.println("data is empty");
            return data;
        }
        int len = data.length;
        // 从 len/2 间隔开始，每排序完一个间隔，将间隔缩小一半
        for (int gap = len / 2; gap >= 1; gap = gap / 2) {
            // 对间隔以内的各个分组进行插入排序
            for (int i = gap; i < len; i++) {
                // 将arr[i]插入到所在分组的正确位置
                insertI(data, gap, i);
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

    public void swapData(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void printArray(int[] data) {
        for (int a : data) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Sorts mySorts = new Sorts();
        int n = 10;
        int[] data1 = getRandomArray(n);
        int[] data2 = getRandomArray(n);
        int[] data3 = getRandomArray(n);
//        System.out.println("排序前");
//        mySorts.printArray(data1);
//        System.out.println("冒泡排序：");
//        mySorts.bubblingSort(data1);
//        mySorts.printArray(data1);

//        System.out.println("排序前");
//        mySorts.printArray(data2);
//        System.out.println("插入排序：");
//        mySorts.insertionSort(data2);
//        mySorts.printArray(data2);

//        System.out.println("排序前");
//        mySorts.printArray(data3);
//        System.out.println("选择排序：");
//        mySorts.selectionSort(data3);
//        mySorts.printArray(data3);

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
