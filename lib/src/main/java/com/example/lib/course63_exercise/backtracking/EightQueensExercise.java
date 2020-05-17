package com.example.lib.course63_exercise.backtracking;

/**
 * �˻ʺ�
 */
public class EightQueensExercise {

    //            * * * * * * * Q
    //            * Q * * * * * *
    //            * * * * Q * * *
    //            * * Q * * * * *
    //            Q * * * * * * *
    //            * * * * * * Q *
    //            * * * Q * * * *
    //            * * * * * Q * *
    // �˻ʺ󣺰��а������������̣�����˸����ӣ�ÿ�������������Һ���ֱ�߲��������ӣ������Խ���Ҳ����������
    // �����㷨���ӵ�һ�е��ڰ������ΰڷ����ӣ�ÿһ��ÿһ��ֻ����һ�����ӣ��Խ����жϿ���ֻ�ж��Ѿ��ڷŵ����ӣ����϶Խ��ߵ�����

    /**
     * ����˻ʺ�
     */
    private void getEightQueens() {
        int[] list = new int[8]; // �±��ʾ�У�ֵ��ʾ�У���int[1] = 2 ���� �ڶ��е����з�������
        getEightQueensIn(list, 0);
    }

    private void getEightQueensIn(int[] list, int n) {
        if (n == 8) {
            print(list);
            return;
        }
        // ��n�з�������
        for (int i = 0; i < 8; i++) {
            list[n] = i; // ��������
            if (volid(list, n)) // ��������ӺϷ�
                getEightQueensIn(list, n + 1); // ��һ��
        }
    }

    /**
     * У��˻ʺ�Ϸ���
     *
     * @param list
     * @param n
     * @return
     */
    private boolean volid(int[] list, int n) {
        int current = list[n];
        int leftTop = current - 1; // ���϶Խ��ߵ�ֵ
        int rightTop = current + 1; // ���϶Խ��ߵ�ֵ
        for (int i = n - 1; i >= 0; i--, leftTop--, rightTop++) {
            if (list[i] == current) // ����ͬһ��
                return false;
            if (leftTop >= 0 && list[i] == leftTop) // �ж����϶Խ���
                return false;
            if (rightTop <= 7 && list[i] == rightTop) // �ж����϶Խ���
                return false;
        }
        return true;
    }

    private void print(int[] list) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (list[i] == j) {
                    System.out.print("Q ");
                } else
                    System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void main(String[] args) {
        EightQueensExercise exercise = new EightQueensExercise();
        exercise.getEightQueens();
    }
}
