package com.example.lib.course61_exercise.heap;

/**
 * �󶥶�:�±��1��ʼ���ӽڵ��±����2�Ǹ��ڵ㣬���ڵ��2�����ӽڵ㣨�����Լ�1��
 */
public class BigTopHeapExercise {

    private static final int DEFAULT_CAPACITY = 16;
    private int[] data; // �±��1��ʼ���ӽڵ�
    private int mCapacity; // ����
    private int size; // ���ݳ���

    public BigTopHeapExercise() {
        this(DEFAULT_CAPACITY);
    }

    public BigTopHeapExercise(int capacity) {
        mCapacity = capacity;
        data = new int[mCapacity + 1]; // ��Ϊ��1��ʼ�����±꣬����Ҫ��1
        size = 0;
    }

    /**
     * ����
     *
     * @param value �����ֵ
     * @return ������±�, ���ɹ�����0
     */
    public int insert(int value) {
        if (mCapacity <= size) // ��������
            return 0;
        size++;
        data[size] = value;
        fromDownToUpHeapUp(size);
        return size;
    }

    /**
     * ɾ��
     *
     * @param index ɾ����ֵ���±�
     * @return �ɹ����
     */
    public boolean delete(int index) {
        if (size == 0 || index < 1 || index > size)
            return false;

        // ��ɾ���ڵ�����һ���ڵ㽻������
        if (index != size) {
            data[index] = data[size];
            fromUpToDownHeapUp(index);
        }
        data[size] = 0;
        size--;
        return true;
    }

    /**
     * ���ϵ��¶ѻ�:���θ��ӽڵ�ȽϽ���λ�ã�ֱ�����϶ѽṹ
     *
     * @param index ���ѻ��Ľڵ��±�
     */
    private void fromUpToDownHeapUp(int index) {
        if (index < 1)
            return;
        while (index <= size) {
            int leftSup = index * 2; // ���ӽڵ�
            int rightSup = leftSup + 1; // ���ӽڵ�
            int maxIndex = index;
            if (leftSup <= size && data[leftSup] > data[maxIndex])
                maxIndex = leftSup;
            if (leftSup <= size && data[rightSup] > data[maxIndex])
                maxIndex = rightSup;

            if (maxIndex == index) { // ���öѻ���
                return;
            } else {
                swap(index, maxIndex);
                index = maxIndex;
            }
        }
    }

    /**
     * ���µ��϶ѻ�:���θ����ڵ�ȽϽ���λ�ã�ֱ�����϶ѽṹ
     *
     * @param index ���ѻ��Ľڵ��±�
     */
    private void fromDownToUpHeapUp(int index) {
        if (index > size)
            return;
        while (index > 1) {
            int fIndex = index / 2; // ���ڵ�
            if (data[index] > data[fIndex])
                swap(index, fIndex);
            index = fIndex;
        }
    }

    /**
     * ���������±������
     *
     * @param index1
     * @param index2
     */
    private void swap(int index1, int index2) {
        int item = data[index1];
        data[index1] = data[index2];
        data[index2] = item;
    }
}
