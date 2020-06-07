package com.example.lib.course5_array.finals;

/**
 */

public class GenericArray<T> {
    private T[] data;
    private int size;

    // 根据传入容量，构造Array
    public GenericArray(int capacity) {
    }

    // 无参构造方法，默认数组容量为10
    public GenericArray() {
    }

    // 获取数组容量
    public int getCapacity() {
        return 0;
    }

    // 获取当前元素个数
    public int count() {
        return size;
    }

    // 判断数组是否为空
    public boolean isEmpty() {
        return false;
    }

    // 修改 index 位置的元素
    public void set(int index, T e) {
    }

    // 获取对应 index 位置的元素
    public T get(int index) {
        return null;
    }

    // 查看数组是否包含元素e
    public boolean contains(T e) {
        return false;
    }

    // 获取对应元素的下标, 未找到，返回 -1
    public int find(T e) {
        return -1;
    }


    // 在 index 位置，插入元素e, 时间复杂度 O(m+n)
    public void add(int index, T e) {
    }

    // 向数组头插入元素
    public void addFirst(T e) {

    }

    // 向数组尾插入元素
    public void addLast(T e){
    }

    // 删除 index 位置的元素，并返回
    public T remove(int index) {

        return null;
    }

    // 删除第一个元素
    public T removeFirst() {
        return null;
    }

    // 删除末尾元素
    public T removeLast() {
        return null;
    }

    // 从数组中删除指定元素
    public void removeElement(T e) {
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("MyArray size = %d, capacity = %d \n", size, data.length));
        builder.append('[');
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }


    // 扩容方法，时间复杂度 O(n)
    private void resize(int capacity) {
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed! Require index >=0 and index <= size.");
        }
    }

    private void checkIndexForRemove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed! Require index >=0 and index < size.");
        }
    }
}