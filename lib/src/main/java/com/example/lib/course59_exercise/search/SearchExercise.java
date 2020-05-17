package com.example.lib.course59_exercise.search;

import com.example.lib.course59_exercise.sort.SortExercise;

/**
 * Created by qinshunan on 2019/6/6.
 */

public class SearchExercise {

    /**
     * 在有序数组中进行二分查找，如果存在obj就返回对应的下标，不存在就返回需要插入的下标位置
     * 二分查找最主要的是要注意连续相等的情况
     *
     * @param obj
     * @return
     */
    private int binarySearch(int[] list, int obj) {
        if (list == null)
            return -1;
        int count = list.length;
        if (count == 0)
            return 0;

        int low = 0;
        int high = count - 1;
        int center = (low + high) / 2;

        if (obj <= list[0]) { // 判断第一个，做优化防止极端情况要不停的往下区间移动
            return 0;
        }

        if (list[count - 1] <= obj) { // 判断最后一个，做优化防止极端情况要不停的往上区间移动
            return count;
        }

        if (count == 2) // 长度为2的时候，前面两个已经判断了插入0和2的情况，所有只剩1了
            return 1;

        low = 1;
        high = count - 2;

        while (low < high) {
            if (list[center] < obj) { // obj在上区间
                low = center + 1;
            } else if (list[center] > obj) { // obj在下区间
                high = center - 1;
            } else { // 相等
                return center;
            }
            center = (low + high) / 2;
        }

        // 下面是low=high=center的情况

        // 这里开始犯了一个错误，忽略了连续相等的情况，比如77，判断7<8 之后直接插入，就会导致插入了787这样的数据
        if (list[center] < obj) { // obj在上区间
            // 去掉相邻且相等的值
            while (center < count - 1 && list[center + 1] == list[center]) {
                ++center;
            }
            ++center;
        } else if (list[center] > obj) { // obj在下区间,下区间开始也犯了一个错误，一开始用了--center;，其实在下区间不用减一了
            // 去掉相邻且相等的值
            while (center > 0 && list[center - 1] == list[center]) {
                --center;
            }
//            --center  不需要减，注意理解
        }

        return center < 0 ? 0 : center; // 插入位置
    }

    /**
     * 有序数组二分查找，大于等于给定值的第一个元素
     *
     * @param obj
     * @return
     */
    private int binarySearchBig(int[] list, int obj) {
        if (list == null)
            return -1;
        int count = list.length;
        if (count == 0)
            return 0;

        int low = 0;
        int high = count - 1;
        int center = (low + high) / 2;

        while (low <= high) {
            if (list[center] < obj) { // obj在上区间
                low = center + 1;
            } else if (list[center] >= obj) { // obj在下区间
                if (center == 0 || list[center - 1] < obj) {
                    return center;
                } else {
                    high = center - 1;
                }
            }
            center = (low + high) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        SortExercise sortExercise = new SortExercise();
        SearchExercise searchExercise = new SearchExercise();
        int n = 10;
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = (int) (Math.random() * n);
        }
        sortExercise.print(sortExercise.quickSort(data));
        System.out.println(searchExercise.binarySearchBig(data, 5) + "");
    }

}
