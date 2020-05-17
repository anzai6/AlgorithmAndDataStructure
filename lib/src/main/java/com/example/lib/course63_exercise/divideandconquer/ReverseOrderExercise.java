package com.example.lib.course63_exercise.divideandconquer;

/**
 * 利用分治算法求一组数据的逆序对个数
 */

public class ReverseOrderExercise {

    int count;

    /**
     * 通过分治思路：归并排序，在排序的过程中计算逆序
     *
     * @param data
     * @return
     */
    public int countReverseOrder(int[] data) {
        countReverseOrderIn(data, 0, data.length - 1);
        return count;
    }

    private void countReverseOrderIn(int[] data, int low, int high) {
        if (low >= high)
            return;
        if (low == high - 1) {
            if (data[low] > data[high]) {
                int item = data[low];
                data[low] = data[high];
                data[high] = item;
                count++;
            }
            return;
        }
        int center = (low + high) / 2;
        countReverseOrderIn(data, low, center);
        countReverseOrderIn(data, center + 1, high);
        mergeList(data, low, center, high);
    }

    private void mergeList(int[] data, int low, int center, int high) {
        int n = high - low + 1;
        int[] cacheList = new int[n];
        int i = 0;
        int j = low; // 下区间的坐标
        int k = center + 1; // 上区间的坐标

        while (j <= center && k <= high) {
            if (data[j] <= data[k]) {
                cacheList[i] = data[j];
                count += (k - center - 1); // 增加的逆序个数,(k - center - 1)是上区间已经合并的个数
                j++;
            } else {
                cacheList[i] = data[k];
                k++;
            }
            i++;
        }
        if (j > center) { // 下区间合并完，搬运上区间
            for (; k <= high; k++, i++) {
                cacheList[i] = data[k];
            }
        } else { // 上区间合并完，搬运下区间
            for (; j <= center; j++, i++) {
                cacheList[i] = data[j];
                count += (high - center); // 增加的逆序个数，(high - center)是上区间已经合并的个数
            }

        }

        // 搬运
        for (int l = 0; l < n; l++) {
            data[l + low] = cacheList[l];
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{7, 5, 6, 4, 1, 2, 3, 4};
        ReverseOrderExercise exercise = new ReverseOrderExercise();
        System.out.println("逆序个数：" + exercise.countReverseOrder(data));
        System.out.println("排序的数组：");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }
}
