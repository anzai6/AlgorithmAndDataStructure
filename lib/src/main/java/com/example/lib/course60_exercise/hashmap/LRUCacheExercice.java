package com.example.lib.course60_exercise.hashmap;

import java.util.HashMap;

/**
 * 实现一个 LRU 缓存淘汰算法
 */
public class LRUCacheExercice<T> {

    private final static int DEFAUL_CAPACITY = 8; // 数组的默认容量
    private int mCapacity; // 数组的容量
    private int size; // 散列表的内容个数
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
     * 往右迁移
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
     * 缓存
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
     * 到达最大容量移除一位再缓存
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
     * 若缓存中有指定的值，则更新位置
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
     * 访问时缓存
     *
     * @param object
     */
    public void offer(T object) {
        if (object == null)
            throw new IllegalArgumentException("该缓存容器不支持null!");

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
