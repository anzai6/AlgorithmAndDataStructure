package com.example.lib.course6_linkedlist.finals;

import java.util.Map;

/**
 * Created by SpecialYang in 2018/12/7 2:00 PM.
 * <p>
 * ��������ʵ�ֵ�LRU����
 * 1. �ռ临�Ӷ�ΪO(n)
 * 2. ʱ�临�Ӷ�ΪO(n)
 * 3. ��֧��null�Ļ���
 */
public class LRUBasedArray<T> {

    private static final int DEFAULT_CAPACITY = (1 << 3);

    private int capacity;

    private int count;

    private T[] value;

    private Map<T, Integer> holder;

    public LRUBasedArray() {

    }

    public LRUBasedArray(int capacity) {
    }

    /**
     * ģ�����ĳ��ֵ
     *
     * @param object
     */
    public void offer(T object) {
    }

    /**
     * ����������ָ����ֵ�������λ��
     *
     * @param end
     */
    public void update(int end) {
    }

    /**
     * �������ݵ�ͷ������Ҫ������
     *
     * @param object
     * @param end    �������Ƶı߽�
     */
    public void cache(T object, int end) {
    }

    /**
     * ��������������߳����ٻ��浽����ͷ��
     *
     * @param object
     */
    public void removeAndCache(T object) {
    }

    /**
     * end��ߵ�����ͳһ����һλ
     *
     * @param end
     */
    private void rightShift(int end) {
    }

    public boolean isContain(T object) {
        return false;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean isFull() {
        return false;
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

    static class TestLRUBasedArray {

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
            System.out.println("======�޲β���========");
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
            System.out.println("======�вβ���========");
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
}
