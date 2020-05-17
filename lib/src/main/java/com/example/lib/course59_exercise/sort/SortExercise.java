package com.example.lib.course59_exercise.sort;

/**
 * ��������ļ�����֪�ػ�Ĵ���ʵ��
 * ð�ݣ����룬ѡ�񣬿��٣��鲢
 */

public class SortExercise {

    /**
     * ð������O(n^2),ԭ�������ȶ�����
     *
     * @param data
     * @return
     */
    public int[] bubbleSort(int[] data) {
        if (data == null || data.length == 0 || data.length == 1) {
            return data;
        }

        int n = data.length;
        for (int i = 0; i < n; i++) {
            boolean noTransFlag = false; // �ж���һ���Ƿ��н���
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j] > data[j + 1]) { // ð�ݽ���
                    int value = data[j + 1];
                    data[j + 1] = data[j];
                    data[j] = value;
                    noTransFlag = true;
                }
            }
            // ���û�з�������֤���Ѿ�������ˣ����涼������ѭ����
            if (!noTransFlag)
                break;
        }

        return data;
    }

    /**
     * ��������O(n^2),ԭ�������ȶ�����
     *
     * @param data
     * @return
     */
    public int[] insertSort(int[] data) {
        if (data == null || data.length == 0 || data.length == 1) {
            return data;
        }

        int n = data.length;
        for (int i = 1; i < n; i++) {
            int value = data[i];
            for (int j = i - 1; j >= 0; j--) {
                if (data[j] > value) { // �ƶ�
                    data[j + 1] = data[j];
                    data[j] = value; // ����
                } else
                    break;
            }
        }

        return data;
    }

    /**
     * ѡ������O(n^2),ԭ�����򣬲��ȶ�����
     *
     * @param data
     * @return
     */
    public int[] selectSort(int[] data) {
        if (data == null || data.length == 0 || data.length == 1) {
            return data;
        }

        int n = data.length;
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (data[j] > data[i]) { // ѡ�񲢽���
                    int value = data[i];
                    data[i] = data[j];
                    data[j] = value;
                }
            }
        }

        return data;
    }

    /**
     * ��������O(nlogn),ԭ�����򣬲��ȶ�����
     * ���д��������û֮ǰ�ĺã�֮ǰ��MyQuickSort
     *
     * @param data
     * @return
     */
    public int[] quickSort(int[] data) {
        if (data == null || data.length == 0 || data.length == 1) {
            return data;
        }
        quickSortInternally(data, 0, data.length - 1);
        return data;
    }

    public void quickSortInternally(int[] data, int low, int high) {
        if (low >= high) {
            return;
        }
        // �ҳ�ѡ��������
        int middle = getQuickSortMiddle(data, low, high);
        quickSortInternally(data, low, middle - 1);
        quickSortInternally(data, middle + 1, high);
    }

    public int getQuickSortMiddle(int[] data, int low, int high) {
        if (low >= high) {
            return low;
        }

        int selectValue = data[high]; // �����һ����Ϊѡ��㣬��ʵ����������ѡ
        int m = low;
        for (int i = low; i < high; i++) {
            if (data[i] < selectValue) {
                if (i == m) {
                    m++;
                } else {
                    int value = data[m];
                    data[m] = data[i];
                    data[i] = value;
                    m++;
                }
            }
        }
        data[high] = data[m];
        data[m] = selectValue;
        return m;
    }

    /**
     * �鲢����O(nlogn),�ȶ�����,��ԭ�����򣬿ռ临�Ӷ���O(n)
     * ���Բο�MyMergeSort
     *
     * @param data
     * @return
     */
    public int[] mergeSort(int[] data) {
        if (data == null || data.length == 0 || data.length == 1) {
            return data;
        }
        data = mergeSortInternally(data, 0, data.length - 1);
        return data;
    }

    private int[] mergeSortInternally(int[] data, int low, int high) {
        if (low > high)
            return null;
        if (low == high)
            return new int[]{data[low]};
        int center = (low + high) / 2;
        int[] leftList = mergeSortInternally(data, low, center);
        int[] rightList = mergeSortInternally(data, center + 1, high);
        return mergeArray(leftList, rightList);
    }

    /**
     * ������������ϲ�
     *
     * @param list1
     * @param list2
     */
    private int[] mergeArray(int[] list1, int[] list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        int len1 = list1.length;
        int len2 = list2.length;
        int[] list3 = new int[len1 + len2];

        int indexLen1 = 0;
        int indexLen2 = 0;
        int index = 0;

        // ����
        while (indexLen1 < len1 && indexLen2 < len2) {
            if (list1[indexLen1] < list2[indexLen2]) {
                list3[index] = list1[indexLen1];
                indexLen1++;
            } else {
                list3[index] = list2[indexLen2];
                indexLen2++;
            }
            index++;
        }

        if (indexLen1 == len1) { // list1 �Ѿ���������
            for (int i = indexLen2; i < len2; i++, index++) {
                list3[index] = list2[i];
            }
        } else { // list2 �Ѿ���������
            for (int i = indexLen1; i < len1; i++, index++) {
                list3[index] = list1[i];
            }
        }

        return list3;
    }

    /**
     * ���ʵ�� O(n) ʱ�临�Ӷ����ҵ�һ�����ݵĵ� K ��Ԫ��
     *
     * @param data
     * @param k
     * @return
     */
    public int findIndexNum(int[] data, int k) {
        if (data == null || data.length == 0 || k > data.length) {
            return -1;
        }

        int low = 0;
        int high = data.length - 1;
        int index = high + 1 - k; // �� K ��Ԫ�ص��±�
        // �ҳ�ѡ��������
        int middle = getQuickSortMiddle(data, low, high);
        while (middle != index) {
            if (middle > index) { // ������
                high = middle - 1;
            } else { // ������
                low = middle + 1;
            }
            middle = getQuickSortMiddle(data, low, high);
        }
        return data[index];
    }

    public void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(" " + data[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SortExercise sortExercise = new SortExercise();
        int n = 10;
//        int[] data = new int[]{2 ,1 ,1 ,1};
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = (int) (Math.random() * n);
        }
        sortExercise.print(data);
//        System.out.println("ð������");
//        sortExercise.print(sortExercise.bubbleSort(data));
//        System.out.println("��������");
//        sortExercise.print(sortExercise.insertSort(data));
//        System.out.println("ѡ������");
//        sortExercise.print(sortExercise.selectSort(data));
//        System.out.println("��������");
//        sortExercise.print(sortExercise.quickSort(data));
//        System.out.println("�鲢����");
//        sortExercise.print(sortExercise.mergeSort(data));
//        System.out.println("��3����");
//        System.out.println(sortExercise.findIndexNum(data, 3) + "");
        System.out.println("�鲢����");
        sortExercise.print(sortExercise.mergeSort(data));
    }

}
