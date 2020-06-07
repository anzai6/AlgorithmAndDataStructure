package com.example.lib.course5_array.finals;

/**
 * ͨ�ö�̬��������
 */
public class GenericArray<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private T[] data;
    private int size;
    private int count;

    // �޲ι��췽����Ĭ����������Ϊ10
    public GenericArray() {
        this(DEFAULT_CAPACITY);
    }

    // ���ݴ�������������Array
    public GenericArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity is invalid");
        }
        data = (T[]) new Object[capacity];
        size = capacity;
        count = 0;
    }

    // ��ȡ��������
    public int getCapacity() {
        return size;
    }

    // ��ȡ��ǰԪ�ظ���
    public int count() {
        return count;
    }

    // �ж������Ƿ�Ϊ��
    public boolean isEmpty() {
        return count == 0;
    }

    // �޸� index λ�õ�Ԫ��
    public void set(int index, T e) {
        if (index < 0 || index > count) {
            System.out.println("index invalid");
            return;
        }
        data[index] = e;
    }

    // ��ȡ��Ӧ index λ�õ�Ԫ��
    public T get(int index) {
        if (index < 0 || index >= count) {
            System.out.println("index invalid");
            return null;
        }
        return data[index];
    }

    // �鿴�����Ƿ����Ԫ��e
    public boolean contains(T e) {
        if (isEmpty()) {
            return false;
        }
        for (int i = 0; i < count; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // ��ȡ��ӦԪ�ص��±�, δ�ҵ������� -1
    public int find(T e) {
        if (isEmpty()) {
            return -1;
        }
        for (int i = 0; i < count; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // �� index λ�ã�����Ԫ��e, ʱ�临�Ӷ� O(m+n)
    public void add(int index, T e) {
        if (index < 0 || index > count) {
            System.out.println("index invalid");
            return;
        }
        // ��������������
        if (count == size) {
            resize(count);
        }
        // ����
        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        count++;
    }

    // ������ͷ����Ԫ��
    public void addFirst(T e) {
        add(0, e);
    }

    // ������β����Ԫ��
    public void addLast(T e) {
        add(count, e);
    }

    // ɾ�� index λ�õ�Ԫ�أ�������
    public T remove(int index) {
        if (index < 0 || index > count - 1) {
            System.out.println("index invalid");
            return null;
        }

        // ����տ�
        if (isEmpty()) {
            return null;
        }
        T e = data[index];
        // ��������
        for (int i = index; i < count - 1; i++) {
            data[i] = data[i + 1];
        }
        count--;

        // ����
        if (size / 4 == count) {
            reduceSize(size);
        }
        return e;
    }

    // ɾ����һ��Ԫ��
    public T removeFirst() {
        return remove(0);
    }

    // ɾ��ĩβԪ��
    public T removeLast() {
        return remove(count - 1);
    }

    // ��������ɾ��ָ��Ԫ��
    public void removeElement(T e) {
        if (isEmpty()) {
            return;
        }
        for (int i = 0; i < count; i++) {
            if (data[i] == e) {
                remove(i);
                return;
            }
        }
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
        int newCapacity = capacity * 2;
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < capacity; i++) {
            newData[i] = data[i];
        }
        data = newData;
        size = newCapacity;
    }

    // ���ݷ�����ʱ�临�Ӷ� O(n)
    private void reduceSize(int capacity) {
        int newCapacity = capacity / 4;
        T[] newData = (T[]) new Object[newCapacity * 2];
        for (int i = 0; i < newCapacity; i++) {
            newData[i] = data[i];
        }
        data = newData;
        size = newCapacity * 2;
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

    public static void main(String[] args) {
        int capacity = 2;
        GenericArray<String> array = new GenericArray<String>(capacity);
        for (int i = 0; i < 30; i++) {
            array.add(0, String.valueOf(i));
        }

        System.out.println(array.toString());

        for (int i = 0; i < 15; i++) {
            array.remove(0);
        }
        System.out.println(array.toString());
    }
}