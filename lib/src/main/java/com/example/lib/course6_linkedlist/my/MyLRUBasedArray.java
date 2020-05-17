package com.example.lib.course6_linkedlist.my;

import com.example.lib.course6_linkedlist.teacher.LRUBasedArray;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qinshunan on 2019/2/12.
 * 基于数组实现的LRU缓存
 */
public class MyLRUBasedArray<T> {

    private final static int DEFAULT_CAPACITY = 8;

    private int capacity;
    private int count;

    private T[] value;

    private Map<T, Integer> holder;

    public MyLRUBasedArray() {
        this(DEFAULT_CAPACITY);
    }

    public MyLRUBasedArray(int capacity) {
        value = (T[]) new Object[capacity];
        this.capacity = capacity;
        count = 0;
        holder = new HashMap<>(capacity);
    }

    /**
     * 往右迁移
     *
     * @param end
     */
    private void moveRightOne(int end) {
        if (end > 0 && end < capacity) {
            for (int i = end; i > 0; i--) {
                value[i] = value[i - 1];
                holder.put(value[i], i);
            }
        }
    }

    /**
     * 缓存
     *
     * @param object
     */
    private void cache(T object) {
        moveRightOne(count);
        value[0] = object;
        holder.put(object, 0);
        count++;
    }

    /**
     * 到达最大容量移除一位再缓存
     *
     * @param object
     */
    private void removeAndCache(T object) {
        T endObj = value[count - 1];
        holder.remove(endObj);
        moveRightOne(count - 1);
        value[0] = object;
        holder.put(object, 0);
    }

    /**
     * 若缓存中有指定的值，则更新位置
     *
     * @param object
     */
    private void update(T object) {
        int targetIndex = holder.get(object);
        if (targetIndex > 0) {
            moveRightOne(targetIndex);
            value[0] = object;
            holder.put(object, 0);
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

        Integer targetIndex = holder.get(object);
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
        return holder.containsValue(object);
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
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

    static class TestMyLRUBasedArray {

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
            MyLRUBasedArray<Integer> lru = new MyLRUBasedArray<Integer>();
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
            MyLRUBasedArray<Integer> lru = new MyLRUBasedArray<Integer>(capacity);
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

}
