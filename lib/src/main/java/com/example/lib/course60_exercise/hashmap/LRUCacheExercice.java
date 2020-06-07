package com.example.lib.course60_exercise.hashmap;

import java.util.HashMap;

/**
 * ʵ��һ�� LRU ������̭�㷨
 */
public class LRUCacheExercice<T> {

    private final static int DEFAUL_CAPACITY = 8; // �����Ĭ������
    private int mCapacity; // ���������
    private int size; // ɢ�б�����ݸ���
    private T[] cacheList;
    private HashMap<T, Integer> hashMap;

    public LRUCacheExercice() {
        this(DEFAUL_CAPACITY);
    }

    public LRUCacheExercice(int capacity) {
        this.mCapacity = capacity;
        cacheList = (T[]) new Object[mCapacity];
        hashMap = new HashMap();
    }

    /**
     * ����Ǩ��
     *
     * @param end
     */
    private void moveRightOne(int end) {
        if (end > 0 && end < mCapacity) {
            for (int i = end; i > 0; i--) {
                cacheList[i] = cacheList[i - 1];
                hashMap.put(cacheList[i], i);
            }
        }
    }

    /**
     * ����
     *
     * @param object
     */
    private void cache(T object) {
        moveRightOne(size);
        cacheList[0] = object;
        hashMap.put(object, 0);
        size++;
    }

    /**
     * ������������Ƴ�һλ�ٻ���
     *
     * @param object
     */
    private void removeAndCache(T object) {
        T endObj = cacheList[size - 1];
        hashMap.remove(endObj);
        moveRightOne(size);
        cacheList[0] = object;
        hashMap.put(object, 0);
    }

    /**
     * ����������ָ����ֵ�������λ��
     *
     * @param object
     */
    private void update(T object) {
        int targetIndex = hashMap.get(object);
        if (targetIndex > 0) {
            moveRightOne(targetIndex);
            cacheList[0] = object;
            hashMap.put(object, 0);
        }
    }

    /**
     * ����ʱ����
     *
     * @param object
     */
    public void offer(T object) {
        if (object == null)
            throw new IllegalArgumentException("�û���������֧��null!");

        Integer targetIndex = hashMap.get(object);
        if (targetIndex == null) {
            if (isFull()) {
                removeAndCache(object);
            } else {
                cache(object);
            }
        } else {
            update(object);
        }
    }

    public boolean isContains(T object) {
        return hashMap.containsValue(object);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == mCapacity;
    }

}
