package com.example.lib.course57_exercise.array;

/**
 * 实现一个支持动态扩容的数组
 */
public class ArrayExercise1<T> {

    private static final int CAPACITY = 16; // 默认长度
    int size; // 数组长度
    T[] list;  // 数组
    int count; // 数组内容长度

    public ArrayExercise1() {
        this(CAPACITY);
    }

    public ArrayExercise1(int capacity) {
        size = capacity;
        count = 0;
        list = (T[]) new Object[size];
    }

    public boolean add(T obj) {
        return add(count, obj);
    }

    public boolean add(int position, T obj) {
        if (position > count || position < 0)
            return false;
        if (count == size) { // 满了,自动扩容
            autoExpandOrCompress();
        }

        // 移动数组
        for (int i = count - 1; i >= position; i--) {
            list[i + 1] = list[i];
        }
        list[position] = obj; // 赋值
        ++count;
        return true;
    }

    public int remove(T obj) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (list[i] == obj) {
                index = i;
                break;
            }
        }

        // 移动数组
        for (int i = index; i < count - 1; i++) {
            list[i] = list[i + 1];
        }
        list[count - 1] = null; // 记得清空
        count--;

        if (count == size / 4) { // 自动压缩
            autoExpandOrCompress();
        }
        return index;
    }

    public T remove(int position) {
        T obj = null;
        if (position < count && position >= 0) {
            obj = list[position];
            // 移动数组
            for (int i = position; i < count - 1; i++) {
                list[i] = list[i + 1];
            }
            list[count - 1] = null; // 记得清空
            count--;

            if (count == size / 4) { // 自动压缩
                autoExpandOrCompress();
            }
        }

        return obj;
    }

    /**
     * 自动扩容或者压缩
     */
    private void autoExpandOrCompress() {
        if (count == 0)
            return;
        size = count * 2;
        size = size < 8 ? 8 : size;// 限度最小就是8了，再小没意义
        T[] newList = (T[]) new Object[size];
        copyArray(list, count, newList); // 拷贝数组
        list = newList;
    }


    /**
     * 拷贝数组
     *
     * @param copyList
     * @param copyLength
     * @param resultList
     */
    private void copyArray(T[] copyList, int copyLength, T[] resultList) {
        if (copyList == null || resultList == null)
            return;
        if (copyList.length < copyLength || resultList.length < copyLength)
            return;
        for (int i = 0; i < copyLength; i++) {
            resultList[i] = copyList[i];
        }
    }


    public int getSize() {
        return count;
    }

    public T get(int position) {
        T obj = null;
        if (position < count && position >= 0) {
            obj = list[position];
        }
        return obj;
    }

    public boolean contains(T e) {
        for (int i = 0; i < count; i++) {
            if (list[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > count) {
            throw new IllegalArgumentException("Add failed! Require index >=0 and index <= count.");
        }
    }


    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.print(" " + list[i]);
        }
        System.out.println();
        System.out.println("数组长度： " + size + " -- 内容长度：" + count);
    }

    public static void main(String[] args) {
        ArrayExercise1<Integer> array = new ArrayExercise1<>(2);

        for (int i = 0; i < 10; i++) {
            array.add(i);
        }

        for (int i = 0; i < 10; i++) {
            array.remove(0);
            array.print();
        }
    }
}
