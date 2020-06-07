package com.example.lib.course8_stack.my;

/**
 * 基于数组实现的栈：顺序栈
 */
public class MyStackBasedArrayList<T> {

    private T[] data; // 存储栈中元素的数组
    private int mDataSize; // 栈中已有数据个数
    private int mCapacity;// 栈的容量;

    public MyStackBasedArrayList(int size) {
        data = (T[]) new Object[size];
        mDataSize = 0;
        mCapacity = size;
    }

    /**
     * 入栈
     *
     * @param t
     */
    public boolean push(T t) {
        if (mDataSize == mCapacity) // 栈满
            return false;
        data[mDataSize] = t;
        ++mDataSize;
        return true;
    }

    /**
     * 出栈
     *
     * @return
     */
    public T pop() {
        if (mDataSize == 0)
            return null;
        T t = data[mDataSize - 1];
        data[mDataSize - 1] = null;
        --mDataSize;
        return t;
    }

}
