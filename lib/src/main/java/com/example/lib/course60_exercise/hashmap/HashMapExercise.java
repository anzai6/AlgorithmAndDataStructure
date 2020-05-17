package com.example.lib.course60_exercise.hashmap;

/**
 * ʵ��һ���������������ͻ�����ɢ�б�
 */

public class HashMapExercise<K, V> {

    /**
     * װ������
     */
    public final static double RATIO = 0.8;
    private final static int DEFAUL_CAPACITY = 64; // �����Ĭ������
    private int mCapacity; // ���������
    private int arrayCount; // ��������ݸ���;
    private int size; // ɢ�б�����ݸ���
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
        if (arrayCount == mCapacity * RATIO) { // ��Ҫ���ݣ�����û��ʵ��ֱ�ӷ�����
            return false;
        }
        int i = (mCapacity - 1) & hashCode;
//
//        if (hashCode > mCapacity - 1) // �������鳤�ȵķŵ���λ
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
//        if (hashCode > mCapacity - 1) // �������鳤�ȵķŵ���λ
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
                    if (pre != null) // ȥ�������е�P�ڵ�
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
        System.out.println(hashMapExercise.put("���","ˮ���"));
        System.out.println(hashMapExercise.put("�ŵ�","�ҷǳ�"));
        System.out.println(hashMapExercise.put("��ͯ��","ŶŶ����"));
        System.out.println(hashMapExercise.put("213","7876"));
        System.out.println(hashMapExercise.put("Hello","Yes"));
        System.out.println(hashMapExercise.put("hi","No"));


        System.out.println(hashMapExercise.get("�ǵķ�����"));
        System.out.println(hashMapExercise.get("hi"));
        System.out.println(hashMapExercise.get("Hello"));
        System.out.println(hashMapExercise.get("213"));
        System.out.println(hashMapExercise.get("��ͯ��"));
        System.out.println(hashMapExercise.get("�ŵ�"));
        System.out.println(hashMapExercise.get("���"));
    }
}
