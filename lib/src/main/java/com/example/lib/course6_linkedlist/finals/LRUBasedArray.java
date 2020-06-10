package com.example.lib.course6_linkedlist.finals;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SpecialYang in 2018/12/7 2:00 PM.
 * <p>
 * 基于数组实现的LRU缓存
 * 1. 空间复杂度为O(n)
 * 2. 时间复杂度为O(n)
 * 3. 不支持null的缓存
 */
public class LRUBasedArray<T> {

    private static final int DEFAULT_CAPACITY = (1 << 3);

    private int capacity;

    private int count;

    private T[] value;

    private Map<T, Integer> holder;

    public LRUBasedArray() {
        this(DEFAULT_CAPACITY);
    }

    public LRUBasedArray(int capacity) {
        value = (T[]) new Object[capacity];
        this.capacity = capacity;
        holder = new HashMap<>();
        count = 0;
    }

    /**
     * 模拟访问某个值
     *
     * @param object
     */
    public void offer(T object) {
        if (object == null) {
            return;
        }

        if (holder.containsKey(object)) {
            update(holder.get(object));
        } else {
            if (isFull()) {
                removeAndCache(object);
            } else {
                cache(object, count);
            }
        }
    }

    /**
     * 若缓存中有指定的值，则更新该位置的值到第一位
     *
     * @param end
     */
    public void update(int end) {
        if (end >= count) {
            return;
        }
        T target = value[end];
        rightShift(end);
        value[0] = target;
        holder.put(target, 0);
    }

    /**
     * 缓存数据到头部，但要先右移
     *
     * @param object
     * @param end    数组右移的边界
     */
    public void cache(T object, int end) {
        rightShift(end);
        value[0] = object;
        holder.put(object, 0);
        count++;
    }

    /**
     * 缓存满的情况，踢出后，再缓存到数组头部
     *
     * @param object
     */
    public void removeAndCache(T object) {
        holder.remove(value[capacity - 1]);
        rightShift(capacity - 1);
        value[0] = object;
        holder.put(object, 0);
    }

    /**
     * end左边的数据统一右移一位,不包括 end
     *
     * @param end
     */
    private void rightShift(int end) {
        if (end > count || end >= capacity) {
            return;
        }
        for (int i = end; i > 0; i--) {
            value[i] = value[i - 1];
            holder.put(value[i], i);
        }
    }

    public boolean isContain(T object) {
        return holder.containsKey(object);
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return capacity == count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(value[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        testDefaultConstructor();
        testSpecifiedConstructor(4);
//            testWithException();
    }

    private static void testWithException() {
        LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
        lru.offer(null);
    }

    public static void testDefaultConstructor() {
        System.out.println("======无参测试========");
        LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
        lru.offer(1);
        lru.offer(2);
        lru.offer(3);
        lru.offer(4);
        lru.offer(5);
        System.out.println(lru);
        lru.offer(6);
        lru.offer(7);
        lru.offer(8);
        lru.offer(9);
        System.out.println(lru);
    }

    public static void testSpecifiedConstructor(int capacity) {
        System.out.println("======有参测试========");
        LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>(capacity);
        lru.offer(1);
        System.out.println(lru);
        lru.offer(2);
        System.out.println(lru);
        lru.offer(3);
        System.out.println(lru);
        lru.offer(4);
        System.out.println(lru);
        lru.offer(2);
        System.out.println(lru);
        lru.offer(4);
        System.out.println(lru);
        lru.offer(7);
        System.out.println(lru);
        lru.offer(1);
        System.out.println(lru);
        lru.offer(2);
        System.out.println(lru);
    }
}
