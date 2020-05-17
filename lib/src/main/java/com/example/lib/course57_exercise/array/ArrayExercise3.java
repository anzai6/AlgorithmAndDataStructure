package com.example.lib.course57_exercise.array;

/**
 * 实现两个有序数组合并为一个有序数组
 */
public class ArrayExercise3 {


    public ArrayExercise3() {
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

        /*// 优化1：比较第一个字段，list1数组的小就从1开始遍历这个数组，找到所有比list2[0]小的字段直接加list3
        if (list1[0] < list2[0]) {
            list3[0] = list1[0];
            index++;
            // 先在 list1 中找左边比 list2 第一个字段小的所有字段
            for (; index < len1; index++) {
                if (list1[index] < list2[0]) {
                    list3[index] = list1[index];
                } else
                    break;
            }
            indexLen1 = index;
        } else { // list2 数组的小同上
            list3[0] = list2[0];
            index++;
            // 先在 list2 中找左边比 list1 第一个字段小的所有字段
            for (; index < len2; index++) {
                if (list2[index] < list1[0]) {
                    list3[index] = list2[index];
                } else
                    break;
            }
            indexLen2 = index;
        }
        // 上面这个优化省去了前面已经排好序的数组，省得还需要挨个去比较*/
        // 这个优化好像没啥用，JDK里面的这种方式好像是同一个数组下的合并，比较适合

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
                list3[index] = list2[indexLen2];
            }
        } else { // list2 已经遍历完了
            for (int i = indexLen1; i < len1; i++, index++) {
                list3[index] = list1[indexLen1];
            }
        }

        return list3;
    }


    public static void main(String[] args) {
        int[] list1 = new int[]{1, 2, 3, 5, 7, 9};
        int[] list2 = new int[]{4, 6, 8, 10};
        ArrayExercise3 array = new ArrayExercise3();

        int[] list3 = array.mergeArray(list1, list2);

        if (list3 != null)
            for (int i = 0; i < list3.length; i++) {
                System.out.print(" " + list3[i]);
            }
    }
}
