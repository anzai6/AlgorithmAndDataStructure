package com.example.lib.course5_array.finals;

/**
 * 1) ����Ĳ��롢ɾ���������±�������ʲ�����
 * 2�������е�������int���͵ģ�
 */
public class Array {
    //������������data��������
    public int data[];
    //�������鳤��
    private int n;
    //������ʵ�ʸ���
    private int count;

    //���췽�������������С
    public Array(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity need to big than zero");
        }
        data = new int[capacity];
        n = capacity;
        count = 0;
    }

    //�����������ҵ������е�Ԫ�ز�����
    public int find(int index) {
        if (index < 0 || index > count - 1) {
            return -1;
        }
        return data[index];
    }

    //����Ԫ��:ͷ�����룬β������
    public boolean insert(int index, int value) {
        if (index < 0 || index > count) {
            return false;
        }
        // ��������
        if (count == n) {
            return false;
        }
        // ����
        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        count++;
        return true;
    }

    //����������ɾ��������Ԫ��
    public boolean delete(int index) {
        if (index < 0 || index > count - 1) {
            return false;
        }

        // ����տ�
        if (count == 0) {
            return false;
        }
        // ��������
        for (int i = index; i < count - 1; i++) {
            data[i] = data[i + 1];
        }
        count--;
        return true;
    }

    public static void main(String[] args) {
        int capacity = 6;
        Array array = new Array(capacity);
        for (int i = 0; i < capacity; i++) {
            array.insert(0, i);
        }
        array.delete(0);
        array.printAll();
    }

    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }


}