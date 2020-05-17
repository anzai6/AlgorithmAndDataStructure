package com.example.lib.course60_exercise.hashmap;

/**
 * 实现一个基于链表法解决冲突问题的散列表
 */

public class HashMapExercise<K, V> {

    /**
     * 装载因子
     */
    public final static double RATIO = 0.8;
    private final static int DEFAUL_CAPACITY = 64; // 数组的默认容量
    private int mCapacity; // 数组的容量
    private int arrayCount; // 数组的内容个数;
    private int size; // 散列表的内容个数
    private Node[] data;

    public HashMapExercise() {
        this(DEFAUL_CAPACITY);
    }

    public HashMapExercise(int capacity) {
        mCapacity = capacity;
        data = new Node[mCapacity];
    }

    public boolean put(K key, V value) {
        int hashCode = HashMapExercise.hash(key);
        return insertArray(hashCode, new Node(key, value, null));
    }

    public boolean insertArray(int hashCode, Node node) {
        if (arrayCount == mCapacity * RATIO) { // 需要扩容，这里没有实现直接返回了
            return false;
        }
        int i = (mCapacity - 1) & hashCode;
//
//        if (hashCode > mCapacity - 1) // 超过数组长度的放到首位
//            hashCode = 0;
        Node p = data[i];
        if (p == null) {
            data[i] = node;
            arrayCount++;
        } else {
            while (p.next != null) {
                p = p.next;
            }
            p.next = node;
        }
        size++;
        return true;
    }

    public V get(K key) {
        int hashCode = HashMapExercise.hash(key);
        Node p = getValueInArray(hashCode, key);
        if (p == null)
            return null;
        return (V) p.value;
    }

    public Node getValueInArray(int hashCode, K key) {
        int i = (mCapacity - 1) & hashCode;
//        if (hashCode > mCapacity - 1) // 超过数组长度的放到首位
//            hashCode = 0;
        Node p = data[i];
        if (p != null) {
            size--;
            if (p.next == null) {
                arrayCount--;
                data[i] = null;
                return p;
            }

            Node pre = null;
            while (p != null) {
                if (key.equals(p.key)) {
                    if (pre != null) // 去掉链表中的P节点
                        pre.next = p.next;
                    return p;
                }
                pre = p;
                p = p.next;
            }
        }
        return null;
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static class Node<K, V> {
        V value;
        K key;
        Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        HashMapExercise<String,String> hashMapExercise = new HashMapExercise<>();
        System.out.println(hashMapExercise.put("你好","水电费"));
        System.out.println(hashMapExercise.put("放到","我非常"));
        System.out.println(hashMapExercise.put("儿童画","哦哦基金"));
        System.out.println(hashMapExercise.put("213","7876"));
        System.out.println(hashMapExercise.put("Hello","Yes"));
        System.out.println(hashMapExercise.put("hi","No"));


        System.out.println(hashMapExercise.get("是的发生的"));
        System.out.println(hashMapExercise.get("hi"));
        System.out.println(hashMapExercise.get("Hello"));
        System.out.println(hashMapExercise.get("213"));
        System.out.println(hashMapExercise.get("儿童画"));
        System.out.println(hashMapExercise.get("放到"));
        System.out.println(hashMapExercise.get("你好"));
    }
}
