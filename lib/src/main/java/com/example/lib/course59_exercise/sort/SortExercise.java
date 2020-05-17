package com.example.lib.course59_exercise.sort;

/**
 * 关于排序的几个必知必会的代码实现
 * 冒泡，插入，选择，快速，归并
 */

public class SortExercise {

    /**
     * 冒泡排序：O(n^2),原地排序，稳定排序
     *
     * @param data
     * @return
     */
    public int[] bubbleSort(int[] data) {
        if (data == null || data.length == 0 || data.length == 1) {
            return data;
        }

        int n = data.length;
        for (int i = 0; i < n; i++) {
            boolean noTransFlag = false; // 判断这一轮是否有交换
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j] > data[j + 1]) { // 冒泡交换
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
     * 插入排序：O(n^2),原地排序，稳定排序
     *
     * @param data
     * @return
     */
    public int[] insertSort(int[] data) {
        if (data == null || data.length == 0 || data.length == 1) {
            return data;
        }

        int n = data.length;
        for (int i = 1; i < n; i++) {
            int value = data[i];
            for (int j = i - 1; j >= 0; j--) {
                if (data[j] > value) { // 移动
                    data[j + 1] = data[j];
                    data[j] = value; // 插入
                } else
                    break;
            }
        }

        return data;
    }

    /**
     * 选择排序：O(n^2),原地排序，不稳定排序
     *
     * @param data
     * @return
     */
    public int[] selectSort(int[] data) {
        if (data == null || data.length == 0 || data.length == 1) {
            return data;
        }

        int n = data.length;
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (data[j] > data[i]) { // 选择并交换
                    int value = data[i];
                    data[i] = data[j];
                    data[j] = value;
                }
            }
        }

        return data;
    }

    /**
     * 快速排序：O(nlogn),原地排序，不稳定排序
     * 这次写得垃圾，没之前的好，之前的MyQuickSort
     *
     * @param data
     * @return
     */
    public int[] quickSort(int[] data) {
        if (data == null || data.length == 0 || data.length == 1) {
            return data;
        }
        quickSortInternally(data, 0, data.length - 1);
        return data;
    }

    public void quickSortInternally(int[] data, int low, int high) {
        if (low >= high) {
            return;
        }
        // 找出选择点的坐标
        int middle = getQuickSortMiddle(data, low, high);
        quickSortInternally(data, low, middle - 1);
        quickSortInternally(data, middle + 1, high);
    }

    public int getQuickSortMiddle(int[] data, int low, int high) {
        if (low >= high) {
            return low;
        }

        int selectValue = data[high]; // 以最后一个作为选择点，其实这里可以随机选
        int m = low;
        for (int i = low; i < high; i++) {
            if (data[i] < selectValue) {
                if (i == m) {
                    m++;
                } else {
                    int value = data[m];
                    data[m] = data[i];
                    data[i] = value;
                    m++;
                }
            }
        }
        data[high] = data[m];
        data[m] = selectValue;
        return m;
    }

    /**
     * 归并排序：O(nlogn),稳定排序,非原地排序，空间复杂度是O(n)
     * 可以参考MyMergeSort
     *
     * @param data
     * @return
     */
    public int[] mergeSort(int[] data) {
        if (data == null || data.length == 0 || data.length == 1) {
            return data;
        }
        data = mergeSortInternally(data, 0, data.length - 1);
        return data;
    }

    private int[] mergeSortInternally(int[] data, int low, int high) {
        if (low > high)
            return null;
        if (low == high)
            return new int[]{data[low]};
        int center = (low + high) / 2;
        int[] leftList = mergeSortInternally(data, low, center);
        int[] rightList = mergeSortInternally(data, center + 1, high);
        return mergeArray(leftList, rightList);
    }

    /**
     * 两个有序数组合并
     *
     * @param list1
     * @param list2
     */
    private int[] mergeArray(int[] list1, int[] list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        int len1 = list1.length;
        int len2 = list2.length;
        int[] list3 = new int[len1 + len2];

        int indexLen1 = 0;
        int indexLen2 = 0;
        int index = 0;

        // 遍历
        while (indexLen1 < len1 && indexLen2 < len2) {
            if (list1[indexLen1] < list2[indexLen2]) {
                list3[index] = list1[indexLen1];
                indexLen1++;
            } else {
                list3[index] = list2[indexLen2];
                indexLen2++;
            }
            index++;
        }

        if (indexLen1 == len1) { // list1 已经遍历完了
            for (int i = indexLen2; i < len2; i++, index++) {
                list3[index] = list2[i];
            }
        } else { // list2 已经遍历完了
            for (int i = indexLen1; i < len1; i++, index++) {
                list3[index] = list1[i];
            }
        }

        return list3;
    }

    /**
     * 编程实现 O(n) 时间复杂度内找到一组数据的第 K 大元素
     *
     * @param data
     * @param k
     * @return
     */
    public int findIndexNum(int[] data, int k) {
        if (data == null || data.length == 0 || k > data.length) {
            return -1;
        }

        int low = 0;
        int high = data.length - 1;
        int index = high + 1 - k; // 第 K 大元素的下标
        // 找出选择点的坐标
        int middle = getQuickSortMiddle(data, low, high);
        while (middle != index) {
            if (middle > index) { // 下区间
                high = middle - 1;
            } else { // 上区间
                low = middle + 1;
            }
            middle = getQuickSortMiddle(data, low, high);
        }
        return data[index];
    }

    public void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(" " + data[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SortExercise sortExercise = new SortExercise();
        int n = 10;
//        int[] data = new int[]{2 ,1 ,1 ,1};
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = (int) (Math.random() * n);
        }
        sortExercise.print(data);
//        System.out.println("冒泡排序：");
//        sortExercise.print(sortExercise.bubbleSort(data));
//        System.out.println("插入排序：");
//        sortExercise.print(sortExercise.insertSort(data));
//        System.out.println("选择排序：");
//        sortExercise.print(sortExercise.selectSort(data));
//        System.out.println("快速排序：");
//        sortExercise.print(sortExercise.quickSort(data));
//        System.out.println("归并排序：");
//        sortExercise.print(sortExercise.mergeSort(data));
//        System.out.println("第3个：");
//        System.out.println(sortExercise.findIndexNum(data, 3) + "");
        System.out.println("归并排序：");
        sortExercise.print(sortExercise.mergeSort(data));
    }

}
