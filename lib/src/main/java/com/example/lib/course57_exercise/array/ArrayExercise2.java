package com.example.lib.course57_exercise.array;

/**
 * 实现一个大小固定的有序数组，支持动态增删改操作
 */
public class ArrayExercise2 {

    private static final int CAPACITY = 10; // 默认长度
    int[] list;  // 数组
    int count; // 数组内容长度


    public ArrayExercise2() {
        count = 0;
        list = new int[CAPACITY];
    }

    /**
     * 增
     *
     * @param obj
     * @return
     */
    public boolean add(int obj) {
        if (CAPACITY == count)
            return false;

        int position = binarySearch(obj);
        // 移动数组
        for (int i = count - 1; i >= position; i--) {
            list[i + 1] = list[i];
        }
        list[position] = obj; // 赋值
        ++count;
        return true;
    }

    /**
     * 删
     *
     * @param obj
     * @return
     */
    public int remove(int obj) {
        if (count == 0)
            return -1;

        int position = binarySearch(obj);

        if (position < count && list[position] == obj) {
            // 移动数组
            for (int i = position; i < count - 1; i++) {
                list[i] = list[i + 1];
            }
            count--;
            return position;
        } else
            return -1;
    }

    /**
     * 改
     */
    public boolean update(int oldObj, int newObj) {
        int position = remove(oldObj);

        if (position >= 0) {
            return add(newObj);
        } else
            return false;
    }

    /**
     * 在有序数组中进行二分查找，如果存在obj就返回对应的下标，不存在就返回需要插入的下标位置
     * 二分查找最主要的是要注意连续相等的情况
     *
     * @param obj
     * @return
     */
    private int binarySearch(int obj) {
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

    public int getSize() {
        return count;
    }

    public int get(int position) {
        int obj = -1;
        if (position < count) {
            obj = list[position];
        }
        return obj;
    }


    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.print(" " + list[i]);
        }
        System.out.println();
        System.out.println("数组长度： " + count);
    }

    public static void main(String[] args) {
        ArrayExercise2 array = new ArrayExercise2();

        for (int i = 0; i < 11; i++) {
            array.add((int) (Math.random() * 20));
        }

        array.print();

        for (int i = 0; i < 10; i++) {
            array.update((int) (Math.random() * 20), (int) (Math.random() * 20));
        }

        array.print();

        for (int i = 0; i < 10; i++) {
            array.remove((int) (Math.random() * 20));
        }
        array.print();
//
    }
}
