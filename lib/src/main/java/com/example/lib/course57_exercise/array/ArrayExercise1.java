package com.example.lib.course57_exercise.array;

/**
 * ʵ��һ��֧�ֶ�̬���ݵ�����
 */
public class ArrayExercise1<T> {

    private static final int CAPACITY = 16; // Ĭ�ϳ���
    int size; // ���鳤��
    T[] list;  // ����
    int count; // �������ݳ���

    public ArrayExercise1() {
        this(CAPACITY);
    }

    public ArrayExercise1(int capacity) {
        size = capacity;
        count = 0;
        list = (T[]) new Object[size];
    }

    public boolean add(T obj) {
        return add(count, obj);
    }

    public boolean add(int position, T obj) {
        if (position > count || position < 0)
            return false;
        if (count == size) { // ����,�Զ�����
            autoExpandOrCompress();
        }

        // �ƶ�����
        for (int i = count - 1; i >= position; i--) {
            list[i + 1] = list[i];
        }
        list[position] = obj; // ��ֵ
        ++count;
        return true;
    }

    public int remove(T obj) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (list[i] == obj) {
                index = i;
                break;
            }
        }

        // �ƶ�����
        for (int i = index; i < count - 1; i++) {
            list[i] = list[i + 1];
        }
        list[count - 1] = null; // �ǵ����
        count--;

        if (count == size / 4) { // �Զ�ѹ��
            autoExpandOrCompress();
        }
        return index;
    }

    public T remove(int position) {
        T obj = null;
        if (position < count && position >= 0) {
            obj = list[position];
            // �ƶ�����
            for (int i = position; i < count - 1; i++) {
                list[i] = list[i + 1];
            }
            list[count - 1] = null; // �ǵ����
            count--;

            if (count == size / 4) { // �Զ�ѹ��
                autoExpandOrCompress();
            }
        }

        return obj;
    }

    /**
     * �Զ����ݻ���ѹ��
     */
    private void autoExpandOrCompress() {
        if (count == 0)
            return;
        size = count * 2;
        size = size < 8 ? 8 : size;// �޶���С����8�ˣ���Сû����
        T[] newList = (T[]) new Object[size];
        copyArray(list, count, newList); // ��������
        list = newList;
    }


    /**
     * ��������
     *
     * @param copyList
     * @param copyLength
     * @param resultList
     */
    private void copyArray(T[] copyList, int copyLength, T[] resultList) {
        if (copyList == null || resultList == null)
            return;
        if (copyList.length < copyLength || resultList.length < copyLength)
            return;
        for (int i = 0; i < copyLength; i++) {
            resultList[i] = copyList[i];
        }
    }


    public int getSize() {
        return count;
    }

    public T get(int position) {
        T obj = null;
        if (position < count && position >= 0) {
            obj = list[position];
        }
        return obj;
    }

    public boolean contains(T e) {
        for (int i = 0; i < count; i++) {
            if (list[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > count) {
            throw new IllegalArgumentException("Add failed! Require index >=0 and index <= count.");
        }
    }


    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.print(" " + list[i]);
        }
        System.out.println();
        System.out.println("���鳤�ȣ� " + size + " -- ���ݳ��ȣ�" + count);
    }

    public static void main(String[] args) {
        ArrayExercise1<Integer> array = new ArrayExercise1<>(2);

        for (int i = 0; i < 10; i++) {
            array.add(i);
        }

        for (int i = 0; i < 10; i++) {
            array.remove(0);
            array.print();
        }
    }
}
