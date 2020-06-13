package com.example.lib.course8_stack.finals;

/**
 * 基于数组实现的栈：顺序栈
 */
public class StackBasedArrayList {

    private static final int DEFAULT_CAPACITY = 8;

    private int[] array;
    private int count;
    private int len;

    public StackBasedArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public StackBasedArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity is invalid");
        }
        array = new int[capacity];
        count = 0;
        len = capacity;
    }

    public void push(int value) {
        if (count == len) {
            System.out.println("is full");
            return;
        }
        array[count] = value;
        count++;
    }

    /**
     * 我用-1表示栈中没有数据。
     */
    public int pop() {
        if (count == 0) {
            System.out.println("is empty");
            return -1;
        }
        return array[count--];
    }

    public int getSize() {
        return count;
    }

    public void clear() {
        count = 0;
    }

}
