package com.example.lib.course58_exercise.stack;

/**
 * 用数组实现一个顺序栈
 */
public class ArrayStackExercise {

    private final static int CAPACITY = 16;
    Object[] data;
    int size; // 栈内内容长度
    int mCapacity; // 数组长度

    public ArrayStackExercise() {
        this(CAPACITY);
    }

    public ArrayStackExercise(int capacity) {
        mCapacity = capacity;
        data = new Object[mCapacity];
        size = 0;
    }

    /**
     * 入栈
     *
     * @param obj
     * @return
     */
    public boolean push(Object obj) {
        if (obj == null)
            return false;
        if (size == mCapacity) // 栈满
            return false;

        data[size] = obj;
        size++;
        return true;
    }

    /**
     * 出栈栈
     *
     * @return
     */
    public Object pop() {
        if (size == 0)
            return null;

        Object obj = data[size - 1];
        data[size - 1] = null;
        size--;
        return obj;
    }

}
