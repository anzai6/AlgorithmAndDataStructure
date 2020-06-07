package com.example.lib.course5_array.my;

/**
 * Created by qinshunan on 2019/1/30.
 * ͨ�ö�̬��������
 */
public class MyCommonUseArray<T> {
    T[] mUseArray;
    // Ĭ�ϳ���
    static int default_length = 10;
    /**
     * �������ݵĳ���
     */
    int count;

    public MyCommonUseArray(int arrayLength) {
        mUseArray = (T[]) new Object[arrayLength];
        count = 0;
    }

    public MyCommonUseArray() {
        this(default_length);
    }

    /**
     * �����±��ѯ
     *
     * @param index
     * @return
     */
    public T find(int index) {
        if (checkIndex(index))
            return null;
        return mUseArray[index];
    }

    /**
     * ĩβ���
     *
     * @param value
     * @return
     */
    public boolean add(T value) {
        return insert(count, value);
    }

    /**
     * �����±����
     *
     * @param index
     * @param value
     * @return
     */
    public boolean insert(int index, T value) {
        if (checkIndexNoEqual(index))
            return false;
        if (count == mUseArray.length) // ��������������һ��
            resetSize(count * 2);

        for (int i = count; i > index; i--) {
            mUseArray[i] = mUseArray[i - 1];
        }
        mUseArray[index] = value;
        ++count;
        return true;
    }

    public boolean delete(int index) {
        if (checkIndex(index))
            return false;
        for (int i = index; i < count - 1; i++) {
            mUseArray[i] = mUseArray[i + 1];
        }
        --count;

        if (count * 4 <= mUseArray.length)//4�����ݵ�����
            resetSize(count * 2);
        return true;
    }

    public void resetSize(int length) {
        T[] newUseArray = (T[]) new Object[length];

        for (int i = 0; i < mUseArray.length; i++) {
            newUseArray[i] = mUseArray[i];
        }
        mUseArray = newUseArray;
    }

    /**
     * @param index
     * @return ����true������
     */
    public boolean checkIndex(int index) {
        if (index < 0 || index >= count)
            return true;
        else return false;
    }

    /**
     * @param index
     * @return ����true������
     */
    public boolean checkIndexNoEqual(int index) {
        if (index < 0 || index > count)
            return true;
        else return false;
    }

    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(mUseArray[i] + " ");
        }
        System.out.println();
    }

}
