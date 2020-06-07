package com.example.lib.course28_heap.my;

/**
 * �ѣ���ȫ�������������롢ɾ���������򡢴��ϵ��¶ѻ������µ��϶ѻ����󶥶ѡ�С����
 * ����Ĭ��ʹ�ô󶥶ѣ�����ĳ���ڵ�һ�����ڻ�����������ӽڵ�
 * ���ڵ��1��ʼ����
 * Created by qinshunan on 2019/4/9.
 */

public class MyHeap {

    // ������
    private int[] data; // ������±�1��ʼ�洢����
    // Ĭ������
    private static final int DEFAULT_CAPACITY = 12;
    // ���ݳ���
    int count = 0;
    // ���鳤��
    int n;

    public MyHeap() {
        this(DEFAULT_CAPACITY);
    }

    public MyHeap(int capacity) {
        data = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    /**
     * ����һ���ڵ㣺��������β����Ȼ����µ��϶ѻ�
     *
     * @param item ��Ҫ���������
     */
    public void insert(int item) {
        if (count >= n) // ��������
            return;
        ++count;
        data[count] = item;
        fromDownToUpHeapUp(count);
    }

    /**
     * ɾ��ĳ���ڵ��˼·�������һ���ڵ㽻��λ�ã�ɾ�����һ���ڵ㣬Ȼ��Ըýڵ���д��ϵ��µĶѻ�
     *
     * @param index ɾ���ڵ���±�
     */
    public void delete(int index) {
        if (count <= 0 || index <= 0) // �����ѿջ�ɾ����Ԫ�ز�����
            return;
        // ��ɾ���ڵ�����һ���ڵ㽻������
        if (index != count) {
            data[index] = data[count];
            fromUpToDownHeapUp(index);
        }
        --count;
    }

    /**
     * ���ϵ��¶ѻ�:���θ��ӽڵ�ȽϽ���λ�ã�ֱ�����϶ѽṹ
     *
     * @param index ���ѻ��Ľڵ��±�
     */
    public void fromUpToDownHeapUp(int index) {
        // count/2֮��Ľڵ㶼��Ҷ�ӽڵ㣨���һ���ڵ���count�����ĸ��ڵ���count/2,���ԣ�
        while (index >= 1) {
            int leftChild = index * 2;
            int rightChild = index * 2 + 1;
            int maxP = index;// �����ڵ���������һ��
            // �ر�ע�⣬�����leftChild��rightChild����Խ����count������Ҫ��һ���ж�
            if (leftChild <= count && data[maxP] < data[leftChild])
                maxP = leftChild;
            if (rightChild <= count && data[maxP] < data[rightChild])
                maxP = rightChild;

            // ���ֵ����������Ҫ�ѻ���
            if (maxP == index) {
                return;
            } else {
                swap(data, maxP, index);
                index = maxP;
            }
        }
    }

    /**
     * ���µ��϶ѻ�:���θ����ڵ�ȽϽ���λ�ã�ֱ�����϶ѽṹ
     *
     * @param index ���ѻ��Ľڵ��±�
     */
    public void fromDownToUpHeapUp(int index) {
        if (index <= 1) return; // 1�Ǹ��ڵ�
        // ���ڵ��±�
        int p = index / 2;
        while (index > 1 && data[index] > data[p]) {
            // �����򽻻����ӽڵ�
            swap(data, index, p);

            index = p;
            p = index / 2;
        }
    }

    /**
     * ��������
     *
     * @param list
     * @param i
     * @param p
     */
    private void swap(int[] list, int i, int p) {
        int item = list[p];
        list[p] = list[i];
        list[i] = item;
    }

}
