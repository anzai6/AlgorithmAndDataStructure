package com.example.lib.course5_array.my;

/**
 * Created by qinshunan on 2019/1/29.
 * 查，插入，删除
 */
public class MyArray {

    int data[];
    int n;
    int count;

    public MyArray(int index) {
        data = new int[index];
        n = index;
        count = 0;
    }

    public int find(int index) {
        if (index < 0 || index >= count)
            return -1;
        return data[index];
    }

    public boolean insert(int index, int value) {
        if (count == n)
            return false;
        if (index < 0 || index > count)
            return false;
        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        ++count;
        return true;
    }

    public boolean delete(int index) {
        if (index < 0 || index >= count)
            return false;
        for (int i = index; i < count - 1; i++) {
            data[i] = data[i + 1];
        }
        --count;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

}
