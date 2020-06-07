package com.example.lib.course5_array.finals;

/**
 * 通用动态扩容数组
 */
public class GenericArray<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private T[] data;
    private int size;
    private int count;

    // 无参构造方法，默认数组容量为10
    public GenericArray() {
        this(DEFAULT_CAPACITY);
    }

    // 根据传入容量，构造Array
    public GenericArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity is invalid");
        }
        data = (T[]) new Object[capacity];
        size = capacity;
        count = 0;
    }

    // 获取数组容量
    public int getCapacity() {
        return size;
    }

    // 获取当前元素个数
    public int count() {
        return count;
    }

    // 判断数组是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    // 修改 index 位置的元素
    public void set(int index, T e) {
        if (index < 0 || index > count) {
            System.out.println("index invalid");
            return;
        }
        data[index] = e;
    }

    // 获取对应 index 位置的元素
    public T get(int index) {
        if (index < 0 || index >= count) {
            System.out.println("index invalid");
            return null;
        }
        return data[index];
    }

    // 查看数组是否包含元素e
    public boolean contains(T e) {
        if (isEmpty()) {
            return false;
        }
        for (int i = 0; i < count; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 获取对应元素的下标, 未找到，返回 -1
    public int find(T e) {
        if (isEmpty()) {
            return -1;
        }
        for (int i = 0; i < count; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // 在 index 位置，插入元素e, 时间复杂度 O(m+n)
    public void add(int index, T e) {
        if (index < 0 || index > count) {
            System.out.println("index invalid");
            return;
        }
        // 数组已满，扩容
        if (count == size) {
            resize(count);
        }
        // 后移
        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        count++;
    }

    // 向数组头插入元素
    public void addFirst(T e) {
        add(0, e);
    }

    // 向数组尾插入元素
    public void addLast(T e) {
        add(count, e);
    }

    // 删除 index 位置的元素，并返回
    public T remove(int index) {
        if (index < 0 || index > count - 1) {
            System.out.println("index invalid");
            return null;
        }

        // 数组空空
        if (isEmpty()) {
            return null;
        }
        T e = data[index];
        // 覆盖数组
        for (int i = index; i < count - 1; i++) {
            data[i] = data[i + 1];
        }
        count--;

        // 缩容
        if (size / 4 == count) {
            reduceSize(size);
        }
        return e;
    }

    // 删除第一个元素
    public T removeFirst() {
        return remove(0);
    }

    // 删除末尾元素
    public T removeLast() {
        return remove(count - 1);
    }

    // 从数组中删除指定元素
    public void removeElement(T e) {
        if (isEmpty()) {
            return;
        }
        for (int i = 0; i < count; i++) {
            if (data[i] == e) {
                remove(i);
                return;
            }
        }
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
        int newCapacity = capacity * 2;
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < capacity; i++) {
            newData[i] = data[i];
        }
        data = newData;
        size = newCapacity;
    }

    // 缩容方法，时间复杂度 O(n)
    private void reduceSize(int capacity) {
        int newCapacity = capacity / 4;
        T[] newData = (T[]) new Object[newCapacity * 2];
        for (int i = 0; i < newCapacity; i++) {
            newData[i] = data[i];
        }
        data = newData;
        size = newCapacity * 2;
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

    public static void main(String[] args) {
        int capacity = 2;
        GenericArray<String> array = new GenericArray<String>(capacity);
        for (int i = 0; i < 30; i++) {
            array.add(0, String.valueOf(i));
        }

        System.out.println(array.toString());

        for (int i = 0; i < 15; i++) {
            array.remove(0);
        }
        System.out.println(array.toString());
    }
}