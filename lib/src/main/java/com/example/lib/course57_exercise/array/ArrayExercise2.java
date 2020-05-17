package com.example.lib.course57_exercise.array;

/**
 * ʵ��һ����С�̶����������飬֧�ֶ�̬��ɾ�Ĳ���
 */
public class ArrayExercise2 {

    private static final int CAPACITY = 10; // Ĭ�ϳ���
    int[] list;  // ����
    int count; // �������ݳ���


    public ArrayExercise2() {
        count = 0;
        list = new int[CAPACITY];
    }

    /**
     * ��
     *
     * @param obj
     * @return
     */
    public boolean add(int obj) {
        if (CAPACITY == count)
            return false;

        int position = binarySearch(obj);
        // �ƶ�����
        for (int i = count - 1; i >= position; i--) {
            list[i + 1] = list[i];
        }
        list[position] = obj; // ��ֵ
        ++count;
        return true;
    }

    /**
     * ɾ
     *
     * @param obj
     * @return
     */
    public int remove(int obj) {
        if (count == 0)
            return -1;

        int position = binarySearch(obj);

        if (position < count && list[position] == obj) {
            // �ƶ�����
            for (int i = position; i < count - 1; i++) {
                list[i] = list[i + 1];
            }
            count--;
            return position;
        } else
            return -1;
    }

    /**
     * ��
     */
    public boolean update(int oldObj, int newObj) {
        int position = remove(oldObj);

        if (position >= 0) {
            return add(newObj);
        } else
            return false;
    }

    /**
     * �����������н��ж��ֲ��ң��������obj�ͷ��ض�Ӧ���±꣬�����ھͷ�����Ҫ������±�λ��
     * ���ֲ�������Ҫ����Ҫע��������ȵ����
     *
     * @param obj
     * @return
     */
    private int binarySearch(int obj) {
        if (count == 0)
            return 0;

        int low = 0;
        int high = count - 1;
        int center = (low + high) / 2;

        if (obj <= list[0]) { // �жϵ�һ�������Ż���ֹ�������Ҫ��ͣ�����������ƶ�
            return 0;
        }

        if (list[count - 1] <= obj) { // �ж����һ�������Ż���ֹ�������Ҫ��ͣ�����������ƶ�
            return count;
        }

        if (count == 2) // ����Ϊ2��ʱ��ǰ�������Ѿ��ж��˲���0��2�����������ֻʣ1��
            return 1;

        low = 1;
        high = count - 2;

        while (low < high) {
            if (list[center] < obj) { // obj��������
                low = center + 1;
            } else if (list[center] > obj) { // obj��������
                high = center - 1;
            } else { // ���
                return center;
            }
            center = (low + high) / 2;
        }

        // ������low=high=center�����

        // ���￪ʼ����һ�����󣬺�����������ȵ����������77���ж�7<8 ֮��ֱ�Ӳ��룬�ͻᵼ�²�����787����������
        if (list[center] < obj) { // obj��������
            // ȥ����������ȵ�ֵ
            while (center < count - 1 && list[center + 1] == list[center]) {
                ++center;
            }
            ++center;
        } else if (list[center] > obj) { // obj��������,�����俪ʼҲ����һ������һ��ʼ����--center;����ʵ�������䲻�ü�һ��
            // ȥ����������ȵ�ֵ
            while (center > 0 && list[center - 1] == list[center]) {
                --center;
            }
//            --center  ����Ҫ����ע�����
        }

        return center < 0 ? 0 : center; // ����λ��
    }

    public int getSize() {
        return count;
    }

    public int get(int position) {
        int obj = -1;
        if (position < count) {
            obj = list[position];
        }
        return obj;
    }


    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.print(" " + list[i]);
        }
        System.out.println();
        System.out.println("���鳤�ȣ� " + count);
    }

    public static void main(String[] args) {
        ArrayExercise2 array = new ArrayExercise2();

        for (int i = 0; i < 11; i++) {
            array.add((int) (Math.random() * 20));
        }

        array.print();

        for (int i = 0; i < 10; i++) {
            array.update((int) (Math.random() * 20), (int) (Math.random() * 20));
        }

        array.print();

        for (int i = 0; i < 10; i++) {
            array.remove((int) (Math.random() * 20));
        }
        array.print();
//
    }
}
