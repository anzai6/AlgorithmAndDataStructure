package com.example.lib.course5_array.finals;

/**
 * 1) 数组的插入、删除、按照下标随机访问操作；
 * 2）数组中的数据是int类型的；
 */
public class Array {
    //定义整型数据data保存数据
    public int data[];
    //定义数组长度
    private int n;
    //定义中实际个数
    private int count;

    //构造方法，定义数组大小
    public Array(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity need to big than zero");
        }
        data = new int[capacity];
        n = capacity;
        count = 0;
    }

    //根据索引，找到数据中的元素并返回
    public int find(int index) {
        if (index < 0 || index > count - 1) {
            return -1;
        }
        return data[index];
    }

    //插入元素:头部插入，尾部插入
    public boolean insert(int index, int value) {
        if (index < 0 || index > count) {
            return false;
        }
        // 数组已满
        if (count == n) {
            return false;
        }
        // 后移
        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        count++;
        return true;
    }

    //根据索引，删除数组中元素
    public boolean delete(int index) {
        if (index < 0 || index > count - 1) {
            return false;
        }

        // 数组空空
        if (count == 0) {
            return false;
        }
        // 覆盖数组
        for (int i = index; i < count - 1; i++) {
            data[i] = data[i + 1];
        }
        count--;
        return true;
    }

    public static void main(String[] args) {
        int capacity = 6;
        Array array = new Array(capacity);
        for (int i = 0; i < capacity; i++) {
            array.insert(0, i);
        }
        array.delete(0);
        array.printAll();
    }

    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }


}