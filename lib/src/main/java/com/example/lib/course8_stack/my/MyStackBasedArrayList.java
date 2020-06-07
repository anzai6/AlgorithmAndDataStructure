package com.example.lib.course8_stack.my;

/**
 * ��������ʵ�ֵ�ջ��˳��ջ
 */
public class MyStackBasedArrayList<T> {

    private T[] data; // �洢ջ��Ԫ�ص�����
    private int mDataSize; // ջ���������ݸ���
    private int mCapacity;// ջ������;

    public MyStackBasedArrayList(int size) {
        data = (T[]) new Object[size];
        mDataSize = 0;
        mCapacity = size;
    }

    /**
     * ��ջ
     *
     * @param t
     */
    public boolean push(T t) {
        if (mDataSize == mCapacity) // ջ��
            return false;
        data[mDataSize] = t;
        ++mDataSize;
        return true;
    }

    /**
     * ��ջ
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
