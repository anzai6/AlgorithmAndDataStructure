package com.example.lib.course28_heap.finals;

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
        n = capacity;
        data = new int[n + 1];
        count = 0;
    }

    /**
     * ����һ���ڵ㣺��������β����Ȼ����µ��϶ѻ�
     *
     * @param item ��Ҫ���������
     */
    public void insert(int item) {
        // ����
        if (count == n) {
            return;
        }
        data[++count] = item;
        fromDownToUpHeapUp(count);
    }

    /**
     * ɾ��ĳ���ڵ��˼·�������һ���ڵ㽻��λ�ã�ɾ�����һ���ڵ㣬Ȼ��Ըýڵ���д��ϵ��µĶѻ�
     *
     * @param index ɾ���ڵ���±�
     */
    public void delete(int index) {
        if (index < 1 || index > count) {
            return;
        }
        // �����һ������������indexλ�õ�ֵ��Ȼ�����϶��¶ѻ�
        data[index] = data[count];
        count--;
        fromUpToDownHeapUp(index);
    }

    /**
     * ������ѣ��󶥶�Ҳ����ȡ�����ֵ
     */
    public int pop() {
        int max = data[1];
        // �����һ�������������һ����Ȼ�����϶��¶ѻ�
        delete(1);
        return max;
    }

    /**
     * ���ϵ��¶ѻ�:���θ��ӽڵ�ȽϽ���λ�ã�ֱ�����϶ѽṹ
     *
     * @param index ���ѻ��Ľڵ��±�
     */
    public void fromUpToDownHeapUp(int index) {
        if (index < 1) {
            return;
        }
        // ���ӽڵ������²�ѭ��
        while (index * 2 <= count) {
            int leftSub = index * 2; // ���ӽڵ�
            int rightSub = index * 2 + 1; // ���ӽڵ�
            int maxSub = leftSub; // ���ֵ���ӽڵ�����
            // �����ӽڵ��ұ����ӽڵ��
            if (rightSub <= count && data[rightSub] > data[leftSub]) {
                maxSub = rightSub;
            }
            // ����ӽڵ������������Ҫ���¶ѻ�
            if (data[maxSub] > data[index]) {
                swap(data, maxSub, index);
                index = maxSub;
            } else { // �ѻ�����
                return;
            }
        }
    }

    /**
     * ���ϵ��¶ѻ�(�ݹ�д��)
     *
     * @param index ���ѻ��Ľڵ��±�
     */
    public void fromUpToDownHeapUpDG(int index) {
        if (index < 1 || index * 2 > count) {
            return;
        }
        int leftSub = index * 2; // ���ӽڵ�
        int rightSub = index * 2 + 1; // ���ӽڵ�
        int maxSub = leftSub; // ���ֵ���ӽڵ�����
        // �����ӽڵ��ұ����ӽڵ��
        if (rightSub <= count && data[rightSub] > data[leftSub]) {
            maxSub = rightSub;
        }
        // ����ӽڵ������������Ҫ���¶ѻ�
        if (data[maxSub] > data[index]) {
            swap(data, maxSub, index);
            fromUpToDownHeapUp(maxSub);
        }
    }

    /**
     * ���µ��϶ѻ����ǵݹ�д����
     * ���θ����ڵ�ȽϽ���λ�ã�ֱ�����϶ѽṹ
     *
     * @param index ���ѻ��Ľڵ��±�
     */
    public void fromDownToUpHeapUp(int index) {
        if (index > count || index <= 1) {
            return;
        }
        int parentIndex = index / 2;
        // ���ڵ������������Ҫ���϶ѻ�
        while (parentIndex >= 1 && data[parentIndex] < data[index]) {
            swap(data, parentIndex, index);
            index = parentIndex;
            parentIndex = index / 2;
        }
    }

    /**
     * ���µ��϶ѻ��ĵݹ�д��
     *
     * @param index ���ѻ��Ľڵ��±�
     */
    public void fromDownToUpHeapUpDG(int index) {
        int parentIndex = index / 2;
        if (parentIndex < 1 || index > count) {
            return;
        }
        // ���ڵ������������Ҫ���϶ѻ�
        if (data[parentIndex] < data[index]) {
            swap(data, parentIndex, index);
            fromDownToUpHeapUpDG(parentIndex);
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
