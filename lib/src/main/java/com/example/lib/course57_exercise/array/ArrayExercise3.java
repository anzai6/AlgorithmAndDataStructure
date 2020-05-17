package com.example.lib.course57_exercise.array;

/**
 * ʵ��������������ϲ�Ϊһ����������
 */
public class ArrayExercise3 {


    public ArrayExercise3() {
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

        /*// �Ż�1���Ƚϵ�һ���ֶΣ�list1�����С�ʹ�1��ʼ����������飬�ҵ����б�list2[0]С���ֶ�ֱ�Ӽ�list3
        if (list1[0] < list2[0]) {
            list3[0] = list1[0];
            index++;
            // ���� list1 ������߱� list2 ��һ���ֶ�С�������ֶ�
            for (; index < len1; index++) {
                if (list1[index] < list2[0]) {
                    list3[index] = list1[index];
                } else
                    break;
            }
            indexLen1 = index;
        } else { // list2 �����Сͬ��
            list3[0] = list2[0];
            index++;
            // ���� list2 ������߱� list1 ��һ���ֶ�С�������ֶ�
            for (; index < len2; index++) {
                if (list2[index] < list1[0]) {
                    list3[index] = list2[index];
                } else
                    break;
            }
            indexLen2 = index;
        }
        // ��������Ż�ʡȥ��ǰ���Ѿ��ź�������飬ʡ�û���Ҫ����ȥ�Ƚ�*/
        // ����Ż�����ûɶ�ã�JDK��������ַ�ʽ������ͬһ�������µĺϲ����Ƚ��ʺ�

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
                list3[index] = list2[indexLen2];
            }
        } else { // list2 �Ѿ���������
            for (int i = indexLen1; i < len1; i++, index++) {
                list3[index] = list1[indexLen1];
            }
        }

        return list3;
    }


    public static void main(String[] args) {
        int[] list1 = new int[]{1, 2, 3, 5, 7, 9};
        int[] list2 = new int[]{4, 6, 8, 10};
        ArrayExercise3 array = new ArrayExercise3();

        int[] list3 = array.mergeArray(list1, list2);

        if (list3 != null)
            for (int i = 0; i < list3.length; i++) {
                System.out.print(" " + list3[i]);
            }
    }
}
