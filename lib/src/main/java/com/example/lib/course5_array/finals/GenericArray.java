package com.example.lib.course5_array.finals;

/**
 */

public class GenericArray<T> {
    private T[] data;
    private int size;

    // ���ݴ�������������Array
    public GenericArray(int capacity) {
    }

    // �޲ι��췽����Ĭ����������Ϊ10
    public GenericArray() {
    }

    // ��ȡ��������
    public int getCapacity() {
        return 0;
    }

    // ��ȡ��ǰԪ�ظ���
    public int count() {
        return size;
    }

    // �ж������Ƿ�Ϊ��
    public boolean isEmpty() {
        return false;
    }

    // �޸� index λ�õ�Ԫ��
    public void set(int index, T e) {
    }

    // ��ȡ��Ӧ index λ�õ�Ԫ��
    public T get(int index) {
        return null;
    }

    // �鿴�����Ƿ����Ԫ��e
    public boolean contains(T e) {
        return false;
    }

    // ��ȡ��ӦԪ�ص��±�, δ�ҵ������� -1
    public int find(T e) {
        return -1;
    }


    // �� index λ�ã�����Ԫ��e, ʱ�临�Ӷ� O(m+n)
    public void add(int index, T e) {
    }

    // ������ͷ����Ԫ��
    public void addFirst(T e) {

    }

    // ������β����Ԫ��
    public void addLast(T e){
    }

    // ɾ�� index λ�õ�Ԫ�أ�������
    public T remove(int index) {

        return null;
    }

    // ɾ����һ��Ԫ��
    public T removeFirst() {
        return null;
    }

    // ɾ��ĩβԪ��
    public T removeLast() {
        return null;
    }

    // ��������ɾ��ָ��Ԫ��
    public void removeElement(T e) {
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("MyArray size = %d, capacity = %d \n", size, data.length));
        builder.append('[');
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }


    // ���ݷ�����ʱ�临�Ӷ� O(n)
    private void resize(int capacity) {
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed! Require index >=0 and index <= size.");
        }
    }

    private void checkIndexForRemove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed! Require index >=0 and index < size.");
        }
    }
}