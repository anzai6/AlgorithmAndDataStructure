package com.example.lib.course58_exercise.stack;

/**
 * ������ʵ��һ��˳��ջ
 */
public class ArrayStackExercise {

    private final static int CAPACITY = 16;
    Object[] data;
    int size; // ջ�����ݳ���
    int mCapacity; // ���鳤��

    public ArrayStackExercise() {
        this(CAPACITY);
    }

    public ArrayStackExercise(int capacity) {
        mCapacity = capacity;
        data = new Object[mCapacity];
        size = 0;
    }

    /**
     * ��ջ
     *
     * @param obj
     * @return
     */
    public boolean push(Object obj) {
        if (obj == null)
            return false;
        if (size == mCapacity) // ջ��
            return false;

        data[size] = obj;
        size++;
        return true;
    }

    /**
     * ��ջջ
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
